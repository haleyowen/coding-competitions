import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.awt.Point;
public class Maze {
  public static void main(String args []) {
    Scanner input = new Scanner(System.in);
    int rowCount = input.nextInt();
    int colCount = input.nextInt();
    int walls = input.nextInt();

    char[][] maze = new char[rowCount][colCount];
    Point start = new Point();
    boolean set = true;
    for(int r = 0; r < rowCount; r++) {
      String line = input.next();
      for(int c = 0; c < colCount; c++) {
        if(line.charAt(c) == '.' && set) {
          start.setLocation(r,c);
          set = false;
        }
        maze[r][c] = line.charAt(c);
      }
    }
    HashMap<Point, Integer> levels = new HashMap<>();
    HashMap<Integer, ArrayList<Point>> points = new HashMap<>();
    ArrayDeque<Point> q = new ArrayDeque<Point>();
    q.add(start); 
    levels.put(start, 0);
    points.put(0, new ArrayList<Point>(Arrays.asList(start)));
    int newLevel = 0;

    while(q.size() > 0) {
      Point cur = q.pop();
      int x = (int)cur.getX();
      int y = (int)cur.getY();
      newLevel = levels.get(cur)+1;

      Point p = null;
      if(x>0 && maze[x-1][y] != '#') {
        p = new Point(x-1,y);
        if(levels.get(p) == null) {
          q.add(p);
          levels.put(p,newLevel);
          ArrayList<Point> temp = points.get(newLevel);
          if(temp != null) {
            temp.add(p);
            points.put(newLevel, temp);
          } else {
            points.put(newLevel, new ArrayList<Point>(Arrays.asList(p)));
          }
        }
      }
      if(x<rowCount-1 && maze[x+1][y] != '#') {
        p = new Point(x+1,y);
        if(levels.get(p) == null) {
          q.add(p);
          levels.put(p,newLevel);
          ArrayList<Point> temp = points.get(newLevel);
          if(temp != null) {
            temp.add(p);
            points.put(newLevel, temp);
          } else {
            points.put(newLevel, new ArrayList<Point>(Arrays.asList(p)));
          } 
        }
      }
      if(y>0 && maze[x][y-1] != '#') {
        p = new Point(x,y-1);
        if(levels.get(p) == null) {
          q.add(p);
          levels.put(p,newLevel);
          ArrayList<Point> temp = points.get(newLevel);
          if(temp != null) {
            temp.add(p);
            points.put(newLevel, temp);
          } else {
            points.put(newLevel, new ArrayList<Point>(Arrays.asList(p)));
          }
        }
      }
      if(y<colCount-1 && maze[x][y+1] != '#') {
        p = new Point(x,y+1);
        if(levels.get(p) == null) {
          q.add(p);
          levels.put(p,newLevel);
          ArrayList<Point> temp = points.get(newLevel);
          if(temp != null) {
            temp.add(p);
            points.put(newLevel, temp);
          } else {
            points.put(newLevel, new ArrayList<Point>(Arrays.asList(p)));
          }
        }
      }
    }

    for(int i = newLevel-1; i >= 0 && walls > 0; --i) {
      for(Point p : points.get(i)) {
        if(walls > 0) {
          maze[(int)p.getX()][(int)p.getY()] = 'X';
          walls--;
        }
      }
    }
    for(int r = 0; r < rowCount; r++) {
      for(int c = 0; c < colCount; c++) {
        System.out.print(maze[r][c]);
      }
      System.out.println();
    }
  }
}
