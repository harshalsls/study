package com.study.all.study.dsa.twodarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalsTriangle2 {

    public static void main(String[] args) {
        generate(3);
        getRow(3);
    }

    public static List<Integer> generate(int rowIndex) {
        List<Integer> output = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(output.get(j-1) + output.get(j));
            }
            if(i!=0) {
                list.add(1);
            }
            output = list;
        }
        return output;
    }

    public static List<Integer> getRow(int rowIndex) {
        int[] row = new int[rowIndex + 1];
        row[row.length - 1] = 1;
        // row[row.length - 2] = 1;
        int i = 1;
        while (i <= rowIndex) {
            int startIdx = row.length - 1 - i;
            row[startIdx] = 1;
            startIdx++;
            while (startIdx < row.length - 1) {
                row[startIdx] = row[startIdx] + row[startIdx + 1];
                startIdx++;
            }
            i++;
        }

        List<Integer> pascalsRow = new ArrayList<>();
        for (int n : row) {
            pascalsRow.add(n);
        }
        return pascalsRow;
    }


}
