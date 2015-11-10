import java.util.*;
public class Poker {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    boolean jackpot = true;
    int first = solve(input.nextInt());
    for(int i = 1; i < n; i++) {
      if(solve(input.nextInt()) != first) {
        jackpot = false;
        break;
      }
    }
    if(jackpot)
      System.out.println("YES");
    else
      System.out.println("NO");
  }
  static int solve(int x) {
    while(x % 3 == 0)
      x /= 3;
    while(x % 2 == 0)
      x /= 2;
    return x;
  }
}

