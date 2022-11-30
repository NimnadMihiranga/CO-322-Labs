import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static int beautifulPairs(List<Integer> A, List<Integer> B){
        int max = 0;
        List<Integer> tmp = new ArrayList<Integer>(A);
        for(Integer num:tmp){
            if(A.contains(num) && B.contains(num)){ //if both arrays has the same element
                A.remove(num);
                B.remove(num);
                // System.out.println(num);
                max++;
            }
        }
        if(A.size()>0 && B.size()>0){	//if there are more elements remaining in both arrays then increment the max by one
            max++;
        }
        else if(max == tmp.size()){		//if all the elements in the array are equal then changing the element in a array will decrease the max by one
            max--;
        }
        return max;
    }
    
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner scanner = new Scanner(System.in);
        int numArray = scanner.nextInt();
        List<Integer> A = new ArrayList<Integer>();
        List<Integer> B = new ArrayList<Integer>();
        for(int count=0; count<numArray; count++){	//adding elements to the array A
            A.add(scanner.nextInt());
        }
        for(int count=0; count<numArray; count++){	//adding elements to the array B
            B.add(scanner.nextInt());
        }
        System.out.println(beautifulPairs(A,B));
        // System.out.println(A);
        // System.out.println(B);
        
        
    }
}