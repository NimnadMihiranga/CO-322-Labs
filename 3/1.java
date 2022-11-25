import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
    // Write your code here
    List<Integer> arr2 = new ArrayList<>(arr);  // array for decreasing order

    List<Integer> sortArr = new ArrayList<>(arr);
    List<Integer> sortArrRev = new ArrayList<>(arr);
    Collections.sort(sortArr);
    Collections.sort(sortArrRev, Collections.reverseOrder()); //for sort the array in reverse order
    
    int swap = 0, revSwap = 0;

    for(int i=0; i<arr.size(); i++){  // It is used to count the no. of swap for increasing order
    List<Integer> li = findMinMaxIndex(arr, arr2, i, arr.size()-1);

    int minInd = li.get(0);
    if(arr.equals(sortArr)==false && i != minInd){
        Collections.swap(arr, i, minInd);
        swap++;
        }

    int maxInd = li.get(1); // It is used to count the no. of swap for decreasing order
    if(arr2.equals(sortArrRev)==false && i != maxInd){
        Collections.swap(arr2, maxInd, i);
        revSwap++;
        }

    if(arr.equals(sortArr) && revSwap>swap){
        break;
        }
    if(arr2.equals(sortArrRev) && swap>revSwap){
        break;
        }

    }
        
    return Math.min(swap,revSwap);
    }
    
    
    
public static List<Integer> findMinMaxIndex(List<Integer> arr, List<Integer> arr2, int start, int end){
    int min = Integer.MAX_VALUE, minInd = 0, max = 0, maxInd = 0;
    for(int i=start; i<=end; i++){
        if(arr.get(i) < min){
            min = arr.get(i);
            minInd = i;
        }
         if(arr2.get(i) > max){
            max = arr2.get(i);
            maxInd = i;
        }
    }

    List<Integer> liAns = new ArrayList<>();
    liAns.add(minInd);
    liAns.add(maxInd);

    return liAns;
}


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
