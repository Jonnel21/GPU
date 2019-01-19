import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame{
    private BenchMark model;

    public View(){
        super();
    }

    public View(String name){
        super(name);
    }

    public void displayView(BenchMark model){
        this.model = model;
        JPanel panel = new JPanel();
        JButton browse = new JButton("Browse");
        JButton send = new JButton("Send");
        JTextField text = new JTextField(30);

        View v = new View("test");
        v.setLayout(new BorderLayout());

        panel.add(text);
        panel.add(browse);
        panel.add(send);

        v.add(panel, BorderLayout.CENTER);
        v.pack();
        v.setVisible(true);


    }
}