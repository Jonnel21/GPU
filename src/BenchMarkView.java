import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BenchMarkView extends JFrame {
    private BenchMarkModel model;

    public BenchMarkView() {
        super();
    }

    public BenchMarkView(String name) {
        super(name);
    }

    public void displayView(BenchMarkModel model) {
        this.model = model;
        JPanel panel = new JPanel();
        JButton browse = new JButton("Browse");
        JButton send = new JButton("Send");
        JTextField text = new JTextField(30);

        BenchMarkView v = new BenchMarkView("test");
        v.setLayout(new BorderLayout());

        panel.add(text);
        panel.add(browse);
        panel.add(send);

        v.add(panel, BorderLayout.CENTER);
        addListeners(text, browse, send);

        v.pack();
        v.setVisible(true);

    }

    public void updateView(BenchMarkModel model){
        // TODO: update view depending on the model
    }

    public void addListeners(JTextField text, JButton... b1) {

        // Browse Button
        b1[0].addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fc = new JFileChooser();
                int returnVal = fc.showOpenDialog(b1[0]);

                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File f = fc.getSelectedFile();
                    System.out.println(f.getName());
                    text.setText(f.getName());
                    
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