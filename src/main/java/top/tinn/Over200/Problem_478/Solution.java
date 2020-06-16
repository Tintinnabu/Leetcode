package top.tinn.Over200.Problem_478;

import java.util.Random;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/16
 */
public class Solution {

    private double radius;
    private double x;
    private double y;
    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x = x_center;
        this.y = y_center;
    }

    public double[] randPoint() {
        double d = radius * Math.sqrt(Math.random());
        double theta = Math.random() * 2 * Math.PI;
        return new double[]{d * Math.cos(theta) + x, d * Math.sin(theta) + y};
    }
}
