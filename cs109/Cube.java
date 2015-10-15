import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
public class Cube {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);

    Point[] points = new Point[8];

    for(int i = 0; i < 8; i++)
      points[i] = new Point(input.nextInt(), input.nextInt(), input.nextInt());

    isCube(points);

  }

  private static void isCube(Point[] points) {
    HashMap<Point, Integer> occurances = new HashMap<>();

    for(int i = 0; i < 8; i++) {
      Point p = points[i];
      HashSet<Double> distances = new HashSet<Double>();
      double dis = 0;
      for(int j = 0; j < 8; j++) {
        if(i != j) {
          double d = getDistance(points[i], points[j]);
          if(distances.contains(d)) {
            if(occurances.get(points[j]) == null)
              occurances.put(points[j], 0);
            occurances.put(points[j], occurances.get(points[j]) + 1);
          } else {
            distances.add(d);
          }
        }
      }
    }
    System.out.println(occurances);
  }

  private static double getDistance(Point a, Point b) {
    return Math.sqrt(Math.pow(a.x - b.x,2) + Math.pow(a.y - b.y, 2) + Math.pow(a.z - b.z, 2));
  }

}
class Point {
  int x;
  int y;
  int z;

  public Point(int x, int y, int z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
}

