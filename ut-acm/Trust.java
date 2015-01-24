import java.io.File;
import java.util.Scanner;

public class Trust {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("trust.txt"));
    int times = file.nextInt();

    for(int x = 0; x < times; x++) {
      int bags = file.nextInt();
      int money = file.nextInt();
      int min = file.nextInt();
      int max = file.nextInt();

      if(money < min * bags) 
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
