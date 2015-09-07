import java.util.Scanner;
public class Palindrome {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int count = input.nextInt();
    for(int x = 0; x < count; x++) {
      String word = input.next();

      System.out.println(getResult(word));
    }
  }

  private static String getResult(String word) {
    StringBuffer sb = new StringBuffer(word);
    for(int i = 0; i < word.length(); i++) {
      sb.setCharAt(i, sb.charAt(word.length()-i-1));
      if(isPalindrome(sb.toString()))
        return "YES";
      sb.setCharAt(i, word.charAt(i));
    }
    return "NO";
  }

  private static boolean isPalindrome(String word) {
    for(int x = 0; x < word.length()/2; x++) {
      if(word.charAt(x) != word.charAt(word.length()-x-1))
        return false;
    }
    return true;
  }
}

