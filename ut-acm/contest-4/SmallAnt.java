import java.util.Scanner;
import java.util.Arrays;

public class Number {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(System.in);
    int count = input.nextInt();
    for(int x = 0; x < count; x++) {
      int numAnts = input.nextInt();
      Map<Double, String> a = new TreeMap<Double, String>();
      for (int y = 0; y < numAnts; y++) {
        a.put(input.nextDouble(), input.next());
      }
      
      double timer = 0;
      ArrayList<Double> ants = new ArrayList<Double>();
      for(double d : a.keySet) {
        if(a.get(d).equals(left))
          ants.add(d*-1);
        else
          ants.add(d); 
      }

      while(ants.size() != 0) {
        double min = Integer.MAX_VALUE;
        double pos = -1;
        for(int i = 0; i < ants.size(); i++) {
          if(ants.get(i) < 0 && ants.get(i+1) > 0 || ants.get(i) > 0 && ants.get(i+1) < 0) {
            double checkMin = (Math.abs(ants.get(i)) + Math.abs(ants.get(i+1)))/2; 
            if(checkMin < min)
              pos = i;
            min = Math.min(checkMin, min); 
          }
          else {
            i++;
          }
        }
        timer += min;


        
    }
  }
}

