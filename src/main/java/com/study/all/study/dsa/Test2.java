package com.study.all.study.dsa;

import org.javatuples.Quartet;

import java.util.ArrayList;
import java.util.List;

public class Test2 {

    public static void main(String[] args) {
        System.out.println(calculateCombinations().toString());
    }

    public static List<Quartet<Integer, Integer, Integer, Integer>> calculateCombinations() {

        List<Quartet<Integer,Integer, Integer, Integer>> combinationList = new ArrayList<>();

        for (int i = 1; i < 24; i++) {

            for (int j = 1; j < 24 ; j++) {

                for (int k = 1; k < 24; k++) {

                    if(i*j*k == 72) {
                        Quartet<Integer, Integer, Integer, Integer> combination = new Quartet<>(i+j+k,i,j,k);
                        combinationList.add(combination);
                    }

                }

            }
        }
        return combinationList;
    }

}


