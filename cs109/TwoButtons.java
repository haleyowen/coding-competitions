import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;

public class TwoButtons {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int start = input.nextInt();
    int cur = start;
    int end = input.nextInt();

    ArrayDeque<ArrayList<Integer>> q = new ArrayDeque<ArrayList<Integer>>();
    Set<Integer> visited = new HashSet<Integer>();
    q.add(new ArrayList<Integer>(Arrays.asList(cur,0)));
    int curCount = 0;
    while (cur != end) {
      ArrayList<Integer> c = q.pop();
      cur = c.get(0);
      curCount = c.get(1);
      visited.add(cur);
      if(!visited.contains(cur*2) && cur <= end*2) {
        q.add(new ArrayList<Integer>(Arrays.asList(cur*2, curCount+1)));
        visited.add(cur*2);
      }
      if(!visited.contains(cur-1)) {
        q.add(new ArrayList<Integer>(Arrays.asList(cur-1, curCount+1)));
        visited.add(cur-1);
      }
    }
    System.out.println(curCount);
    //System.out.println((int)(Math.log(count)/Math.log(2)));
  }
}



