package com.interviews;

import java.util.List;
import java.util.Optional;

public class CodingTask {



    public static void main(String[] args) {


        List<Integer> integers = List.of(1,2,3,4);

        Optional<Integer> reduce = integers.stream().reduce(Integer::sum);
        System.out.println(reduce);


        // A - 1 -- Z 26, AA - 27- AB - AZ 52, BA - 53 ZZ 26 * 26 = 676


       // AAA = 676 + 1;


        //bc =


        // 52 -- AZ

        // 53  BA

        // BA -

        // 26- Z
        //
        //353

        //A()- 26
        // BC - 52 + 3

        // BC = 55

        // AA = 27
        //BA = 53
        // AAA = 26 + 26 + 26
        // AAB = 26 + 26 + 27
        //ABA = 26 * 27 + 26
        // 53


// Driver Code

            System.out.print(titleToNumber("CDA"));

        System.out.println(numberToTitle(2133));




    }


    static int titleToNumber(String s) {
        // This process is similar to
        // binary-to-decimal conversion
        int result = 0;
        for (int i = 0; i < s.length(); i++)
        {
            result *= 26;
            result += s.charAt(i) - 'A' + 1;
        }
        return result;
    }

    static String numberToTitle(int num) {

        StringBuilder result = new StringBuilder();
        while (num > 0) {

            int alphabet = num % 26;
            char a = (char) ('A' + alphabet - 1);
            num = num/26;
            result.append(a);
        }
        return result.reverse().toString();
    }




}
