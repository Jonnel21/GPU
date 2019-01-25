package GPU;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.Random;
//import org.apache.commons.impl.DefaultFileMonitor;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BenchMarkView extends JFrame {
    private JPanel panel;
    private JButton browse;
    private JButton send;
    private JTextField text;
    private JTextArea console;
    private File selectedFile;
    private BenchMarkController controller;

    public BenchMarkView() {
        super();
    }

    public BenchMarkView(String name) {
        super(name);
    }

    public void displayView() {
        
        panel = new JPanel();
        browse = new JButton("Browse");
        send = new JButton("Send");
        text = new JTextField(30);
        console = new JTextArea(30,30);

        BenchMarkView v = new BenchMarkView("test");
        v.setLayout(new BorderLayout());

        panel.add(text);
        panel.add(browse);
        panel.add(send);
        panel.add(console);

        console.setLineWrap(true);

        v.add(panel, BorderLayout.CENTER);
        /*text.addPropertyChangeListener("background", new PropertyChangeListener(){
        
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                System.out.println("PropertyChange in View class: " + evt.getSource());
                System.out.println("PropertyChange in View Class Old Value : " + evt.getOldValue());
                System.out.println("PropertyChange in View Class New Value : " + evt.getNewValue());
            }
        });*/
        addListeners(text, browse, send);

        v.setDefaultCloseOperation(EXIT_ON_CLOSE);
        v.pack();
        v.setVisible(true);

    }


    public void updateView(BenchMarkView v){
        // TODO: update view depending on the model
        // add listeners here?
        //addListeners(text, browse, send);
       

        
    }

    // getter methods
    public JPanel getPanel(){return this.panel;}
    public JButton getBrowse(){return this.browse;}
    public JButton getSend(){return this.send;}
    public JTextField getText(){return this.text;}
    public JTextArea getConsole(){return this.console;}
    public File getSelectedFile(){return selectedFile;}

    // setter methods
    public void setSelectedFile(File selectedFile){this.selectedFile = selectedFile;}


    public void addListeners(JTextField text, JButton... b1) {

        // Browse Button
        b1[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(b1[0]);

                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
                    System.out.println(file);
                    setSelectedFile(file);
                    System.out.println("From addListeners method in view class: " + file.getName());
                    text.setText(file.getName());
                    text.setBackground(new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255)));

                    /*FileSystemManager fsManager = VFS.getManager();
                    FileObject listendir = fsManager.resolveFile(file);
                    DefaultFileMonitor fm = new DefaultFileMonitor(new CustomFileListener());

                    fm.setRecursive(true);
                    fm.addFile(listendir);
                    fm.start();*/

                    
                    
                }
                
            }

        });

        // Send Button
        b1[1].addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO: get data from file and send to google sheets

                if(text.getText().isEmpty()){
                    System.out.println("Error: Please select a compatible file");
                } else{
                    System.out.println("Data was Successfully sent to Google Sheets!");
                }
            }

        });

    }
}