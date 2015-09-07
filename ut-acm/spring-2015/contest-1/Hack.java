import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.lang.Integer;

public class Hack {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("hack.txt"));
    int times = file.nextInt();
    for(int x = 0; x < times; x++) {
      int size = file.nextInt();
      int count = file.nextInt();
      String lock = file.next();
      String reset = new String(lock);
      ArrayList<String> keys = new ArrayList<String>();

      for(int y = 0; y < count; y++) {
        keys.add(file.next());
      }

      boolean quit = false;
      ArrayList<ArrayList<String>> permutations = permute(keys);
      System.out.println(permutations.size());
      for(int j = 0; j < permutations.size(); j++) {
        ArrayList<String> cur = permutations.get(j);
        for(int i = 0; i < cur.size(); i++) {

          if(numZeroes(lock) == size) {
            System.out.println("YES");
            quit = true;
            break;
          }
          else {
            lock = xor(lock, cur.get(i), size);
          }
        }
        if(numZeroes(lock) == size) {
          System.out.println("YES");
          quit = true;
          break;
        }
        lock = reset;
        if(quit)
          break;
      }
      if(!quit)
        System.out.println("NO");
    }

  }

  private static String xor(String num1, String num2, int size) {
    int xor = Integer.parseInt(num1, 2) ^ Integer.parseInt(num2, 2);
    String ans = Integer.toString(xor,2);
    while(ans.length() < size) {
      ans = "0" + ans;
    }
    return ans;
  }

  private static int numZeroes(String num) {
    int count = 0; 
    for(int x = 0; x < num.length(); x++) {
      if(num.charAt(x) == '0')
        count++;
    }
    return count;
  }
  private static ArrayList<ArrayList<String>> permute(ArrayList<String> num) {
    ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();

    result.add(new ArrayList<String>());

    for (int i = 0; i < num.size(); i++) {
      ArrayList<ArrayList<String>> current = new ArrayList<ArrayList<String>>();

      for (ArrayList<String> l : result) {
        for (int j = 0; j < l.size()+1; j++) {
          l.add(j, num.get(i));

          ArrayList<String> temp = new ArrayList<String>(l);
          current.add(temp);
          l.remove(j);
        }
      }

      result = new ArrayList<ArrayList<String>>(current);
    }

    return result;
  }
} 
