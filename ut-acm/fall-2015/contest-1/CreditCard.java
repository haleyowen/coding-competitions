import java.util.Scanner;
import java.util.Arrays;
public class CreditCard {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);

    int count = input.nextInt();
input.nextLine();
    for(int x = 0; x < count; x++) {
      String card = input.nextLine();

      int[] numbers = new int[16];
      int index = 0;
      for(int i = 0; i < card.length(); i++) {
        if(card.charAt(i) != '-') {
          numbers[index] = card.charAt(i) - 48;
          if(index % 2==0)
            numbers[index] = numbers[index]*2;
          index++;
        }
      }
      String str = "";
      for(int i = 0; i < numbers.length; i++) {
        str += numbers[i];
      }
      int sum = 0;
      for(int i = 0; i < str.length(); i++) {
        sum += str.charAt(i) - 48;
      }
      if(sum % 10 == 0)
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }

}


