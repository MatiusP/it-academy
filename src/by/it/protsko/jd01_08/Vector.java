package by.it.protsko.jd01_08;

import java.util.Arrays;

class Vector extends Var {

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
        return Arrays.toString(value).replace('[', '{').replace(']', '}');
    }
}
