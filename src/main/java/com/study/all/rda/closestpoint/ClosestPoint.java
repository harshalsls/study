package com.study.all.rda.closestpoint;

import java.text.DecimalFormat;

public class ClosestPoint {
    // Driver code
    public static void main(String[] args) {
        Point[] P = new Point[]{
                new Point(2, 3),
                new Point(12, 30),
                new Point(40, 50),
                new Point(5, 1),
                new Point(12, 10),
                new Point(3, 4)

        };

        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println("The smallest distance is " +
                df.format(Point.closest(P, P.length)));
    }
}
