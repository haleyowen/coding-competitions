import java.util.*;
import java.io.*;

public class Mortar {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("mortar.txt"));
    int times = file.nextInt();
    for(int x = 0; x < times; x++) {
      double distance = file.nextDouble();
      double speed = file.nextDouble();

      double angle = Math.toDegrees(Math.asin(distance * 9.8 / Math.pow(speed, 2))) / 2;
      if(Double.isNaN(angle))
        System.out.println("Impossible");
      else
        System.out.printf("%.3f\n", angle);
    }
  }
}
      
