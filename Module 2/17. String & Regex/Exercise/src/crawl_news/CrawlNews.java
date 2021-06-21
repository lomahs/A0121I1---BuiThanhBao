package crawl_news;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Exercise
 * Package: crawl_news
 * User: lomahs
 * Date time: 18/06/2021 19:14
 * Created with IntelliJ IDEA
 */
public class CrawlNews {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://dantri.com.vn/the-gioi.htm");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");

            String content = scanner.next();
            scanner.close();

            content = content.replaceAll("\\n+","");

            Pattern pattern = Pattern.compile("<a data-utm=\"(.*)\" class=\"(.*)\" title=\"(.*)\" href=\"(.*)\">(.*)</a>");
            Matcher matcher = pattern.matcher(content);

            while (matcher.find()){
                System.out.println(matcher.group(5));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
