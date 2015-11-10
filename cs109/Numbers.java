import java.util.*;

public class Numbers {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int k = input.nextInt();

    if(n == 1 && k==0)
        System.out.println(1);
    else if(n==1 && k!=0 || k < n/2)
        System.out.println(-1);
    else {
      int res = k-(n-2)/2;
      System.out.print(res + " " + res*2+" ");
      res = 2*res+1;
      for(int x = 0; x < n-2; x++) {
        System.out.print(res++ +" ");
      }
    }
  }
}

