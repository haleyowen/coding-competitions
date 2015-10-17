import java.util.*;
public class Special {
  public static void main(String[]args) {
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int count = 0;
    for(int x = 0; x < n; x++) {
      int num = input.nextInt();
      for(int y = 2; y <= num; y++)
        if(special(factors(y)))
          count++;
    }
    System.out.println(count);

  }

  static boolean isPrime(int x) {
    for(int i = 2; i < x; i++) {
      if(x%i==0)
        return false;
    }
    return true;
  }

  static ArrayList<Integer> factors(int x) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int i = 2; i < x; i++) {
      if(x%i==0)
        list.add(i);
    }
    return list;
  }

  static boolean special(ArrayList<Integer> list) {
    if(list.size() == 2 && isPrime(list.get(0)) && isPrime(list.get(1)) && list.get(0) != list.get(1))
      return true;
    return false;
  }
}

