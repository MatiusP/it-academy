package by.it.protsko.jd01_05;

import static java.lang.Math.*;

public class TaskA {

    public static void main(String[] args) {

        //step1
        System.out.println(zPartVersion(756.13, 0.3));
        System.out.println(zFullVersion(756.13, 0.3));

        //step2
        System.out.println();
        System.out.println(functionY(1.21, 0.371));

        //step3
        System.out.println();
        for (double a = -5; a <= 12; a += 3.75) {
            System.out.println("Значение функции при a=" + a + " равняется " + functionF(12.1, a));
        }
    }


    private static double zPartVersion(double a, double x) {
        double part1 = cos(pow((pow(x, 2) + PI / 6), 5));
        double part2 = sqrt(x * pow(a, 3));
        double part3 = log(abs((a - 1.12 * x) / 4));

        return part1 - part2 - part3;
    }

    private static double zFullVersion(double a, double x) {
        return cos(pow((pow(x, 2) + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
    }

    private static double functionY(double a, double b) {
        return tan(pow((a + b), 2)) - pow((a + 1.5), (double) 1 / 3) + a * pow(b, 5) - (b / log(a * a));
    }

    private static double functionF(double x, double a) {
        return pow(E, (x * a)) - 3.45 * a;
    }
}
