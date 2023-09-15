package com.epam.task;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo {




        public void methodTest(Object object)

        {

            System.out.println("Calling object method");

        }



        public void methodTest(String object)

        {

            System.out.println("Calling String method");

        }


        public static void main(String args[]) throws IOException {

            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("hh"));
                Demo abc=new Demo();

                abc.methodTest(null);



            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }


        }

}
