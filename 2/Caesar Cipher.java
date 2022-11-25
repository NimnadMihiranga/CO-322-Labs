import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void caesarCipher(char[] strArr, int key){
        for(int n=0; n<strArr.length; n++){
            if(key==26) break;
            else if(key>26) key %=26;
            
            if(strArr[n]>='A' & strArr[n]<='Z'){
                if(strArr[n]+key<='Z'){
                    //System.out.println(strArr[n]);
                    strArr[n] = (char)(strArr[n]+key);
                    //System.out.println(strArr[n]);
                    
                }else{
                    strArr[n] = (char)('A'+(key-('Z'-strArr[n]+1)));
                }  
            }
            if(strArr[n]>='a' & strArr[n]<='z'){
                if(strArr[n]+key<='z'){
                    strArr[n] = (char)(strArr[n]+key);
                }else{
                    strArr[n] = (char)('a'+(key-('z'-strArr[n]+1)));
                }  
            }
        }
    }
    
    public static void main(String args[]) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        Scanner input = new Scanner(System.in);
        int strlen = input.nextInt();
        String str = input.next();
        int key = input.nextInt();
        char strArr[] = str.toCharArray();
       // System.out.println(key);
       // System.out.println(strArr);
        caesarCipher(strArr,key);
        System.out.println(strArr);
    }
}