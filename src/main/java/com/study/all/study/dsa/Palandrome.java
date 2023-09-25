package com.study.all.study.dsa;

public class Palandrome {

    public static void main(String[] args) {


        int integer = 1221;


        testPalandrome(integer);

    }

    private static boolean testPalandrome(Integer x) {
        if (x <0 || (x !=0 && x %10==0))
            return false;
        int rev = 0;
        while (x >rev){
            rev = rev*10 + x %10;
            x = x /10;
        }
        return (x == rev || x == rev / 10);
    }
}

//   0+5, 50+4,
//     5, 54