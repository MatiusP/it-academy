package by.it.protsko.jd01_04;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        //step1
        printMulTable();

        //step2
        Scanner sc = new Scanner(System.in);
        System.out.print("\nВведите строку из чисел через пробел: ");
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    private static void printMulTable() {
        int count = 0;
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%d*%d=%-3d", i, j, i * j);
                count++;
                if (count == 8) {
                    System.out.println();
                    count = 0;
                }
            }
        }
    }

    private static void buildOneDimArray(String line) {
        int count = 0;
        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] numericArray = new double[stringArray.length];

        for (int i = 0; i < numericArray.length; i++) {
            numericArray[i] = Integer.parseInt(stringArray[i]);
        }
        double firstElement = numericArray[0];
        double lastElement = numericArray[numericArray.length - 1];


        System.out.println();
        for (int i = 0; i < numericArray.length; i++) {
            System.out.printf("%s[% -3d]=%-9.1f", "V", i, numericArray[i]);
            count++;
            if (count == 5) {
                System.out.println();
                count = 0;
            }
        }

        for (int i = 0; i < numericArray.length; i++) {
            double min = numericArray[i];
            int imin = i;
            for (int j = i + 1; j < numericArray.length; j++) {
                if (numericArray[j] < min) {
                    min = numericArray[j];
                    imin = j;
                }
            }
            if (i != imin) {
                double temp = numericArray[i];
                numericArray[i] = numericArray[imin];
                numericArray[imin] = temp;
            }
        }

        System.out.println();
        for (int i = 0; i < numericArray.length; i++) {
            System.out.printf("%s[% -3d]=%-9.1f", "V", i, numericArray[i]);
            count++;
            if (count == 4) {
                System.out.println();
                count = 0;
            }
        }

        System.out.println();
        for (int i = 0; i < numericArray.length; i++) {
            if (numericArray[i] == firstElement) {
                System.out.println("Index of first element=" + i);
            }
            if (numericArray[i] == lastElement) {
                System.out.println("Index of last element=" + i);
            }
        }
    }
}
