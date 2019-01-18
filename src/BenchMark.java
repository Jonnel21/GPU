
/**
 * This class is to represent
 * the model for the data
 */
import java.io.*;
import java.text.SimpleDateFormat;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class BenchMark {

    public BenchMark() {
    }

    public BenchMark(String name, String fileType) {
    }

    public BenchMark(String name, String date, String time) {
    }

    public static void main(String[] args) {
        File input = new File("test.html");
        
        System.out.println("Last Date Modified: " + input.lastModified());
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        System.out.println("Last Date Modified: " + sdf.format(input.lastModified()));

       
        try {
            Document doc = Jsoup.parse(input, "UTF-8", "");
            //System.out.println(doc.toString());

            Elements title = doc.getElementsByTag("title");
            System.out.println(title.text());

            Elements res = doc.getElementsByClass("result");
            System.out.println(res.text());


        } catch (IOException e) {
            e.printStackTrace();
        }

        

    }
    
}