package by.it.protsko.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

class TaskB {

    public static void main(String[] args) {//start program
         /*
        wr have to write file's data to file and cut comment's
         */

        StringBuilder sb = new StringBuilder();
        sb = printClassToStringBuilder(sb, getFileName(TaskB.class));
        System.out.println(sb.toString());
    }

    /*
    it's just comment's block
     */

    //Открываем и используем файл с произвольным доступом
    private static StringBuilder printClassToStringBuilder(StringBuilder sb, String fileName) {
        try (RandomAccessFile file = new RandomAccessFile(fileName, "rw")) {
            char[] buffer = new char[(int) file.length()];
            while (file.read() != -1) {
                for (char ch : buffer) {
                    ch = (char) file.read();
                    sb.append(ch);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    /**
     * @param: this is our main class
     * @return: fileName
     */
    private static String getFileName(Class<TaskB> bClass) {
        return System.getProperty("user.dir")
                + File.separator + "src" + File.separator
                + bClass
                .getName()
                .replace(".", File.separator) + ".java";
    }
}