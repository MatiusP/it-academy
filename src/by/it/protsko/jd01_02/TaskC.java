package by.it.protsko.jd01_02;

import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        System.out.print("Введите размерность массива: ");
        Scanner sc = new Scanner(System.in);
        int arraySize = sc.nextInt();

        //step1
        int[][] array = step1(arraySize);

        //step2
        int sum = step2(array);
        System.out.println("sum = " + sum);

        //step3
    }

    private static int[][] step3(int[][] array) {
        int maxArrayElement = array[0][0];

        for (int[] masArray : array) {
            for (int element : masArray) {
                if (element > maxArrayElement) {
                    maxArrayElement = element;
                }
            }
        }
        return null;
    }


    private static int[][] step1(int n) {

        int[][] array = new int[n][n];
        int minElementSize = -n;
        //int maxElementSize = n;
        int countMin = 0;
        int countMax = 0;

        do {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    array[i][j] = minElementSize + (int) (Math.random() * ((n - minElementSize) + 1));
                    if (array[i][j] == n) {
                        countMax++;
                    }
                    if (array[i][j] == minElementSize) {
                        countMin++;
                    }
                }
            }
        } while (countMin == 0 || countMax == 0);

        for (int[] arrays : array) {
            for (int arraysElement : arrays) {
                System.out.print(arraysElement + " ");
            }
            System.out.println();
        }
        return array;
    }

    private static int step2(int[][] array) {
        int sum = 0;
        int firstPositiveElementIndex;
        int secondPositiveElementIndex;

        for (int i = 0; i < array.length; i++) {
            firstPositiveElementIndex = -1;
            secondPositiveElementIndex = -1;
            for (int j = 0; j < array[i].length; j++) {

                if (array[i][j] > 0) {
                    firstPositiveElementIndex = j;

                    for (int jStep2 = firstPositiveElementIndex + 1; jStep2 < array[i].length; jStep2++) {
                        if (array[i][jStep2] > 0) {
                            secondPositiveElementIndex = jStep2;
                            break;
                        }
                    }

                    if ((secondPositiveElementIndex - firstPositiveElementIndex) == 1) break;

                    if (secondPositiveElementIndex > 0 & secondPositiveElementIndex - firstPositiveElementIndex > 1) {
                        for (int jStep3 = firstPositiveElementIndex + 1; jStep3 < secondPositiveElementIndex; jStep3++) {
                            sum += array[i][jStep3];
                        }
                    }
                }
            }
        }

        return sum;
    }

}


