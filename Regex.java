package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String text = "The roof of the house is leaking.\n" +
                      "There is a dog on the roof.\n" +
                      "The room is painted blue.";

        String regex = ".*\\broof\\b.*"; // The word "roof" surrounded by word boundaries

        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            System.out.println("Match found: " + matcher.group());
        }
    }
}
