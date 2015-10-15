import java.util.Scanner;
public class Midnight {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();
    
    int low = 0;
    int high = (int)Math.pow(10,9);

    while(low+1 < high) {
      int mid = (low+high)/2;
      int sum = sumation(mid,n,k);

      if(sum >= n)
        high = mid;
      else
        low = mid;
    }
    System.out.println(high);
    

  }
  private static int sumation(int v, int n, int k) {
    int sum = v;
    int e = 1;
    while(Math.floor(v/Math.pow(k,e)) > 0) {
      sum += (int)Math.floor(v/Math.pow(k,e));
      e++;
    }
    return sum;
  }
}


    
