package me.mark.tyler.math;

import sun.jvm.hotspot.debugger.cdbg.PointerType;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.HashSet;

/**
 * Created by volkovma on 10/20/16.
 */
public class Tester {

    public static void main(String[] args) {
        double payBasedOntime = (calcPayment(.25));
        double x = 0;
        while (x <= 10) {
            DataPoint point = null;
            if (x == 1) {
                point = new DataPoint(new Point(x, 8.750000000));
            } else {
                point = new DataPoint(new Point(x, round(payBasedOntime + (DataPoint.getDatapoints().isEmpty() ? 0 : DataPoint.getDatapoints().get(DataPoint.getDatapoints().size() - 1).getPoint().getY()))));
            }
            if (x == 6) {
                point.eat();
            }
            DataPoint.addDataPoint(point);
            x += .25;
        }

        for (DataPoint point : DataPoint.getDatapoints()) {
            System.out.println(point.toString());
        }

        System.out.println(DataPoint.getDatapoints().get(DataPoint.getDatapoints().size()-1).toString());

        System.out.println(getEquation(DataPoint.getPoint(1), DataPoint.getPoint(1.5)));
////        for (int i = 0; i <= 95; i++) {
////            System.out.println(getVal(i));
////        }
//
//        System.out.println(print(hasPairWithSum(new int[]{1,1,3,1,1,6,8},10)));


//        System.out.println((Math.pow(Integer.MAX_VALUE,20))< 5 * Math.pow(2,60));

//        for (int i = 0; i < (Math.pow(Integer.MAX_VALUE,20)); i++) {
//            System.out.println("----------");
//            System.out.println("i: " + i);
//            if (i % 3 == 0) {
//                System.out.println(String.valueOf((i*3) + 1));
//            } else if (i % 2 == 0) {
//                System.out.println(String.valueOf(i/2));
//            }
//            System.out.println("----------");
//        }

//        System.out.println(collatz(10));
//        System.out.println(collatz2(10));
    }

    public static String print(boolean val) {
        return val ? "TRUE" : "FALSE";
    }

    public static int collatz(int num) {
        if (num == 1) {
            return 0;
        } else if (num % 2 == 0) {
            return 1 + collatz(num/2);
        } else {
            return 1 + collatz((3*num)+1);
        }
    }

    public static int collatz2(int num) {
        if (num % 2 == 0) {
            return collatz(num/2);
        } else if (num % 3 == 0){
            return collatz((3*num) + 1);
        } else if (num == 1) return num;
        return num;
    }


    public static boolean hasPairWithSum(int[] data, int sum) {
        HashSet<Integer> past = new HashSet<>();
        for (int i = 0; i < data.length; i++) {
            if (past.isEmpty()) {past.add(data[i]);continue;}
            if (past.contains(sum-(data[i]))) {
                return true;
            }
            past.add(data[i]);
        }
        return false;
    }



    public static double round(double x) {
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.HALF_EVEN);
        return Double.valueOf(df.format(x));
    }

    public static String getEquation(DataPoint point1, DataPoint point2) {
        double x1 = point1.getPoint().getX();
        double x2 = point2.getPoint().getX();
        double y1 = point1.getPoint().getY();
        double y2 = point2.getPoint().getY();

        String toReturn = "y=";

        double slope = ((y2-y1)/(x2-x1));


        toReturn+=slope+"x + ";


        toReturn+=(y1/(slope*x1));
        //toReturn+=((y1/(slope*x1))-1);
        return toReturn;
    }

    public static double calcPayment(double time) {
        return (13*time)/1.5;
    }


    public static String getVal(int x) {
        return x <= 20 ? ("X: " + x + " " + ((5*x) + 10)) : ("X: " + x + " " + ((4*x) + 10));
    }


}
