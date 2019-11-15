package by.it.protsko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        String poem = Poem.text;
        System.out.println(formatText(poem));
    }

    private static String formatText(String text) {
        String[] textArray = text.split("\\n");
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ,\\-!.] ");
        Matcher matcher;
        StringBuilder formatText = new StringBuilder();

        int maxSentenceLength = 0;
        for (String sentence : textArray) {
            if (sentence.length() > maxSentenceLength) {
                maxSentenceLength = sentence.length();
            }
        }
        for (String element : textArray) {
            StringBuilder sentence = new StringBuilder(element);
            int needConcatSpace = maxSentenceLength - element.length();

            if (sentence.length() < maxSentenceLength) {
                matcher = pattern.matcher(sentence);
                do {
                    if (matcher.find()) {
                        sentence.insert(matcher.start() + 1, ' ');
                        needConcatSpace--;
                    } else {
                        matcher.reset();
                    }
                } while (needConcatSpace != 0);
                formatText.append(sentence);
                formatText.append('\n');
            } else {
                formatText.append(sentence);
                formatText.append('\n');
            }
        }
        return formatText.toString();
    }
}