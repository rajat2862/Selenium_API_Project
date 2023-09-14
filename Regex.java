package api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        String text = "The roof of the building is leaking.\n" +
                      "There is a doormat on the roof.\n" +
                      "The cottage is painted red.";

        String regex = ".*\\broof\\b.*"; // The word "roof" surrounded by word boundaries

        Pattern patt = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Matcher match = patt.matcher(text);

        while (match.find()) {
            System.out.println("Match found: " + match.group());
        }
    }
}
