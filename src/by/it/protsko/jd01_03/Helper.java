package by.it.protsko.jd01_03;

class Helper {

    static double findMin(double[] arr) {

        double minArrayValue = arr[0];
        for (double element : arr) {
            if (element < minArrayValue) {
                minArrayValue = element;
            }
        }
        return minArrayValue;
    }

    static double findMax(double[] arr) {
        double maxArrayValue = arr[0];
        for (double element : arr) {
            if (element > maxArrayValue) {
                maxArrayValue = element;
            }
        }
        return maxArrayValue;
    }

    static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    double temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (double element : arr) {
            System.out.print(element + " ");
        }

    }

    static double[] mul(double[][] matrix, double[] vector) {

        double[] mul = new double[matrix.length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] += matrix[i][j] * vector[j];
            }
        }
        return mul;
    }

    static double[][] mul(double[][] leftMatrix, double[][] rightMatrix) {

        double[][] mulMatrix = new double[leftMatrix.length][rightMatrix[0].length];
        for (int i = 0; i < leftMatrix.length; i++) {
            for (int j = 0; j < rightMatrix[0].length; j++) {
                for (int k = 0; k < rightMatrix.length; k++) {
                    mulMatrix[i][j] = mulMatrix[i][j] + leftMatrix[i][k] * rightMatrix[k][j];
                }
            }
        }
                    return mulMatrix;
    }

}
