import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class GravityFlip {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(System.in);
    int cols = input.nextInt();
    ArrayList<Integer> list = new ArrayList<>();
    for(int x = 0; x < cols; x++)
      list.add(input.nextInt());
    Collections.sort(list);
    for(int i : list)
      System.out.print(i + " ");
    System.out.println();
  }
}

