import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
//         Scanner input = new Scanner(System.in);
// //         for(int i =0; i<; i++){
            
// //         }
        
//         int numPlayers = input.nextInt();
//         String ranks[] = input.nextLine().split(",");
//         String numGames[] = input.nextLine().split(",");
//         String gameScore[] = input.nextLine().split(",");
//         List<Integer> rankList = new ArrayList<Integer>();
//         rankList = Arrays.asList(ranks);
//         return rankList;
        
        List<Integer> result = new ArrayList<>();
        int currentRank = 1, x=0, rankedSize = ranked.size();

        for (int y = player.size()-1; y >=0; y--) {
            boolean added = false;
            for (; x < rankedSize; x++) {
                int currentRanked = ranked.get(x);
                if (currentRanked <= player.get(y)) {
                    result.add(currentRank);
                    added = true;
                }
                if (added) break;
                if (x < rankedSize-1 && currentRanked != ranked.get(x+1)) currentRank++;
            }
            
            if (!added) result.add(currentRank+1);
        }
        
        Collections.reverse(result);

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] rankedTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> ranked = new ArrayList<>();

        for (int i = 0; i < rankedCount; i++) {
            int rankedItem = Integer.parseInt(rankedTemp[i]);
            ranked.add(rankedItem);
        }

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        String[] playerTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> player = new ArrayList<>();

        for (int i = 0; i < playerCount; i++) {
            int playerItem = Integer.parseInt(playerTemp[i]);
            player.add(playerItem);
        }

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}