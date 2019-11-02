package by.it.protsko.jd01_05;

import java.util.Scanner;

public class AdditionalTask1 {

    private static Scanner sc;

    public static void main(String[] args) {
        //String line1 = "10 25 369 25 78 787 10358 15315 231 0 -358 12 -325875";

        //step1: ввод чисел с консоли и создание массива введенных чисел
        int[] numberArray = createNumberArray(13);

        //step2: поиск самого короткого и самого длинного из введенных чисел
        searchMinMaxLength(numberArray);

        //step3: сортировка чисел в порядке возрастания их длины
        System.out.print("Массив, отсортированный в порядке возрастания длины чисел: ");
        sortNumbersByLength(numberArray);

        //step4: вывод в консоль чисел с длиной меньше средней


    }

    private static int[] createNumberArray(int n) {
        sc = new Scanner(System.in);
        int[] numberArray = new int[n];
        System.out.print("Введите " + n + " чисел через пробел: ");
        for (int i = 0; i < numberArray.length; i++) {
            numberArray[i] = sc.nextInt();
        }
        return numberArray;
    }

    private static String[] createStringArray(int[] numberArray) {
        String[] strArray = new String[numberArray.length];
        for (int i = 0; i < strArray.length; i++) {
            strArray[i] = Integer.toString(Math.abs(numberArray[i]));
        }
        return strArray;
    }


    private static void searchMinMaxLength(int[] numberArray) {
        String[] stringArray = createStringArray(numberArray);
        String shortestNumber = stringArray[0];
        String longestNumber = stringArray[0];
        for (int i = 0; i < stringArray.length; i++) {
            if (stringArray[i].length() < shortestNumber.length()) {
                shortestNumber = stringArray[i];
            }
            if (stringArray[i].length() > longestNumber.length()) {
                longestNumber = stringArray[i];
            }
        }
        System.out.println("Самое короткое из введенных чисел - " + shortestNumber + ". Длина числа = " + shortestNumber.length());
        System.out.println("Самое длинное из введенных чисел - " + longestNumber + ". Длина числа = " + longestNumber.length());
    }

    private static void sortNumbersByLength(int[] numberArray) {
        String[] stringArray = createStringArray(numberArray);

        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int j = i+1; j < stringArray.length; j++) {
                if (stringArray[i].length() > stringArray[j].length()) {
                    String temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }

        for (int i = 0; i < stringArray.length; i++) {
            System.out.print(stringArray[i] + " ");
        }
    }


}
