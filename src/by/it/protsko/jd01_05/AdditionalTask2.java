package by.it.protsko.jd01_05;

import static java.lang.Math.random;

public class AdditionalTask2 {

    public static void main(String[] args) {

        //step1: формирование матрицы
        int[][] numberMatrix = createMatrix(5);
        for (int[] row : numberMatrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(int n) {
        int[][] matrix = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = -n + (int) (random() * ((n - (-n)) + 1));
            }
        }
        return matrix;
    }

}