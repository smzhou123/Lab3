import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class WebScraper {
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

    public static int wordCount(final String contents) {
        String[] wordArray = contents.split(" ");
        return wordArray.length;
    }

    /**
     * Main method.
     * @param unused idk.
     */
    public static void main(String[] args) {
        String contents = (urlToString("http://erdani.com/tdpl/hamlet.txt"));
        System.out.println(contents);
        System.out.println("Word Count: " + wordCount(contents));
    }
}
