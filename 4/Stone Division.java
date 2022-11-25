//E/18/180
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'stoneDivision' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. LONG_INTEGER n
     *  2. LONG_INTEGER_ARRAY s
     */

    public static String stoneDivision(long n, List<Long> s) {
    // Write your code here
        Map<Long, Long> map = new HashMap<>();
        map.put(n, 1L);
        
        int lose = solve(map, s, 1);
        if(lose % 2 == 1) {
            return "Second";
        } else {
            return "First";
        }

    }
    
    private static int solve(Map<Long, Long> map, List<Long> s, int round) {
        Set<long[]> solutions = new HashSet<>();
        for(long k: map.keySet()) {
            for(long d: s) {
               if(k % d == 0) {
                   long[] item = new long[2];
                   item[0] = k;
                   item[1] = d;
                   solutions.add(item); 
               }
            }
        }
        if(solutions.isEmpty()) {
            return round;
        }
        
        for(long[] sol: solutions) {
            Map<Long,Long> map2 = new HashMap<>(map);
            if(map2.get(sol[0]) > 1) {
                map2.put(sol[0], map2.get(sol[0])-1);
            } else {
                map2.remove(sol[0]);
            }
            long k = sol[0]/sol[1];
            long num = sol[1] % 2;
            
            if(map2.containsKey(k)) {
                map2.put(k, map2.get(k)+num);
            } else {
                if(num > 0) {
                    map2.put(k, num);
                }
            }
            //System.out.println(map2.toString());
            int lose = solve(map2, s, round+1);
            if(lose % 2 != round % 2) {
                return round+1;
            }
        }
        return round;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        long n = Long.parseLong(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        String[] sTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Long> s = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            long sItem = Long.parseLong(sTemp[i]);
            s.add(sItem);
        }

        String result = Result.stoneDivision(n, s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
