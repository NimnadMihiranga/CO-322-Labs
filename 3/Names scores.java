import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        
        Scanner scanner = new Scanner(System.in);
        int namesCount = Integer.parseInt(scanner.nextLine());
        List<String> namesList = new ArrayList<>(namesCount);
        for (int i = 0; i < namesCount; i++)
        {
            String name = scanner.nextLine();
            namesList.add(name);
        }
        Collections.sort(namesList);
        Map<String, Integer> names = new HashMap<>();
        for (int i = 1; i <= namesList.size(); i++)
        {
            names.put(namesList.get(i - 1), i);
        }
        int queries = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < queries; i++)
        {
            String query = scanner.nextLine();
            int score = nameScore(names, query);
            System.out.println(score);
        }
        scanner.close();
    }
 
    private static int nameScore(Map<String, Integer> names, String name)
    {
        int result = 0;
        for (int i = 0; i < name.length(); i++)
        {
            result += name.charAt(i)-'A'+1;
        }
        result *= names.get(name);
        return result;
    }
}