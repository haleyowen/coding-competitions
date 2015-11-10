import java.util.*;
import java.io.*;
public class Pi {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(new File("h.txt"));
    int times = input.nextInt();
    for(int i = 0; i < times; i++) {
      input.nextInt();
      System.out.println(input.nextInt() + " " + 5);
    }
  }
}

