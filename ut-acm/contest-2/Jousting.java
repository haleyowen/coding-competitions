import java.util.Scanner;
import java.io.File;

public class Cups {
  public static void main(String[]args) throws Exception {
    Scanner file = new Scanner(new File("cups.txt"));
    int times = file.nextInt();

    for(int x = 0; x < times; x++) {
      int n = file.nextInt();
      List<Integer> skills = new ArrayList<Integer>();
      List<Double> percents = new ArrayList<Double>();

      for(int y = 0; y < n; y++) {
        skills.add(file.nextInt());
      }
     
      for(int y = 0; y < skills.size(); y+=2) {
        int a = skills.get(y);
        int b = skills.get(y+1);
        percents.add(findPercentAWinning(a,b));
        percents.add(findPercentBWinning(a));

      }
      ArrayList<Double> winningRounds = new ArrayList<Double>();
      int count = 2;
      while(count < n) {
        for(int i = 0; i < count; i++) {
          
      }
    }
  }

  private static double findPercentAWinning(double a, double b) {
    return a / (a+b);
  }
  private static double findPercentBWinning(double a) {
    return 100 - a;
  }
}
