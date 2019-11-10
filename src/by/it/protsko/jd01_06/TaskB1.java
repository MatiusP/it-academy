package by.it.protsko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static final String consonants = "бвгджзйклмнпрстфхцчшщ";
    private static final String vowels = "ауоыиэяюёе";
    private static char[] consonatsArray = consonants.toCharArray();
    private static char[] vowelsArray = vowels.toCharArray();

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);

        while (matcher.find()) {
            String word = matcher.group();

            if (isWordValid(word)) {
                sb.append(word);
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    private static boolean isWordValid(String word) {
        int countConsonant = 0;
        int countVowels = 0;
        word = word.toLowerCase();
        for (char element : consonatsArray) {
            if (element == word.charAt(0)) {
                countConsonant++;
                break;
            }
        }
        for (char element : vowelsArray) {
            if (element == word.charAt(word.length() - 1)) {
                countVowels++;
                break;
            }
        }
        return countConsonant > 0 & countVowels > 0;
    }
}
