
/**
 * This class is to represent
 * the model for the data
 */
import java.io.*;
import java.util.HashMap;
//import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class BenchMark {

    private String title;
    private String fileType;
    private String date;
    private String time;
    private String fps;
    private String score;
    private String minFps;
    private String maxFps;
    private String result;
    private List<String> table;
    private Map<String, String> map;

    public BenchMark(File file) {
        parseHtml(file);
    }

    public BenchMark(String title, String fileType) {
    }

    public BenchMark(String title, String date, String time) {
        this.title = title;
        this.date = date;
        this.time = time;
    }

    // getter methods
    public String getTitle(){return this.title;}
    public String getFileType(){return this.fileType;}
    public String getDate(){return this.date;}
    public String getTime(){return this.time;}
    public String getFps(){return this.fps;}
    public String getScore(){return this.score;}
    public String getMinFps(){return this.minFps;}
    public String getMaxFps(){return this.maxFps;}
    public String getResult(){return this.result;}

    // setter methods
    public void setTitle(String title){this.title = title;}
    public void setFileType(String fileType){this.fileType = fileType;}
    public void setDate(String date){this.date = date;}
    public void setTime(String time){this.time = time;}
    public void setFps(String fps){this.fps = fps;}
    public void setScore(String score){this.score = score;}
    public void setMinFps(String minFps){this.minFps = minFps;}
    public void setMaxFps(String maxFps){this.maxFps = maxFps;}

    public void parseHtml(File file){
        map = new HashMap<String, String>();
        try{
            Document doc = Jsoup.parse(file, "UTF-8", "");
            //Elements title = doc.getElementsByTag("title");
            //Elements res = doc.getElementsByClass("result");
            Elements rows = doc.getElementsByTag("tr");
            System.out.println(rows.nextAll().text());
            this.table = rows.eachText();

            System.out.println("Divs: " + doc.getElementsByTag("tr").select("div").text());
            System.out.println("Scores: " + doc.getElementsByClass("right").eachText());
            System.out.println("Numbers: " + doc.getElementsByClass("orange").eachText());
            System.out.println("Highlight: " + doc.getElementsByClass("highlight").eachText());
            System.out.println("Detail: " + doc.getElementsByClass("detail").select("tr").select("td").eachText());
            System.out.println("Result: " + doc.getElementsByClass("result").select("tr").select("td")
            .eq(2).text());

            // Parsed data to be put into Hashmap?
            // Still don't know yet will confirm at a later time
            // this might be unneccessary, putting all these data
            // structures and passing in to other values.
            List<String> values = doc.getElementsByClass("orange").eachText();
            List<String> hl = doc.getElementsByClass("highlight").eachText();
            List<String> keys = doc.getElementsByClass("right").eachText();

            values.addAll(hl);

            System.out.println("Values: " + values);
            System.out.println("Keys: " + keys);

            for(int i = 0; i < keys.size(); i++){
                map.put(keys.get(i), values.get(i));
            }

            System.out.println(map.toString());

            if(values.size() == keys.size()){
                System.out.println("CONGRATS THEY ARE THE SAME NIGGA");
            }

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File input = new File("test.html");
        
        //System.out.println("Last Date Modified: " + input.lastModified());
        //SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        //System.out.println("Last Date Modified: " + sdf.format(input.lastModified()));

       
        try {
            Document doc = Jsoup.parse(input, "UTF-8", "");
            System.out.println(doc.toString());

            //Elements title = doc.getElementsByTag("title");
            //System.out.println(title.text());

            //Elements res = doc.getElementsByClass("result");
            //System.out.println(res.text());

            /*Elements rows = doc.getElementsByTag("tr");
            this.table = rows.eachText();
            System.out.println(table);*/
            File file = new File("test.html");
            BenchMark test = new BenchMark(file);
           


        } catch (Exception e) {
            e.printStackTrace();
        }

        

    }
    
}