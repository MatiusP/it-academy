package by.it.protsko.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        int[] array = new int[10];
        Scanner sc;

        System.out.println("Введите массив из 10 чисел: ");
        sc = new Scanner(System.in);

        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }

        step1(array);
        step2(array);
        step3(array);
    }

    private static void step1(int[] array) {
        int min = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] array) {
        int sumElements = 0;

        for (int element : array) {
            sumElements += element;
        }
        double avg = sumElements / array.length;

        for (int value : array) {
            if (value < avg) {
                System.out.print(value + " ");
            }
        }

    }

    private static void step3(int[] array) {
        int min = array[0];

        for (int element : array) {
            if (min > element){
                min = element;
            }
        }

        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == min){
                System.out.print(i + " ");
            }
        }
    }

}
