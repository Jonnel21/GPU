import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

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
        addListeners(text, browse, send);

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
                    setSelectedFile(file);
                    System.out.println(file.getName());
                    text.setText(file.getName());
                    
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