import java.util.Scanner;
public class Binary {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    String bin = input.nextLine();
    int count = bin.lastIndexOf("1");

    if(count == 0) {
      System.out.println(bin.length() - 1);
    } else {
      int len = bin.split("0",-1).length;
      System.out.println(len + count + 1);
    }
  }
}

