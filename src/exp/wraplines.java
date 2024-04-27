package exp;

import java.util.*;

public class wraplines {

    //  O(n) time, O(n) space
    public static void main(String[] args) {
        String[] in1 = {"1p3acres", "is", "a", "good", "place", "to", "communicate"};
        // merge words in given array with "-" without exceeding the max length
        // String[] result = {"1p3acres-is", "a-good-place", "to", "communicate"};
        String[] wrappedLines = wrapLines(in1, 12);
        // Print the result
        for (String line : wrappedLines) {
            System.out.println(line);
        }
    }

    // O(n) time, O(n) space
    public static String[] wrapLines(String[] words, int maxLength) {
        StringBuilder currentLine = new StringBuilder();
        List<String> wrappedLines = new ArrayList<>();
        for (String word : words) {
            if (currentLine.length() + word.length() < maxLength) {
                if (currentLine.length() > 0) {
                    currentLine.append("-");
                }
                currentLine.append(word);
            } else {
                wrappedLines.add(currentLine.toString());
                currentLine = new StringBuilder(word); // or currentLine.setLength(0).append(word);
            }
        }
        // Add the last line
        if (currentLine.length() > 0) {
            wrappedLines.add(currentLine.toString());
        }
        return wrappedLines.toArray(new String[0]);
    }
}
