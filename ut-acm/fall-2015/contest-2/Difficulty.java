import java.util.*;
import java.io.*;
public class Difficulty {
  public static void main(String[]args) throws Exception {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();

    for(int x = 0; x < n; x++) {
      int count = input.nextInt();
      Map<String, Class> dif = new HashMap<>();
      ArrayList<String> numPreTemp = new ArrayList<>();
      for(int i = 0; i < count; i++) {
        String name = input.next();
        int d = input.nextInt();
        int p = input.nextInt();

        dif.put(name, new Class(d));
        numPreTemp.add(name);

        if(p >= 1) {
          for(int j = 0; j < p; j++) {
            String prename= input.next();
            dif.get(name).pre.add(prename);
          }
        }
      }

      ArrayList<String> numPre = new ArrayList<>();
      for(int z = numPreTemp.size() -1; z >= 0; z--)
        numPre.add(numPreTemp.get(z));

      String maxName = "";
      int max = 0;
      for(String s : numPre) {
        int c = dif.get(s).d; 
        for(String ns : dif.get(s).pre) {
          c += dif.get(ns).d;
        }
        dif.get(s).d = c;
        if(Math.max(max, c) > max) {
          maxName = s;
          max = c;
        }
      }
      System.out.println(maxName + " " + max);
    }
  }
}
class Class {
  int d;
  ArrayList<String> pre;

  public Class(int d) {
    this.d = d;
    pre = new ArrayList<String>();
  }
}

