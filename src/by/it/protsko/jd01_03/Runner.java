package by.it.protsko.jd01_03;

public class Runner {

    public static void main(String[] args) {

        String line = "72 88 1 13 18 156 3";

        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "array", 3);

        double minArrayElement = Helper.findMin(array);
        System.out.println("\nМинимальный элемент массива = " + minArrayElement);
        double maxArrayElement = Helper.findMax(array);
        System.out.println("\nМаксимальный элемент массива = " + maxArrayElement);

        System.out.print("\nОтсортированный массив: ");
        Helper.sort(array);


        System.out.println();
        double[][] matrix = {
                {1.25, 384.0, 3.56},
                {2.41, 18.04, 19.82},
                {38.21, 15.25, 3.0}
        };
        double[] vector = {1.25, 2.5, 3.0};

        double[] mul = Helper.mul(matrix, vector);
        for (int i = 0; i < mul.length; i++) {
            System.out.printf("%s [% -3d]=%-5.3f", "mul", i, mul[i]);
            System.out.println();
        }

        double[][] leftMatrix = {
                {1.25, 384.0, 3.56},
                {2.41, 18.04, 19.82},
        };

        double[][] rightMatrix = {
                {1.25, 384.0},
                {2.41, 18.04},
                {38.21, 15.25},

        };

        double[][] mulMatrix = Helper.mul(leftMatrix, rightMatrix);
        for (double[] row : mulMatrix) {
            for (double element : row) {
                System.out.println(element);
            }
        }
    }
}
