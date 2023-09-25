package com.study.all.study.dsa.twodarray;

import java.util.ArrayList;

public class SpiralTraversal {


    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int rLength = matrix.length;
        int cLength = matrix[0].length;
        ArrayList<Integer> list = new ArrayList();
        int count = 0;
        int row = 0, col = 0;
        int spiralCount = 0, colSpiralCount = 0;
        while (count < rLength * cLength) {
            list.add(matrix[row][col]);
            if (row == spiralCount && col < cLength - colSpiralCount) {
                if (col == colSpiralCount + 1 && col != cLength - 1) {
                    colSpiralCount++;
                }
                col++;
            } else if (col == colSpiralCount + spiralCount && row < rLength - 1) {
                row++;
            } else if (row == rLength - 1 && col > 0) {
                col--;
            } else if (row > spiralCount) {
                row--;
                if (row == spiralCount + 1) {
                    spiralCount++;
                }
            }
            count++;
        }

        System.out.println(list);

    }

}
