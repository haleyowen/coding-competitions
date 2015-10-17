import java.util.*;
public class Prime {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();

    for(int i = 0; i < n; i++) {
      int num = input.nextInt();

      int count = 0;
      for(int x = 2; x <= num; x++) {
        if(x%2==0 && isPrime(x)) 
          count++;
      }
      System.out.println(count);
    }
  }
  static boolean isPrime(int x) {
    for(int i = 2; i < x; i++) {
      if(x%i==0)
        return false;
    }
    return true;
  }
}

