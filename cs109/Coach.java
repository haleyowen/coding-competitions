import java.util.*;
public class Coach {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();
    TreeMap<Integer, HashSet<Integer>> teams = new TreeMap<>();
    for(int i = 1; i <= n; i++) {
      teams.put(i, new HashSet<Integer>());
      teams.get(i).add(i);
    }
    for(int x = 0; x < m; x++) {
      int i = input.nextInt();
      int j = input.nextInt();
      teams.get(i).add(j);
      teams.get(j).add(i);
    }
    ArrayList<HashSet<Integer>> res = new ArrayList<>();
    HashSet<Integer> visited = new HashSet<>();
    for(int i = n; i > 0; i--) {
      if(!visited.contains(i) && teams.get(i).size() == 3) {
        res.add(teams.get(i));
        for(int j : teams.get(i))
          visited.add(j);
      }
    }
    if(res.size() == n/3)
      System.out.println(res);
    else if(visisted.size() != n) {
      for(int 
    } else {
      System.out.println(-1);
    }
  }
}


