package by.it.protsko.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] wordsArray = {};
    private static int[] wordCount = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(sb);

        while (matcher.find()) {
            String word = matcher.group();
            int wordPosition = wordPosition(word);
            if (wordPosition >= 0) {
                wordCount[wordPosition]++;
            } else {
                int lastWordsArrayElement = wordsArray.length;
                wordsArray = Arrays.copyOf(wordsArray, lastWordsArrayElement + 1);
                wordCount = Arrays.copyOf(wordCount, wordsArray.length);
                wordsArray[lastWordsArrayElement] = word;
                wordCount[lastWordsArrayElement] = 1;
            }
        }
        for (int i = 0; i < wordsArray.length; i++)
            System.out.println(wordsArray[i] + "=" + wordCount[i]);
    }

    private static int wordPosition(String word) {
        for (int i = 0; i < wordsArray.length; i++) {
            if (wordsArray[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
