import java.util.*;
public class Path {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int[] p = new int[n];
    for(int i = 0; i < n; i++) 
      p[i] = input.nextInt()-1;
    long count = 0;
    long mod = 1000000007;
    int[] dp = new int[n];

    for(int i = 0; i < n; i++) {
      dp[i] = 2;
      for(int j = p[i]; j < i; j++) {
        dp[i] += dp[j];
        dp[i] %= mod;
      }
      count += dp[i];
      count %= mod;
    }
    System.out.println(count % mod);
  }
}
