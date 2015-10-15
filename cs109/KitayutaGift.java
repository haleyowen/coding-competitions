import java.util.Scanner;

public class KitayutaGift {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    String word = input.next();
    System.out.println(getResult(word));

  }
  private static String getResult(String word) {
    String newWord = word.substring(0, word.length()/2+1) + word.substring(word.length()/2);
    if(isPalindrome(newWord))
      return newWord;
    return newPalindrome(word);
  }

  private static String newPalindrome(String word) {
    for(int x = 0; x < word.length(); x++) {
      if(isPalindrome(word.substring(0,x)+word.substring(x+1))) {
        int index;
        if (x>word.length()/2)
          index = word.length()-x-1;
        else
          index = word.length()-x;
        return word.substring(0,index)+word.charAt(x)+word.substring(index);
      }
    }
    return "NA";
  }

  private static boolean isPalindrome(String word) {
    for(int x = 0; x < word.length()/2; x++) {
      if(word.charAt(x) != word.charAt(word.length()-x-1))
        return false;
    }
    return true;
  }
}



