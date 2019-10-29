package by.it.protsko.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("step1:");
        step1();

        System.out.println("\nstep2:");
        System.out.print("Введите число от 1 до 12: ");
        int month = sc.nextInt();
        step2(month);

        System.out.println("\nstep3:");
        System.out.print("Введите три числа: ");
        step3(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());


    }

    private static void step1() {
        int[][] array = new int[5][5];
        int count = 0;


        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = count + 1;
                count = array[i][j];
            }
        }

        for (int[] masArray : array) {
            for (int element : masArray) {
                System.out.print(element + " ");
            }

        }
    }

    private static void step2(int month) {
        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }

    }


    private static void step3(double a, double b, double c) {
        double discriminant = b * b - (4 * a * c);
        if (discriminant < 0) {
            System.out.println("корней нет");
        }
        if (discriminant == 0) {
            double squareRoot = -b / (2 * a);
            System.out.println("корень уравнения = " + squareRoot);
        }
        if (discriminant > 0) {
            double squareRoot1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double squareRoot2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("корни уравнения:" + squareRoot1 + " " + squareRoot2);
        }


    }


}
