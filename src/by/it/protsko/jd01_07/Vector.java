package by.it.protsko.jd01_07;

import java.util.Arrays;

public class Vector extends Var {

    private double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    Vector(String strVector) {
        this.value = stringToDoubleArray(strVector);

    }

    private double[] stringToDoubleArray(String strLine) {
        String[] stringArray = strLine.replaceAll("\\{", "").replaceAll("}", "").split(",");
        double[] doubleArray = new double[stringArray.length];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }

    @Override
    public String toString() {
        StringBuilder stringLine = new StringBuilder("{");
        for (int i = 0; i < value.length; i++) {
            if (i < value.length - 1) {
                stringLine.append(String.valueOf(value[i]).concat(", "));
            } else {
                stringLine.append(String.valueOf(value[i]).concat("}"));
            }
        }
        return stringLine.toString();
    }
}
