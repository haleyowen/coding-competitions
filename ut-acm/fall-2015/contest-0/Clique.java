import java.util.Scanner;

public class Clique {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int t = input.nextInt();

    for(int x = 0; x < t; x++) {
      int n = input.nextInt();
      int m = input.nextInt();

      int[][] friends = new int[n][n];
      for(int y = 0; y < m; y++) {
        int one = input.nextInt()-1;
        int two = input.nextInt()-1;

        friends[one][two] = 1;
        friends[two][one] = 1;
      }
      int count = 0;
      for(int r = 0; r < n; r++) {
        for(int c = 0; c < n; c++) {
          if(friends[r][c] == 1)
            count++;
        }
      }
      count = count/2;
      
      if(count == factorial(n) || count == 0)
        System.out.println(count);
      else
        System.out.println(count+1);
    }
  }

  private static int factorial(int n) {
    int fac = 1;
    for(int x = 1; x <= n; x++) 
      fac *= x;
    return fac;
  }
}
          

