import java.util.Map;

import javax.swing.*;

public class BenchMarkController {

    private BenchMarkModel model;
    private BenchMarkView view;

    public BenchMarkController(BenchMarkModel model, BenchMarkView view){
        this.model = model;
        this.view = view;
    }

    // getter methods
    public String getTitle(){return model.getTitle();}
    public String getFileType(){return model.getFileType();}
    public String getDate(){return model.getDate();}
    public String getTime(){return model.getTime();}
    public String getFps(){return model.getFps();}
    public String getScore(){return model.getScore();}
    public String getMinFps(){return model.getMinFps();}
    public String getMaxFps(){return model.getMaxFps();}
    public String getResult(){return model.getResult();}
    public Map<String,String> getMap(){return model.getMap();}

    public JPanel getPanel(){return view.getPanel();}
    public JButton getBrowse(){return view.getBrowse();}
    public JButton getSend(){return view.getSend();}
    public JTextField getText(){return view.getText();}
    public JTextArea getConsole(){return view.getConsole();}

    // setter methods
    public void setTitle(String title){model.setTitle(title);}
    public void setFileType(String fileType){model.setFileType(fileType);}
    public void setDate(String date){model.setDate(date);}
    public void setTime(String time){model.setTime(time);}
    public void setFps(String fps){model.setFps(fps);}
    public void setScore(String score){model.setScore(score);}
    public void setMinFps(String minFps){model.setMinFps(minFps);}
    public void setMaxFps(String maxFps){model.setMaxFps(maxFps);}

    public void updateView(BenchMarkModel m){
        Map<String,String> data = getMap();
        //view.updateView(view);
        getConsole().setText(data.toString());
        // model communicates to controller what data is to be changed
        // controller then takes data from model in order
        // to update view
    }

    public void displayView(){
        view.displayView();
    }











}