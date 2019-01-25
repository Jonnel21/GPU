package GPU;
/**
 * This class is to represent
 * the model for the data
 */
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class BenchMarkModel implements PropertyChangeListener{

    private String title;
    private String fileType;
    private String date;
    private String time;
    private String fps;
    private String score;
    private String minFps;
    private String maxFps;
    private String result;
    private File fileName;
    private List<String> table;
    private Map<String, String> map;

    public BenchMarkModel(){
        if(fileName == null){
            System.out.println("Please load file.");
        } else{
            parseHtml(this.fileName);
        }
       
    }

    public BenchMarkModel(File fileName) {
        this.fileName = fileName;
        //parseHtml(fileName);
    }

    public BenchMarkModel(String title, String fileType) {
    }

    public BenchMarkModel(File fileName, String title, String date, String time) {
        this.fileName = fileName;
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
    public File getFileName(){return this.fileName;}
    public Map<String,String> getMap(){return map;}

    // setter methods
    public void setTitle(String title){this.title = title;}
    public void setFileType(String fileType){this.fileType = fileType;}
    public void setDate(String date){this.date = date;}
    public void setTime(String time){this.time = time;}
    public void setFps(String fps){this.fps = fps;}
    public void setScore(String score){this.score = score;}
    public void setMinFps(String minFps){this.minFps = minFps;}
    public void setMaxFps(String maxFps){this.maxFps = maxFps;}
    public void setSelectedFile(File file){fileName = file;}

    public void parseHtml(File file){
        map = new HashMap<String, String>();
        try{
            Document doc = Jsoup.parse(file, "UTF-8", "");
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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println(evt.getSource());

	}
    
}