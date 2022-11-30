import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'balancedSums' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static String balancedSums(List<Integer> arr) {
    // Write your code here
        int n = arr.size(),Ls = 0;
        if(n==1 || n==0) return "YES";	//if array has only one element
        if(n==2) return "NO";			//if array has two elements
        if(n==3){
            if(arr.get(0) == arr.get(2)) return "YES";
            else return "NO";
        }
        
        List<Integer> Lsum = new ArrayList<Integer>();	//to store left sum 
        Lsum.add(0);									//for the first element left sum is zero
        for(int i=0; i<n; i++){
            Ls+=arr.get(i);
            Lsum.add(Ls);

        }
        
        boolean can = false;
        for(int i=0; i<n+1; i++){
            // System.out.printf("%d ",Lsum.get(i));
            if(i==n) break;									//if there is no left sum equal to the right sum
            if(Lsum.get(i) ==Lsum.get(n)-Lsum.get(i+1)){	//if sum is equal
                can = true;
                break;
            }

        }
                    System.out.printf("\n");
        if(can)return "YES";
        return "NO";
        
        

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result.balancedSums(arr);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
