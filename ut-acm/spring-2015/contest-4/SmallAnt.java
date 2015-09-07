import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Integer;
import java.lang.Math;
import java.util.Map;
import java.util.TreeMap;

public class SmallAnt {
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
      for(double d : a.keySet()) {
        if(a.get(d).equals("left"))
          ants.add(d*-1);
        else
          ants.add(d); 
      }
        
      int t = 0;
      while(ants.size() != 0) {
        t++;
        double min = Integer.MAX_VALUE;
        double pos = -1;
        int start = 0;
        int end = 0;

        for(int i = 0; i < ants.size(); i++) {
          if(ants.get(i) > 0) {
            start = i;
            break;
          }
        }
        for(int i = ants.size() - 1; i >= 0; i--) {
          if(ants.get(i) < 0)
            end = i;
        }
        for(int i = start; i < end; ) {
          
          if(ants.get(i) < 0 && ants.get(i+1) > 0 || ants.get(i) > 0 && ants.get(i+1) < 0) {
            double checkMin = (Math.abs(ants.get(i+1)) - Math.abs(ants.get(i)))/2; 
            if(checkMin < min)
              pos = i;
            min = Math.min(checkMin, min); 
            i+=2;
          }
          else {
            i++;
          }
        }

        timer += min;

        ArrayList<Integer> posRem = new ArrayList<Integer>();
        for(int i = 0; i < ants.size(); i++) {
          double before = ants.get(i);
          ants.set(i, ants.get(i) + min);
          double after = ants.get(i);
          if(before<0 && after>0 || ants.get(i) > 100)
            posRem.add(i); 
          
          if(i == pos || i == pos + 1)
            ants.set(i, ants.get(i)*-1);
        }
        if(allLeft(ants) && ants.size() > 0) {
          timer+=Math.abs(ants.get(ants.size()-1));
          ants.clear();
        }
        if(allRight(ants) && ants.size() > 0) {
          timer+=Math.abs(ants.get(0));
          ants.clear();
        }
        if(correctDirection(ants)) {
          double max = 0;
          double one = 0;
          double two = 0;
          for(int z = 0; z < ants.size(); z++) {
            if(ants.get(z) > 0) {
              if(z-1 < 0)
                one = ants.get(z);
              else
                one = ants.get(z-1);
              two = ants.get(z);
            }
          } 
          if(Math.abs(one) - 0 > 100 -Math.abs(two))
            timer+= Math.abs(one) - 0;
          else
            timer += 100 - Math.abs(two);
          ants.clear();
        }

        for(int i = posRem.size() -1; i>=0; i--)
          ants.remove(i); 
      }
      System.out.printf("%.5f\n",timer);
    }
  }
    private static boolean allLeft(ArrayList<Double> list) {
      for(int x = 0; x < list.size(); x++)
        if(list.get(x) > 0)
          return false;
      return true;
    }

    private static boolean allRight(ArrayList<Double> list) {
      for(int x = 0; x < list.size(); x++)
        if(list.get(x) < 0)
          return false;
      return true;
    }

    private static boolean correctDirection(ArrayList<Double> list) {
      boolean startRight = false;
      for(int x = 0; x < list.size(); x++) {
        if(list.get(x) > 0)
          startRight = true;
        if(startRight && list.get(x) < 0)
          return false;
      }
      return true;
    } 

}

