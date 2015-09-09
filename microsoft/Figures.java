import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
public class Figures {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("figure.txt"));

    int count = file.nextInt();

    for(int x= 0; x < count; x++) {
     ArrayList<Integer> list = new ArrayList<Integer>(); 
      for(int i = 0; i < 4; i++) {
        list.add(file.nextInt());

      }
      Collections.sort(list);

      if(list.get(0) + list.get(1) + list.get(2) > list.get(3))
        System.out.println("Possible");
      else 
        System.out.println("Impossible");

    }
  }
}

