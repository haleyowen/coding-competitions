import java.util.Scanner;

public class Tetrahedron {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    long prevD = 1;
    long prevABC = 0;
    long mod = 1000000007;

    for(int x = 0; x < n; x++) {
      long d = prevABC * 3;
      long abc = (prevABC * 2 + prevD);
      prevD = d % mod;
      prevABC = abc % mod;
    }

    System.out.println(prevD);
  }
}

