package by.it.protsko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        String poem = Poem.text;
        String[] textArray = Poem.text.split("\\n");
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ,\\-!.]{1} ");
        Matcher matcher;
        StringBuilder text = new StringBuilder();

        int maxSentenceLength = 0;
        for (String sentence : textArray) {
            if (sentence.length() > maxSentenceLength) {
                maxSentenceLength = sentence.length();
            }
        }

        for (int i = 0; i < textArray.length; i++) {
            StringBuilder sentence = new StringBuilder(textArray[i]);

            int needConcatSpace = maxSentenceLength - textArray[i].length();

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
                text.append(sentence + "\n");
                //text.append("\n");
            } else {
                continue;
            }
        }

        poem = text.toString();
        System.out.println(poem);
    }


}