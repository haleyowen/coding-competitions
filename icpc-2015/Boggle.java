import java.util.*;
import java.io.*;
public class Boggle {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(new File("i.txt"));
    int dc = input.nextInt();
    HashSet<String> dict = new HashSet<>();
    for(int i = 0; i < dc; i++)
      dict.add(input.next());
    while(true) {
      int size = input.nextInt();
      if(size == 0) {
        break;
      }

      char[][] boggle = new char[size][size];
      for(int r = 0; r < size; r++)
        boggle[r] = input.next().toCharArray();

      TreeSet<String> ans = new TreeSet<>();
      for(String d : dict) {
        if(solve(boggle, d))
          ans.add(d);
      }

      for(String s : ans)
        System.out.println(s);
      System.out.println("-");
    }
  }

  public static boolean solve(char[][] boggle, String word) {
    for(int r = 0; r < boggle[0].length; r++) {
      for(int c = 0; c < boggle[0].length; c++) {
        if(solve(boggle, word, "", r, c, 0))
            return true;
      }
    }
    return false;
  }

  public static boolean solve(char[][] boggle, String word, String res, int r, int c, int i) {
    if(word.equals(res))
      return true;
    if(res.length() > word.length())
      return false;

    int size = boggle[0].length;
    if(r < size && r >= 0 && c < size && c >=0 && boggle[r][c] == word.charAt(i)) {

      String next;
      int inc = 1;
      if(boggle[r][c] == 'q') {
        next = res + "qu";
        inc = 2;
      }
      else
        next = res + word.charAt(i);

      return solve(boggle, word, next, r+1, c, i+inc) || 
        solve(boggle, word, next, r, c+1, i+inc) ||
        solve(boggle, word, next, r-1, c, i+inc) ||
        solve(boggle, word, next, r, c-1, i+inc) ||
        solve(boggle, word, next, r+1, c+1, i+inc) || 
        solve(boggle, word, next, r+1, c-1, i+inc) ||
        solve(boggle, word, next, r-1, c+1, i+inc) ||
        solve(boggle, word, next, r-1, c-1, i+inc);
    }
    return false;
  }
} 
