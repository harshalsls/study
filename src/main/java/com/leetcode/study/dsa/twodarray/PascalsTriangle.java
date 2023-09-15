package com.leetcode.study.dsa.twodarray;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {

    public static void main(String[] args) {
        generate(5);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> list = new ArrayList<>(i);
            int count = 0;
            while (count <= i) {
                if(count == 0 || count == i) {
                    list.add(1);
                } else {
                    list.add(0);
                }
                count++;
            }

            for (int j = 1; j < i; j++) {

               list.set(j, output.get(i-1).get(j-1) + output.get(i-1).get(j));

            }

            output.add(i, list);

        }
        return output;

    }


}
