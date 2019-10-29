package by.it.protsko.jd01_04;

import java.util.Arrays;

public class TaskC {

    public static void main(String[] args) {
        String line = "-3 0 2 -2 -1 5 3 0 -1 6 15";
        buildOneDimArray(line);
    }

    private static void buildOneDimArray(String line) {

        //step1: формированиемассива вещественных чисел из строки
        line = line.trim();
        String[] stringArray = line.split(" ");
        double[] numericArray = new double[stringArray.length];
        for (int i = 0; i < numericArray.length; i++) {
            numericArray[i] = Integer.parseInt(stringArray[i]);
        }

        //step2: вывод числового массива в консоль
        int countColumn = 0;
        System.out.println("Исходный числовой массив:");
        for (int i = 0; i < numericArray.length; i++) {
            System.out.printf("%-1s[% -3d]=%-9.3f", "V", i, numericArray[i]);
            countColumn++;
            if ((countColumn % 5) == 0 || countColumn == numericArray.length) {
                System.out.println();
            }
        }

        //step3: сортировка массива по возрвстанию методом сортировки слиянием
        System.out.println(Arrays.toString(numericArray));
        double[] tempArray = Arrays.copyOf(numericArray, numericArray.length);
        mergeSort(tempArray);

        //step4: поиск новых индексов первого и последнего элемента в исходном массиве
        System.out.printf("Index of first element=%-3d%n", binarySearch(tempArray, numericArray[0]));
        System.out.printf("Index of last element=%-3d%n", binarySearch(tempArray, numericArray[numericArray.length - 1]));
    }


    private static void mergeSort(double[] numericArray) {
        mergeSort(numericArray, 0, numericArray.length - 1);
    }

    private static void mergeSort(double[] array, int firstIndex, int lastIndex) {
        int middleIndex;
        if (firstIndex < lastIndex) {
            middleIndex = (firstIndex + lastIndex) / 2;
            mergeSort(array, firstIndex, middleIndex);
            mergeSort(array, middleIndex + 1, lastIndex);
            merge(array, firstIndex, middleIndex, lastIndex);
        }
    }

    private static void merge(double[] array, int firstIndex, int middleIndex, int lastIndex) {
        int middle = middleIndex + 1;
        int start = firstIndex;
        double[] sortArray = new double[array.length];

        for (int i = start; i <= lastIndex; i++) {
            if (firstIndex <= middleIndex && middle <= lastIndex) {
                if (array[firstIndex] <= array[middle]) {
                    sortArray[i] = array[firstIndex];
                    firstIndex++;
                } else if (array[middle] <= array[firstIndex]) {
                    sortArray[i] = array[middle];
                    middle++;
                }
            } else if (firstIndex > middleIndex) {
                sortArray[i] = array[middle];
                middle++;
            } else {
                sortArray[i] = array[firstIndex];
                firstIndex++;
            }
        }
        if (lastIndex + 1 - start >= 0){
            System.arraycopy(sortArray, start, array, start, lastIndex + 1 - start);
        }
    }

    private static int binarySearch(double[] arr, double value) {
        if (arr.length == 1) {
            return 1;
        }
        int firstIndex = 0;
        int lastIndex = arr.length - 1;
        int index;

        do {
            index = (firstIndex + lastIndex) / 2;
            if (arr[index] > value) {
                lastIndex = index - 1;
            }
            if (arr[index] < value) {
                firstIndex = index + 1;
            }
        } while (arr[index] != value);
        return index;
    }
}



