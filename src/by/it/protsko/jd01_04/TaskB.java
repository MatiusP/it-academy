package by.it.protsko.jd01_04;

import java.util.Scanner;

public class TaskB {

    private static Scanner sc;


    public static void main(String[] args) {

        System.out.print("Введите количество сотрудников компании: ");
        sc = new Scanner(System.in);
        String[] employeeArray = fillArray(sc.nextInt());
        int[][] salaryArray = salaryArray(employeeArray);
        printSalaryArray(employeeArray, salaryArray);
        salaryTotal(salaryArray);

    }

    private static void salaryTotal(int[][] salaryArray) {
        int totalSalary = 0;
        int count = 0;

        for (int[] row : salaryArray) {
            for (int element : row) {
                count++;
                totalSalary += element;
            }
        }
        float avarageSalary = (float) totalSalary / count;

        System.out.printf("%-9s%-10d\n", "Итого", totalSalary);
        System.out.printf("%-9s%-12.6f\n", "Средняя", avarageSalary);
    }

    private static String[] fillArray(int employeeCount) {
        String[] array = new String[employeeCount];
        System.out.println("Всего сотрудников " + employeeCount);
        for (int i = 0; i < employeeCount; i++) {
            System.out.print("Введите фамилию " + (i + 1) + " сотрудника: ");
            array[i] = sc.next();
        }
        return array;
    }

    private static void printSalaryArray(String[] employeeArray, int[][] salaryArray) {
        int salarySum = 0;
        System.out.println("\n");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%s\n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------");

        for (int i = 0; i < salaryArray.length; i++) {
            System.out.printf("%-9s", employeeArray[i]);
            for (int j = 0; j < salaryArray[i].length; j++) {
                salarySum += salaryArray[i][j];
                System.out.printf("%-10d", salaryArray[i][j]);
            }
            System.out.printf("%-10d\n", salarySum);
            salarySum = 0;
        }
        System.out.println("------------------------------------------------------");
    }

    private static int[][] salaryArray(String[] employeeArray) {
        int[][] salaryArray = new int[employeeArray.length][4];
        System.out.println();

        for (int i = 0; i < salaryArray.length; i++) {
            System.out.print("Введите поквартально зарплату для " + employeeArray[i] + ": ");
            for (int j = 0; j < salaryArray[i].length; j++) {
                salaryArray[i][j] = sc.nextInt();
            }
        }
        return salaryArray;
    }
}