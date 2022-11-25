import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class balancedSums {

    public static String balancedsums(List<Integer> arr) {
        Collections.sort(arr);
        for(int count=arr.size()-2; count>0; count--){
            int sumL=0, SumR=0;
            for(int i = count+1; i<arr.size()-1; i++){
                sumR = arr[i];
            }
        }
    }

    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int numTest = scanner.nextInt();
        for (int testCount = 0; testCount < numTest; testCount++) {
            List<Integer> arr = new ArrayList<Integer>();
            int arrNum = scanner.nextInt();
            for (int count = 0; count < arrNum; count++) {
                arr.add(scanner.nextInt());
            }
            System.out.println(balancedsums(arr));
        }
        scanner.close();
    }
}