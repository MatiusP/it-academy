package by.it.protsko.jd01_06;

public class TaskC1 {

    public static void main(String[] args) {
        int maxSentenceLength = 0;
        String[] textArray = Poem.text.split("\\n");

        for (String sentence : textArray) {
            if (sentence.length() > maxSentenceLength) {
                maxSentenceLength = sentence.length();
            }
        }
    }
}

//System.out.println(i + ": " +textArray[i]);
//      System.out.println("Максимальная строка в "+maxSentenceLength +" символов");
