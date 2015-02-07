import java.util.Scanner;
import java.io.File;
import java.util.List;
import java.util.ArrayList;
public class Chicken {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("chicken.txt"));
    int times = file.nextInt();

    for(int x = 0; x < times; x++) {
      int numFarmers = file.nextInt();
      int wingCount = file.nextInt();
      int drumCount = file.nextInt();
      int breastCount = file.nextInt();

      List<int[]> farmers = new ArrayList<int[]>();

      for(int y = 0; y < numFarmers; y++) {
        int wings = file.nextInt();
        int drums = file.nextInt();
        int breasts = file.nextInt();
        int cost = file.nextInt();

        int[] arr = {wings, drums, breasts, cost};
        farmers.add(arr);
      }

      
    }
  }
}

