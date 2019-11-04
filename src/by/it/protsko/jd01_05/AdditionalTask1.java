package by.it.protsko.jd01_05;

import java.util.Scanner;

public class AdditionalTask1 {

    public static void main(String[] args) {
        //String line1 = "10 25 369 25 78 787 10358 15315 231 250 -358 12 -325875";

        //step1: ввод чисел с консоли и создание массива введенных чисел
        int[] numberArray = createNumberArray(5);

        //step2: поиск самого короткого и самого длинного из введенных чисел
        searchMinMaxLength(numberArray);

        //step3: сортировка чисел в порядке возрастания их длины
        System.out.print("Массив, отсортированный в порядке возрастания длины чисел: ");
        sortNumbersByLength(numberArray);

        //step4: вывод в консоль чисел с длиной меньше средней
        System.out.println();
        findNumberMoreEverageLength(numberArray);

        //step5: поиск чисел, в которых количество различных цифр минимально
        searchIdenticalDigits(numberArray);

        //step6: поиск чисел, содержащих только четные цифры
        System.out.println();
        searchNumberWithOnlyEvenDigits(numberArray);

        //step7: поиск чисел, в которых цифры идут в строгом порядке возрастания и вывод последнего найденного числа в консоль
        searchNumberWithSortDigits(numberArray);


    }

    private static int[] createNumberArray(int n) {
        Scanner sc = new Scanner(System.in);
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

        for (String element : stringArray) {
            if (element.length() < shortestNumber.length()) {
                shortestNumber = element;
            }
            if (element.length() > longestNumber.length()) {
                longestNumber = element;
            }
        }
        System.out.println("Самое короткое из введенных чисел - " + shortestNumber + ". Длина числа = " + shortestNumber.length());
        System.out.println("Самое длинное из введенных чисел - " + longestNumber + ". Длина числа = " + longestNumber.length());
    }

    private static void sortNumbersByLength(int[] numberArray) {
        String[] stringArray = createStringArray(numberArray);

        for (int i = 0; i < stringArray.length - 1; i++) {
            for (int j = i + 1; j < stringArray.length; j++) {
                if (stringArray[i].length() > stringArray[j].length()) {
                    String temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }
        for (String element : stringArray) {
            System.out.print(element + " ");
        }
    }

    private static void findNumberMoreEverageLength(int[] numberArray) {
        String[] stringArray = createStringArray(numberArray);
        int sumNumberLength = 0;
        int everageNumberLength;

        for (String element : stringArray) {
            sumNumberLength += element.length();
        }
        everageNumberLength = sumNumberLength / stringArray.length;
        System.out.println("Средняя длина введенных чисел = " + everageNumberLength);
        System.out.println("Числа с длиной меньше средней:");

        for (String element : stringArray) {
            if (element.length() < everageNumberLength) {
                System.out.println(element + " длина числа = " + element.length());
            }
        }
    }

    private static void searchIdenticalDigits(int[] numberArray) {
        char[] digitArray;
        int minCountIdenticalDigits = Integer.MAX_VALUE;
        String[] stringArray = createStringArray(numberArray);
        String numberWithMinIdenticalDigits = stringArray[0];

        for (String element : stringArray) {
            int count = 0;
            if (element.length() > 1) {
                digitArray = element.toCharArray();
                for (int i = 1; i < digitArray.length; i++) {
                    if (digitArray[i] != digitArray[i - 1]) {
                        count++;
                    }
                }
                if (count > 0 & count < minCountIdenticalDigits) {
                    minCountIdenticalDigits = count;
                    numberWithMinIdenticalDigits = element;
                }
            }
        }
        if (minCountIdenticalDigits < Integer.MAX_VALUE) {
            System.out.print("Первое число с минимальным количеством различных цифр =" + numberWithMinIdenticalDigits + ". Количество различных цифр =" + (minCountIdenticalDigits + 1));
        }
    }

    private static void searchNumberWithOnlyEvenDigits(int[] numberArray) {
        char[] digitArray;
        String[] stringArray = createStringArray(numberArray);
        int countNumberWithOnlyEvenDigits = 0;

        for (String element : stringArray) {
            int count = 0;
            if (element.length() > 1) {
                digitArray = element.toCharArray();
                for (char elementDigitArray : digitArray) {
                    if (elementDigitArray % 2 == 0) {
                        count++;
                    }
                }
                if (count == element.length()) {
                    countNumberWithOnlyEvenDigits++;
                }
            }
        }
        if (countNumberWithOnlyEvenDigits == 0) {
            System.out.print("Отсутвуют числа, в которых все цифры четные");
        } else {
            System.out.println("Количество чисел, в которых все цифры четные = " + countNumberWithOnlyEvenDigits);
        }
    }

    private static void searchNumberWithSortDigits(int[] numberArray) {
        char[] digitArray;
        String[] stringArray = createStringArray(numberArray);
        int countNumberWithSortDigits = 0;

        for (int i = stringArray.length-1; i >= 0; i--) {
            int count = 1;
            if (stringArray[i].length() > 1) {
                digitArray = stringArray[i].toCharArray();
                for (int j = 1; j < digitArray.length; j++) {
                    if (digitArray[j - 1] < digitArray[j]) {
                        count++;
                        countNumberWithSortDigits++;
                    }
                }
                if (count == stringArray[i].length()) {
                    System.out.println("В числе " + stringArray[i] + " цифры расположены в порядке возрастания");
                    break;
                }
            }
        }
        if (countNumberWithSortDigits == 0) {
            System.out.println("В введенных числах нет числа, в котором цифры расположены в порядке возрастания");
        }
    }


}
