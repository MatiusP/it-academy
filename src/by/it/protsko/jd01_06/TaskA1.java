package by.it.protsko.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern pattern = Pattern.compile("[а-яёА-ЯЁ]{4,}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            sb.setCharAt(matcher.start() + 3, '#');
            if (matcher.group().length() > 6) {
                sb.setCharAt(matcher.start() + 6, '#');
            }
        }
        System.out.println(sb);
    }
}
