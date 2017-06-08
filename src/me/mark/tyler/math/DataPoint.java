package me.mark.tyler.math;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by volkovma on 10/20/16.
 */
public class DataPoint {

    public static List<DataPoint> datapoints = new ArrayList<>();

    private double payment;

    private Point point;

    public DataPoint(double payment, Point point) {
        this.payment = payment;
        this.point = point;
    }

    public DataPoint(Point point) {
        this.point = point;
    }

    public DataPoint eat() {
        this.point.setY(this.point.getY()+8.5);
        return this;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }

    public static DataPoint addDataPoint(DataPoint point) {
        datapoints.add(point);
        return point;
    }

    public static List<DataPoint> getDatapoints() {
        return datapoints;
    }


    public static DataPoint getPoint(double x) {
        for (DataPoint point : datapoints) {
            if (point.getPoint().getX() == x) {
                return point;
            }
        }
        return null;
    }


    @Override
    public String toString() {
        return "X: " + this.point.getX() + " " + "Y: " + this.point.getY();
    }
}
