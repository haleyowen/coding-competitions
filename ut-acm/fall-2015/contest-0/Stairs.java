import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;

public class Stairs {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);

    int t = input.nextInt();
    for(int x = 0; x < t; x++) {
      int n = input.nextInt();
      int k = input.nextInt();

      ArrayList<Integer> counts = new ArrayList<>();
      for(int y = 0; y < k; y++) {
        counts.add(input.nextInt());
      }
      ArrayDeque<Integer> q = new ArrayDeque<>();
      q.add(0);
      int cur = 0;
      int count = 0;
      while(q.size() > 0) {
        cur = q.pop();

        if(cur == n)
          count++;

        for(int i = 0; i < counts.size(); i++) { 
          if(cur+counts.get(i) <= n) {
            q.add(cur+counts.get(i));
          }
        }
      }
      System.out.println(count);

    }
  }
}

