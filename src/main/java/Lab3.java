import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;

public class Lab3 {

    /**
     * Retrieve contents from a URL and return them as a string.
     *
     * @param url url to retrieve contents from
     * @return the contents from the url as a string, or an empty string on error
     */
    public static String urlToString(final String url) {
        Scanner urlScanner;
        try {
            urlScanner = new Scanner(new URL(url).openStream(), "UTF-8");
        } catch (IOException e) {
            return "";
        }
        String contents = urlScanner.useDelimiter("\\A").next();
        urlScanner.close();
        return contents;
    }

    /**
     * Word Count public static void main(String[] args) { String text =
     * urlToString("http://erdani.com/tdpl/hamlet.txt"); Scanner scan = new Scanner(text); int
     * wordCount = 0; while (scan.hasNext()) { wordCount++; scan.next(); } System.out.println("Word
     * Count: " + wordCount); }
     **/

    /**
    // Counting One Word
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter word to check in document:");
        String compareWord = keyboard.nextLine();
        compareWord = compareWord.toLowerCase();
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        text = text.toLowerCase();

        //Remove Punctuation
        compareWord = compareWord.replaceAll(".,;!?%$#!@#$%^&*()~", "");
        text = text.replaceAll(".,;!?%$#!@#$%^&*()~", "");

        Scanner scan = new Scanner(text);
        int wordCount = 0;
        while (scan.hasNext()) {
            if (compareWord.equals(scan.next()))
                wordCount++;
        }
        System.out.println("Number of Occurences of " + compareWord + ": " + wordCount);
    }
    **/

    //Number of Unique Words
    public static void main(String[] args) {
        String text = urlToString("http://erdani.com/tdpl/hamlet.txt");
        text = text.toLowerCase();

        //Remove Punctuation
        text = text.replaceAll(".,;!?%$#!@#$%^&*()~", "");

        HashSet<String> uniqueWords = new HashSet<String>();

        Scanner scan = new Scanner(text);
        while (scan.hasNext()) {
            uniqueWords.add(scan.next());
        }
        System.out.println("Number of Unique Words of " + uniqueWords.size());
    }

}
