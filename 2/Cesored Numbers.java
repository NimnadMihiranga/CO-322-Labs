import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    static void sort(int arr[]){
        int  len= arr.length;
        for (int i = 1; i < len; ++i) {
            int key = arr[i];
            int j = i - 1;
 
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
    
    public static int[] closestNumbers(int arr[]){
        int len = arr.length;
        sort(arr);
        int[] diffArr = new int[len-1];
        int minDif = Integer.MAX_VALUE;
        for(int count=0; count<len-1; count++){
            diffArr[count] =  Math.abs(arr[count+1] - arr[count]);
            if(diffArr[count] < minDif){
                minDif = diffArr[count];
                // index = count;
                // difCount =1;
            }
            // else if(diffArr[count] == minDif){
            //     difCount=+2;
            // }
        }
        //System.out.println(difCount+1);
        /*int[] retArr = new int[difCount+1];
        for(int count=0,nIndex=1; count<len-1; count++){
            if(diffArr[count] ==minDif){
                retArr[nIndex-1] = arr[count]; 
                retArr[nIndex] = arr[count+1];
                //System.out.println(retArr[nIndex-1]);
            }
        }*/
        for(int count=0; count<len-1; count++){
            //diffArr[count] =  Math.abs(arr[count+1] - arr[count]);
            //System.out.println(count);
            if(diffArr[count] == minDif){
                count++;
            }
            else if(count == len-2){
                arr[count] = Integer.MAX_VALUE;
                arr[count+1] = Integer.MAX_VALUE;
            }
            else{
                arr[count]= Integer.MAX_VALUE;
            }
        }
        return arr;
    }
    
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        int lenArr = input.nextInt();
        int[] arr = new int[lenArr];
        //System.out.println(lenArr);
        for(int count=0; count<lenArr ; count++){
            arr[count] = input.nextInt();
            //System.out.println(arr[count]);
        }
        arr = closestNumbers(arr);
        //System.out.println(retArr.length);
        for(int count=0; count<arr.length ; count++){
            if(arr[count] != Integer.MAX_VALUE)
            System.out.printf("%d ",arr[count]);
            //System.out.println(arr[count]);
        }
        
    
    }
    
}
