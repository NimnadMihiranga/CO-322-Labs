import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'activityNotifications' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY expenditure
     *  2. INTEGER d
     */

    public static int activityNotifications(List<Integer> expenditure, int d) {
    // Write your code here
        int notificationCount = 0;
        // Track the frequency of numbers indexed from 0 to 200
        int[] freqArr = new int[201];
        for (int i = 0; i < d; i++) {
            freqArr[expenditure.get(i)]++;
        }

        int[] medianArr = new int[d];
        for (int startIdx = d; startIdx < expenditure.size(); startIdx++) {
            // Track the numbers needed to find median
            // Update medianArr with the data to find median from
            int pointer = 0;
            for (int i = 0; i < 201; i++) {
                int j = freqArr[i];
                while (j > 0) {
                    medianArr[pointer] = i;
                    pointer++;
                    j--;
                }
            }
            int currentDayExpenditure = expenditure.get(startIdx);
            double medianExpenditure = getMedianExpenditure(medianArr);
            if (currentDayExpenditure >= 2 * medianExpenditure) {
                ++notificationCount;
            }
            // Remove previous data
            freqArr[expenditure.get(startIdx - d)]--;
            // Add new data
            freqArr[expenditure.get(startIdx)]++;
        }
        return notificationCount;
    }

    private static double getMedianExpenditure(int[] arr) {
        int size = arr.length;
        if (size % 2 == 0) {
            return (arr[size / 2] + arr[(size / 2) - 1]) / 2.0;
        }
        return arr[size / 2];
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        String[] expenditureTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> expenditure = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureTemp[i]);
            expenditure.add(expenditureItem);
        }

        int result = Result.activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
