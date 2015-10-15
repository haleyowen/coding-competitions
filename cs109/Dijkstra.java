import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class Dijkstra {
  static int[][] cost;
  static int[] dist;
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);

    int vsize = input.nextInt();
    int esize = input.nextInt();

    Map<Integer, List<Edge>> adjList = new HashMap<>();
    for(int x = 0; x < esize; x++) {
      int r = input.nextInt() - 1;
      int c = input.nextInt() - 1;
      int w = input.nextInt();

      if(adjList.get(r) == null)
        adjList.put(r, new ArrayList<Edge>());
      if(adjList.get(c) == null)
        adjList.put(c, new ArrayList<Edge>());

      adjList.get(r).add(new Edge(new Node(c),w));
      adjList.get(c).add(new Edge(new Node(r),w));
    }

    System.out.println(dijkstra(adjList, new Node(0), new Node(esize)));


  }

  static int dijkstra(Map<Integer, List<Edge>> adjList, Node start, Node goal) {
    final Map<Node, Integer> dists = new HashMap<Node, Integer>();  

    PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
      public int compare(Node a, Node b) {
        Integer aDist = dists.get(a);
        if(aDist == null)
          aDist = Integer.MAX_VALUE;
        Integer bDist = dists.get(b);
        if(bDist == null)
          bDist = Integer.MAX_VALUE;
        return aDist = bDist;
      }
    });

    dists.put(start, 0);
    pq.offer(start);
    while(!pq.isEmpty()) {
      Node cur = pq.poll();
      if(cur == goal)
        return dists.get(goal);
      for(Edge e : adjList.get(cur)) {
        int newDist = dists.get(cur) + e.weight;
        if(!dists.containsKey(e.val) || dists.get(e.val) > newDist) {
          dists.put(e.val, newDist);
          pq.add(e.val);
        }
      }
    }
    return -1;
  }
}
class Node {
  int val;
  List<Edge> edges;
  public Node(int v) {
    val = v; 
    edges = new ArrayList<Edge>();
  }

}

class Edge {
  Node val;
  int weight;
  public Edge(Node v, int w) {
    val = v;
    weight = w;
  }
}




