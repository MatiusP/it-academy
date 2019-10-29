package by.it.protsko.jd01_03;

class InOut {

    static double[] getArray(String line) {

        line = line.trim();
        String[] stringArray = line.split(" ");
        int stringArrayLengs = stringArray.length;

        double[] doubleArray = new double[stringArrayLengs];
        for (int i = 0; i < doubleArray.length; i++) {
            doubleArray[i] = Double.parseDouble(stringArray[i]);
        }
        return doubleArray;
    }


    static void printArray(double[] arr) {
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    static void printArray(double[] arr, String name, int columnCount) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-9.1f", name, i, arr[i]);
            count++;

            if (count % 3 == 0 || count == arr.length) {
                System.out.println();
            }
        }

    }


}
