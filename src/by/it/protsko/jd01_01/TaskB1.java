package by.it.protsko.jd01_01;

import java.util.Scanner;

public class TaskB1 {

    public static void main(String[] args) {
        Scanner sc;

        do {
            System.out.print("Введите число: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                int i = sc.nextInt();
                System.out.println("Квадрат числа " + i + " = " + (i * i));
                break;
            } else System.out.println("Неверный ввод! Попробуйте еще раз.");
        } while (!sc.hasNextInt());

    }
}
