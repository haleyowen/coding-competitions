import java.util.Scanner;

public class Ribbon {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int len = input.nextInt();
    int a = input.nextInt();
    int b = input.nextInt();
    int c = input.nextInt();
    int max = Integer.MIN_VALUE;

    for(int x = 0; x <= len; x++) {
      for(int y = 0; y <= len; y++) {
        int ax = a*x;
        int by = b*y;
        if(ax + by <= len) {
          int temp = len - (ax + by);
          if(temp % c == 0) {
            temp /= c;
            max = Math.max(max, x+y+temp);
          }
        }
      }
    }
    System.out.println(max);
  }
}

