import java.util.Scanner;
import java.lang.Integer;
import java.io.File;

public class Radix {
  public static void main(String[]args)  throws Exception {
    Scanner file = new Scanner(new File("radix.txt"));
    while(file.hasNextLine()) {
      String line = file.nextLine();

      String[] arr = line.split(",");
      System.out.println(getResult(arr));
    }
  }

  private static String getResult(String[] arr) {
    String number = arr[0];
    try {
      Long.parseLong(number, Integer.parseInt(arr[1]));
    } catch (Exception e) {
      return "Invalid Input";
    }
    if(Long.parseLong(number, Integer.parseInt(arr[1])) < -2147483648 || Long.parseLong(number, Integer.parseInt(arr[1])) > 2147483647)
      return "Invalid Input";
    else if(!number.matches("[a-z0-9]*"))
      return "Invalid Input";
    else if(!(Integer.parseInt(arr[1]) >= 2 && Integer.parseInt(arr[1]) <= 36 && Integer.parseInt(arr[2]) >= 2 && Integer.parseInt(arr[2]) <= 36))
      return "Invalid Input";
    else
      return Integer.toString(Integer.parseInt(number, Integer.parseInt(arr[1])), Integer.parseInt(arr[2]));
  }
}
