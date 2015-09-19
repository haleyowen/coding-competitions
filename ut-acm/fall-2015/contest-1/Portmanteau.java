import java.util.List;
import java.util.TreeSet;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Collections;
public class Portmanteau {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);

    int count = input.nextInt();

    for(int x=0; x < count; x++) {
      int n = input.nextInt();
      int k = input.nextInt();


      ArrayList<String> words = new ArrayList<String>();
      for(int y = 0; y < n; y++) {
        words.add(input.next());
      }


      TreeMap<String, List<String>> starts = new TreeMap<>();
      TreeMap<String, List<String>> ends = new TreeMap<>();


      for(int i = 0; i < words.size(); i++) {
        if(words.get(i).length() >= k) {
          String s = words.get(i).substring(0, k);
          String e = words.get(i).substring(words.get(i).length() - k);

          if(starts.get(s) == null) {
            starts.put(s, new ArrayList<String>());
          }
          if(ends.get(e) == null)
            ends.put(e, new ArrayList<String>());

          starts.get(s).add(words.get(i));
          ends.get(e).add(words.get(i));
        }
      }

      TreeSet<String> result = new TreeSet<String>();
      for(String s : starts.keySet()) {
        if(ends.containsKey(s)) {
          List<String> endOptions = ends.get(s);
          List<String> startOptions = starts.get(s);

          for(int e = 0; e < endOptions.size(); e++) {
            for(int si = 0; si < startOptions.size(); si++) {

              if(!endOptions.get(e).equals(startOptions.get(si))) {
                String w = endOptions.get(e) + startOptions.get(si).substring(k);
                result.add(w);
              }
            }
          }
        }
      }
      System.out.println(result.size());
      for(String s : result) {
        if(!words.contains(s))
          System.out.println(s);
      }

    }
  }
}



