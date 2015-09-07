import java.util.Scanner;

public class Primes {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int count = input.nextInt();

    for(int x = 0; x < count; x++) {
      String num = input.next();

      System.out.println(getResult(num));
    }
  }

  private static String getResult(String num) {
    for(int i = 0; i < num.length(); i++) {
      for(int j = 1; j <= num.length()-i; j++) {
        if(isPrime(Integer.parseInt(num.substring(i,j+i))))
          return "YES";
      }
    }
    return "NO";
  }

  private static boolean isPrime(int num) {
    if(num <= 1)
      return false;
    for(int x = 2; x < num; x++) {
      if(num % x==0)
        return false;
    }
    return true;
  }
}
