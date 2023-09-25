package com.study.all.study.dsa.twodarray;

public class SimpleTraversing {


    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3,10},{4,5,6,11},{7,8,9,12}};
        simpleTraverse(a);
    }

    public static void simpleTraverse(int[][] a) {

        for (int i = 0; i <a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.println(a[i][j]);
            }

        }

    }

}
