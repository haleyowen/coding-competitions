import java.util.Scanner;
public class Chess {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int count = 0;
    int c = 0;
    boolean go = true;

    for(int x = 0; x < 8; x++) {
      String line = input.nextLine();

      int temp = 0;
      for(int y = 0; y < line.length(); y++) {
        if(line.charAt(y) == 'B') {
          temp++;
        }
      }
      if(temp == 8)
        count += 1;
      else if(go) {
        c += temp; 
        go = false;
      }
    }
    System.out.println(count + c);
  }
}

