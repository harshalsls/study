package com.study.all.rda.mystery;

public class MysteryProblem {

    static int  count = 0; // This is just to check the number of calls

    public static void main(String[] args) {
        int[] A = {3,7,2,4};
        int x = 7;
        int low = 0;
        int high = A.length-1;
        System.out.println(Mystery(x, low, high, A));
        System.out.println(count);
    }


    static int Mystery(int x, int low, int high, int[] A) {

        if(x == 0) {
            return 1;
        }

        int n = high - low + 1;

        if (x < 0 || n == 0) {
            return 0;
        }


        int mystery1 = Mystery(x - A[low], low, high, A);
        int mystery2 = Mystery(x, low + 1, high, A);

        return  mystery1 + mystery2 ;
    }



}
