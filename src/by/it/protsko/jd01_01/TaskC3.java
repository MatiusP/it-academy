package by.it.protsko.jd01_01;

import java.util.Scanner;

public class TaskC3 {

    private final static double WEIGHT_IN_MARS = (3.86 / 9.81);

    private static double getWeight(int i) {

        return (double) Math.round(i * WEIGHT_IN_MARS * 100d) / 100d;
    }


    public static void main(String[] args) {
        System.out.print("Введите вес человека в килограммах: ");
        int weight = new Scanner(System.in).nextInt();

        System.out.println("Вес человека на марсе составит " + TaskC3.getWeight(weight));
    }

}
