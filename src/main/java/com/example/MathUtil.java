package com.example;

public class MathUtil {
    static int mdc(int a, int b){
        int maior=Math.max(a, b);
        b=Math.min(a, b);
        a=maior;
        if(b>0 && a%b==0){
            return b;
        }
        if(b==0){
            return Math.abs(a);
        }
           
        return -1;
    }
}
