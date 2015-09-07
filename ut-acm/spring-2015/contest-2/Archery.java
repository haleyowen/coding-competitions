import java.util.Scanner;
import java.io.File;

public class Archery {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("archery.txt"));
    int times = file.nextInt();
    for(int i = 0; i < times; i++) {
      int n = file.nextInt();
      int result = 0;
      for(int j = 0; j < n; j++) {
        double x = file.nextDouble();
        double y = file.nextDouble();

        double radius = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));

        if(radius <= 5)
          result += 100;
        else if(radius <= 10)
          result += 50;
        else if(radius <= 15)
          result += 25;
        else if(radius <= 20)
          result += 10;
      }
      System.out.println(result);
    }
  }
}
