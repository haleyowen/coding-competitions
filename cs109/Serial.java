import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
public class Serial {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int z = input.nextInt();
    int x = input.nextInt();
    int y = input.nextInt();
    input.nextLine();
    char[][][] g = new char[x][y][z];
    boolean[][][] v = new boolean[x][y][z];

    for(int i = 0; i < z; i++) {
      input.nextLine();
      for(int j = 0; j < x; j++) {
        String line = input.nextLine();
        for(int k = 0; k < y; k++) {
          g[j][k][i] = line.charAt(k);
        }
      }
    }
    input.nextLine();

    int row = input.nextInt() - 1;
    int col = input.nextInt() - 1;

    Queue<Point> q = new LinkedList<>();

    q.add(new Point(row, col, 0));
    v[row][col][0] = true;

    int[] xNext = {1, 0, -1, 0, 0, 0};
    int[] yNext = {0, 1, 0, -1, 0, 0};
    int[] zNext = {0, 0, 0, 0, -1, 1};

    int count = 1;
    while(!q.isEmpty()) {
      Point cur = q.poll();
      int xc = cur.x;
      int yc = cur.y;
      int zc = cur.z;

      for(int i = 0; i < 6; i++) {
        int xn = xNext[i]+xc;
        int yn = yNext[i]+yc;
        int zn = zNext[i]+zc;
        if(xn >= 0 && xn < x && yn >= 0 && yn < y && zn >=0 && zn < z && !v[xn][yn][zn] && g[xn][yn][zn] == '.') {
          q.add(new Point(xn,yn,zn));
          v[xn][yn][zn] = true;
          count++;
        }
      }

    }
    System.out.println(count);
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


