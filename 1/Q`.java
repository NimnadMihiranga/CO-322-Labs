import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;



public class Solution {
    
    public static int grades(int mark){
        if(mark<38) return mark;
        int nMul = (mark/10)*10+5;
        if(nMul<mark) nMul+=5;
        if(Math.abs(nMul-mark)<3) return nMul;
        else return mark;
    }
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        
        Scanner scaner = new Scanner(System.in);
        int numStudents = scaner.nextInt();
        
        for(int count=0; count<numStudents; count++){
            int mark = scaner.nextInt();
            int nMark = grades(mark);
            System.out.println(nMark);
            
        }
        
    }
    
    
}