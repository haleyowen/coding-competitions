import java.util.Scanner;
import java.io.File;

public class Cups {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("cups.txt"));
    int times = file.nextInt();

    for(int x = 0; x < times; x++) {
      int cups = file.nextInt();
      int swaps = file.nextInt();

      int[] arr = new int[cups];
      for(int y = 0; y < arr.length; y++)
        arr[y] = y;

      for(int y = 0; y < swaps; y++) {
        int indexOne = file.nextInt();
        int indexTwo = file.nextInt();

        int temp = arr[indexTwo];
        arr[indexTwo] = arr[indexOne];
        arr[indexOne] = temp;
      }

      for(int y = 0; y < arr.length; y++) {
        if(arr[y] == 0)
          System.out.println(y);
      }
    }
  }
}
