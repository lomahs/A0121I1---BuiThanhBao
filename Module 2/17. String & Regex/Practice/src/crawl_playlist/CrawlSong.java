package crawl_playlist;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Project: Practice
 * Package: crawl_playlist
 * User: lomahs
 * Date time: 18/06/2021 18:04
 * Created with IntelliJ IDEA
 */
public class CrawlSong {

    public static void main(String[] args) {
        try{
            URL url = new URL("https://www.nhaccuatui.com/bai-hat/nhac-tre-moi.html");

            Scanner scanner = new Scanner(new InputStreamReader(url.openStream()));
            scanner.useDelimiter("\\Z");

            String content = scanner.next();
            scanner.close();

//            System.out.println(content);
            Pattern p = Pattern.compile("name_song\">(.*?)</a>");
            Matcher m = p.matcher(content);

            while (m.find()){
                System.out.println(m.group(1));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
