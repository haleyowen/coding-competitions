import java.util.*;
import java.io.*;
public class Morse {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(new File("f.txt"));
    Map<Character, String> dict = new HashMap<>();
    for(int i = 0; i < 26; i++) {
      dict.put(input.next().charAt(0), input.next());
    }

    int size = input.nextInt();
    input.nextLine();
    HashMap<String, String> valid = new HashMap<>();
    for(int i = 0; i < size; i++) {
      String cur = input.nextLine();
      valid.put(convert(cur, dict), cur);
    }

    while(true) {
      int times = input.nextInt();
      input.nextLine();
      if(times == 0)
        break;

      System.out.println(solve(times, valid, input));
    }
  }

  public static String solve(int times, Map<String, String> valid, Scanner input) {
    String res = "";
    for(int i = 0; i < times; i++) {
      String cur = input.nextLine();
      if(valid.containsKey(cur))
        res += valid.get(cur) + " ";
      else {
        for(int j = i+1; j < times; j++)
          input.nextLine();

        return cur + " not in dictionary.";
      }
    }
    return res;
  }

  public static String convert(String word, Map<Character, String> dict) {
    String res = "";
    for(int i = 0; i < word.length(); i++) {
      res += dict.get(word.charAt(i));
    }
    return res;
  }
}

