import java.util.*;
import java.io.*;
public class PositiveConSequences {
    public static void main(String[]args) throws Exception {
        Scanner input = new Scanner(new File("e.txt"));
        boolean done = false;
        while(!done) {
            int[] arr = new int[4];
            int count = 0;
            int index = -1;
            for(int i = 0; i < 4; i++){
                arr[i] = input.nextInt();
                if(arr[i] == -1) {
                    count++;
                    index = i;
                }
                if(count > 1) {
                    done = true;
                    break;
                }
            }
            if(done)
                break;
            System.out.println(solve(arr, index));
        }
    }
    public static int solve(int[] arr, int index) {
        int add;
        int mult;
        if(index < 2) {
            add = arr[3] - arr[2];
            mult = arr[3]/arr[2];
        } else {
            add = arr[1] - arr[0];
            mult = arr[1]/arr[0];
        }

        if(index == 0)
            arr[0] = arr[1] - add;
        else
            arr[index] = arr[index-1]+add;

        boolean done = true;
        for(int i = 0; i < 3; i++) {
            if(arr[i]+add != arr[i+1]) {
                done = false;
            }
        }
        if(done){
            if(arr[index] > 0 && arr[index] < 10000)
                return arr[index];
        } else 
            done = true;

        if(index == 0)
            arr[0] = arr[1] / mult;
        else
            arr[index] = arr[index-1]*mult;

        for(int i = 0; i < 3; i++) {
            if(arr[i]*mult != arr[i+1]) {
                done = false;
            }
        }
        if(done) 
            if(arr[index] > 0 && arr[index] <= 10000)
                return arr[index];
        return -1;
    }
}
