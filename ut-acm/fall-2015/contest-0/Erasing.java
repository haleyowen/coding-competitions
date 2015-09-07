import java.util.Scanner;
public class Erasing {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int count = input.nextInt();

    for(int x = 0; x < count; x++) {
      boolean canSwitch = true;
      String output = "YES";
      for(int i = 1; i <= 4; i++) {
        int num = input.nextInt();
        if(i != num && canSwitch) {
          canSwitch = false;
        } else if (i != num && !canSwitch) {
          output = "NO";
        }
      }
      System.out.println(output);
    }
  }
}



