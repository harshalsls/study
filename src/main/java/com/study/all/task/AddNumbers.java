package com.study.all.task;

public class AddNumbers {

    public static void main(String[] args) {


    char[] number1 = "54,66,436".toCharArray();
    char[] number2 = "75,31,568".toCharArray();

    int sum = 0;
    StringBuilder sumNumber = new StringBuilder();
    int carry = 0;

        for (int i = number1.length - 1; i >= 0 ; i--) {
            if(number1[i] == ',' || number2[i]== ',') {
                continue;
            }
            sum = Integer.parseInt(String.valueOf(number1[i])) + Integer.parseInt(String.valueOf(number2[i])) + carry;
            carry = sum / 10;
            sumNumber.append(sum%10);
        }
        sumNumber.append(carry);
        char[] outputNumber = sumNumber.toString().toCharArray();
        int count = 0;
        boolean isCommaAdded = false;

        StringBuilder summedNumber = new StringBuilder();

        while (count < outputNumber.length) {

            if(isCommaAdded && count % 2 != 0) {
                summedNumber.append(",");
            } else if (count == 3) {
                summedNumber.append(",");
                isCommaAdded = true;
            }
            summedNumber.append(outputNumber[count]);
            count++;
        }

        System.out.println(summedNumber.reverse());
        //1,29,98,004
    }



}
