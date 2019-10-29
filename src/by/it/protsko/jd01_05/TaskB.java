package by.it.protsko.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {

        //task4
        functionY();

        //task5
        functionA();


    }

    private static void functionY() {
        double y;
        for (double a = 0; a <= 2; a += 0.2) {
            y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.println("Значение при a=" + a + " составляет " + y);
        }
    }

    private static void functionA() {
        double function;
        double b;
        for (double x = -5.5; x < 2; x += 0.5) {
            b = 0;
            if (x / 2 > -2 & x / 2 <= -1) {
                b = sin(x * x);
            }
            if (x / 2 > -1 & x / 2 < 0.2) {
                b = cos(x * x);
            }
            if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
            }
            if (b == 0) {
                System.out.println("При х=" + x / 2 + " значение не определено!");
            } else {
                function = log10(abs(b + 2.74));
                System.out.println("При х=" + x / 2 + " значение функции составит" + function);
            }
        }
    }
}
