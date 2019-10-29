package by.it.protsko.jd01_05;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {

        //task6
        double[] arrayA = elementArrayFromFunction();
        printArray(arrayA, "A");
        double[] arrayB = createNewArray(arrayA);
        printArray(arrayB, "B");
        getAverageValueArrayElements(arrayB);

        //task7

    }

    private static int getRundomNumber(int min, int max) {
        return min + (int) (random() * ((max - min) + 1));
    }

    private static double[] elementArrayFromFunction() {
        int randomNumber = getRundomNumber(20, 40);
        double[] array = new double[randomNumber];

        double rangeOfFunctionValues = (9 - 5.33) / (randomNumber - 1);
        int count = 0;

        for (double x = 5.33; x <= 9; x += rangeOfFunctionValues) {
            double functionZ = pow((x * x + 4.5), (double) 1 / 3);
            array[count] = functionZ;
            count++;
        }
        System.out.println("Сгенерированное случайное число = " + randomNumber);
        return array;
    }

    private static void printArray(double[] array, String nameArray) {
        int count = 0;
        System.out.println("\tArray " + nameArray + "[]");
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%5s[% -3d] = %-9.8f", nameArray, i, array[i]);
            count++;

            if (count % 5 == 0 || count == array.length) {
                System.out.println();
            }
        }
    }

    private static double[] createNewArray(double[] arrayA) {
        int indexFirstElementArrayB = 0;

        for (int i = 0; i < arrayA.length; i++) {
            if (arrayA[i] > 3.5) {
                indexFirstElementArrayB = i;
                break;
            }
        }

        double[] arrayB = new double[arrayA.length - indexFirstElementArrayB];
        System.arraycopy(arrayA, indexFirstElementArrayB, arrayB, 0, arrayB.length);
        return arrayB;
    }

    private static void getAverageValueArrayElements(double[] array) {
        double sum = 0;
        for (double element : array) {
            sum += element;
        }
        System.out.println("Среднее арифметическое значение элементов массива = " + sum / array.length);
    }
}
