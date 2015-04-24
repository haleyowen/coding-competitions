import java.util.Scanner;
import java.util.Arrays;

public class Number {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(System.in);
    int count = input.nextInt();
    for(int x = 0; x < count; x++) {
      char[] num = input.next().toCharArray();
      Arrays.sort(num);
      for(int y = num.length - 1; y>=0; y--)
        System.out.print(num[y]);
      System.out.println();
    }
  }
}

