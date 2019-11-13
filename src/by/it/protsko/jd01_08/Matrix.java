package by.it.protsko.jd01_08;

import java.util.Arrays;

class Matrix extends Var {

    private double[][] value;

    Matrix(double[][] value) {
        this.value = copyTwoDimensionalArrays(value);
    }

    Matrix(Matrix matrix) {
        this.value = copyTwoDimensionalArrays(matrix.value);
    }

    Matrix(String matrix) {
        this.value = copyStringToDimensionalArray(matrix);
    }


    private double[][] copyTwoDimensionalArrays(double[][] array) {
        double[][] newArray = new double[array.length][];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = Arrays.copyOf(array[i], array[i].length);
        }
        return newArray;
    }

    private double[][] copyStringToDimensionalArray(String stringLine) {
        String newStringLine = stringLine.replaceAll("\\{", "").replaceAll(" ", "").replaceAll("},", "}");
        String[] stringArray = newStringLine.split("}");
        double[][] doubleArray = new double[stringArray.length][];

        for (int i = 0; i < stringArray.length; i++) {
            String[] rowStringArray = stringArray[i].split(",");
            doubleArray[i] = new double[rowStringArray.length];
            for (int j = 0; j < doubleArray[i].length; j++) {
                doubleArray[i][j] = Double.parseDouble(rowStringArray[j]);
            }
        }
        return doubleArray;

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                str.append(Arrays.toString(value[i]).concat(", "));
            } else {
                str.append(Arrays.toString(value[i]).concat("}"));
            }
        }
        str = new StringBuilder(str.toString().replaceFirst("\\{" + 1, "{{").replace('[', '{').replace(']', '}'));
        return str.toString();
    }
}
