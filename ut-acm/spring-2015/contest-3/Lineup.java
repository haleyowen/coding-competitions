import java.util.*;
import java.io.*;

public class Lineup {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(new File("lineup.txt"));

    int times = input.nextInt();

    for(int x = 0; x < times; x++) {
      List<Soldier> soldiers = new ArrayList<Soldier>();
      
      int count = input.nextInt();
      for(int y = 0; y < count; y++) {
        String first = input.next();
        String last = input.next();
        double height = input.nextDouble();
        input.nextLine();

        soldiers.add(new Soldier(first, last, height));
      }
      Collections.sort(soldiers);
      System.out.println("Test Case #" + (x+1) + ":");
      for(Soldier s : soldiers) {
        System.out.println(s);
      }
    }
  }

  public static class Soldier implements Comparable<Soldier> {
    public String first;
    public String last;
    public double height;

    public Soldier(String f, String l, double h) {
      first = f;
      last = l;
      height = h;
    }
    @Override
    public int compareTo(Soldier other) {
      if(height > other.height)
        return 1;
      else if (height < other.height)
        return -1;
      else if(last.length() > other.last.length())
        return 1;
      else if(last.length() < other.last.length())
        return -1;
      else if(last.compareTo(other.last) != 0)
        return last.compareTo(other.last);
      else if(first.length() > other.first.length())
        return 1;
      else if(first.length() < other.first.length())
        return -1;
      return first.compareTo(other.first);
    }
  
    public String toString() {
      return first + " " + last;
    }
  }
}
