import java.util.*;

public class Woodcutters {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long[] c = new long[n];
    long[] h = new long[n];
    for(int x = 0; x < n; x++) {
      c[x] = input.nextLong();
      h[x] = input.nextLong();
    }
    System.out.println(solve(n, c, h));
  }
  static long solve(int n, long[] c, long[] h) {
    if(n==1)
      return 1;
    long count = 2;
    long cur = c[0];
    for(int i = 1; i < n-1; i++) {
      long diff = c[i]-h[i];
      long add = c[i]+h[i];

      if(diff > c[i-1] && diff > cur) {
        count++;
        cur = c[i];
      } else if(add < c[i+1] && add > cur) {
        count++;
        cur = add;
      }
    }
    return count;
  }
}


