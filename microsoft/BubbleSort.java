import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class BubbleSort {
  public static void main(String[]args)  throws Exception {
    Scanner file = new Scanner(new File("bubble.txt"));
    ArrayList<Integer> t = new ArrayList<Integer>();
    while(file.hasNextInt()) {
      t.add(file.nextInt());
    }
    int[] arr = new int[t.size()];

    for(int i = 0; i < arr.length; i++)
      arr[i] = t.get(i);

    int numSwaps = 0;
    int temp;
    for(int i=0; i < arr.length-1; i++){

      for(int j=1; j < arr.length-i; j++){
        if(arr[j-1] > arr[j]){
          temp=arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
          numSwaps++;
        }
      }
    }
    System.out.println(numSwaps);
    for(int x : arr)
      System.out.print(x + " ");
    System.out.println();
  
  }
}
