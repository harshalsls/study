package com.study.all.study.dsa.twodarray;

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
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(output.get(i-1).get(j-1) + output.get(i-1).get(j));
            }
            if(i!=0) {
                list.add(1);
            }
            output.add(list);
        }
        return output;
    }


}
