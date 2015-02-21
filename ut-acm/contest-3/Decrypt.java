import java.util.*;
import java.io.*;

public class Decrypt {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("decrypt.txt"));
    int times = file.nextInt();

    for(int x = 0; x < times; x++) {
      int n = file.nextInt();
      int c = file.nextInt();

      String magic = file.next();
      String chksum = file.next();

      String bin = file.nextLine();

      for(int y = 0; y < c; y++)
        bin += "0";
      
      for(int i = 0; i < n; i++) {
        if(findChecksum(bin, n, magic, c).equals(chksum))
          System.out.println(i);
      }
    }
  }
  private static String findChecksum(String s, int size, String magic, int msize) {
    for(int i = 0; i < size - msize; i = s.indexOf("1")) {
      String temp = s.substring(i, i + msize);

      if(Integer.parseInt(temp, 2) != 0 && i + msize < size) {
        String hold = Integer.toString(Integer.parseInt(temp, 2) ^ Integer.parseInt(magic, 2), 2);
        for(int x = hold.length(); x < msize; x++)
          hold = "0" + hold;

        s = s.substring(0, i) + hold + s.substring(i + msize);
      }

      if(s.indexOf("1") == -1)
        i = size;
    }

    return s.substring(msize);
  }
}
