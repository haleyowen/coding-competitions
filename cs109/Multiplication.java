import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Multiplication {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    long n = input.nextInt();
    long m = input.nextInt();
    long k = input.nextLong();
    long low = 0;
    long high = n * m;
    long count = 0;

    while(low < high){
      long mid = (low + high)/2;
      count = 0;
      for(int i =1 ; i <= n; i++){
        count += Math.min(m, mid/i);
      }
      if(count < k)
        low = mid + 1;
      else 
        high = mid;
    }
    System.out.println(low);
  }
}
