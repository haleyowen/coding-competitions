import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Ball {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    ArrayList<Integer> boys = new ArrayList<Integer>();
    ArrayList<Integer> girls = new ArrayList<Integer>();

    int numBoys = input.nextInt();
    for(int i = 0; i < numBoys; i++)
      boys.add(input.nextInt());
    Collections.sort(boys);

    int numGirls = input.nextInt();
    for(int i = 0; i < numGirls; i++) 
      girls.add(input.nextInt());
    Collections.sort(girls);

    int bIndex = 0;
    int gIndex = 0;
    int result = 0;

    while(bIndex < numBoys && gIndex < numGirls) {
      if(boys.get(bIndex) - girls.get(gIndex) > 1) {
        gIndex++;
      } else if(girls.get(gIndex) - boys.get(bIndex) > 1) {
        bIndex++;
      } else {
        bIndex++;
        gIndex++;
        result++;
      }
    }
    System.out.println(result);
  }
}
    
