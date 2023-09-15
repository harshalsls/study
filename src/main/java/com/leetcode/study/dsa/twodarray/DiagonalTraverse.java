package com.leetcode.study.dsa.twodarray;

public class DiagonalTraverse {

    public static void main(String[] args) {
        int[][] a = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        diagonalTraverse(a);
    }

    public static void diagonalTraverse(int[][] arr) {

        int nRow = arr.length;
        int nCol = arr[0].length;
        int[] result = new int[nRow*nCol];

        int row = 0, col = 0;
        boolean up = false;
        int interator = 1;

        result[0] = arr[row][col];
        result[result.length-1] = arr[nRow-1][nCol-1];
        col++;

        while (interator < result.length) {

            if(up) {
                while (row > 0 && col < nCol -1) {
                    result[interator] = arr[row][col];
                    interator++;
                    row --;
                    col ++;
                }
                if(col == nCol -1) {
                    row ++;
                }
            } else {
                while (col > 0 && row < nRow -1) {
                    result[interator] = arr[row][col];
                    interator++;
                    row ++;
                    col --;
                }
                if(row == nRow -1) {
                    col --;
                }
            }
            up = !up;

        }





    }
}
