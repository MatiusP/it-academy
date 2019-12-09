package by.it.protsko.calc;

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

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] resultMatrix = new double[this.value.length][];
            for (int i = 0; i < resultMatrix.length; i++) {
                resultMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] += scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        }

        if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length) {
            boolean isMatrixEquals = true;
            for (int i = 0; i < this.value.length; i++) {
                if (this.value[i].length != ((Matrix) other).value[i].length) {
                    isMatrixEquals = false;
                    break;
                }
            }
            if (isMatrixEquals) {
                double[][] resultMatrix = new double[this.value.length][];
                for (int i = 0; i < resultMatrix.length; i++) {
                    resultMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
                }
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[i].length; j++) {
                        resultMatrix[i][j] += ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] resultMatrix = new double[this.value.length][];
            for (int i = 0; i < resultMatrix.length; i++) {
                resultMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] -= scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        }

        if (other instanceof Matrix && this.value.length == ((Matrix) other).value.length) {
            boolean isMatrixEquals = true;
            for (int i = 0; i < this.value.length; i++) {
                if (this.value[i].length != ((Matrix) other).value[i].length) {
                    isMatrixEquals = false;
                    break;
                }
            }
            if (isMatrixEquals) {
                double[][] resultMatrix = new double[this.value.length][];
                for (int i = 0; i < resultMatrix.length; i++) {
                    resultMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
                }
                for (int i = 0; i < resultMatrix.length; i++) {
                    for (int j = 0; j < resultMatrix[i].length; j++) {
                        resultMatrix[i][j] -= ((Matrix) other).value[i][j];
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.sub(other);
    }


    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();
            double[][] resultMatrix = new double[this.value.length][];
            for (int i = 0; i < resultMatrix.length; i++) {
                resultMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] *= scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        }

        if (other instanceof Vector && this.value[0].length == ((Vector) other).getValue().length) {
            double[][] newThisMatrix = new double[this.value.length][];
            for (int i = 0; i < newThisMatrix.length; i++) {
                newThisMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            double[] newVector = new double[((Vector) other).getValue().length];
            System.arraycopy(((Vector) other).getValue(), 0, newVector, 0, ((Vector) other).getValue().length);

            double[] resultMatrix = new double[newThisMatrix.length];
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < newVector.length; j++) {
                    resultMatrix[i] += newThisMatrix[i][j] * newVector[j];
                }
            }
            return new Vector(resultMatrix);
        }

        if (other instanceof Matrix) {
            boolean isMatrixEquals = true;
            for (double[] element : this.value) {
                if (element.length != ((Matrix) other).value.length) {
                    isMatrixEquals = false;
                    break;
                }
            }
            if (isMatrixEquals) {
                double[][] newThisMatrix = new double[this.value.length][];
                for (int i = 0; i < newThisMatrix.length; i++) {
                    newThisMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
                }
                double[][] newOtherMatrix = new double[((Matrix) other).value.length][];
                for (int i = 0; i < newOtherMatrix.length; i++) {
                    newOtherMatrix[i] = Arrays.copyOf(((Matrix) other).value[i], ((Matrix) other).value[i].length);
                }
                double[][] resultMatrix = new double[newThisMatrix.length][newOtherMatrix[0].length];

                for (int i = 0; i < newOtherMatrix.length; i++) {
                    for (int j = 0; j < newThisMatrix[0].length; j++) {
                        for (int k = 0; k < newThisMatrix.length; k++) {
                            resultMatrix[i][j] = resultMatrix[i][j] + newThisMatrix[i][k] * newOtherMatrix[k][j];
                        }
                    }
                }
                return new Matrix(resultMatrix);
            }
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar) {
            double scalarValue = ((Scalar) other).getValue();

            double[][] resultMatrix = new double[this.value.length][];
            for (int i = 0; i < resultMatrix.length; i++) {
                resultMatrix[i] = Arrays.copyOf(this.value[i], this.value[i].length);
            }
            for (int i = 0; i < resultMatrix.length; i++) {
                for (int j = 0; j < resultMatrix[i].length; j++) {
                    resultMatrix[i][j] = scalarValue;
                }
            }
            return new Matrix(resultMatrix);
        }
        return super.div(other);
    }
}
