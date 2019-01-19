import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Test {

	public static void main(String[] args) {
		BenchMark model = new BenchMark("title", "date", "time");
		View view = new View();
		view.displayView(model);

























		/*Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = screenSize.width;
		int height = screenSize.height;

		File input = new File("test.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "");
			// System.out.println(doc);

			Elements title = doc.getElementsByTag("h1");
			// System.out.println(title.text());

			Elements res = doc.getElementsByClass("result");
			// System.out.println(res.text());

			// MainFrame frame = new MainFrame("test", width, height);
			MainFrame frame = new MainFrame("test");
			JPanel panel = new JPanel();
			JButton browse = new JButton("Browse");
			JButton send = new JButton("send");
			JTextField text = new JTextField(30);
			final JFileChooser fc = new JFileChooser();

			text.setEnabled(false);

			send.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO: get data from file and send to google sheets
					
					 System.out.println(title.text()); System.out.println(res.text());
					
					if (text.getText().isEmpty()) {
						System.out.println("Error: Please select a compatible file");
					} else {
						System.out.println("Data was successfully sent to Google Sheets!");
					}
				}

			});

			browse.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					int returnVal = fc.showOpenDialog(browse);

					if (returnVal == JFileChooser.APPROVE_OPTION) {
						File f = fc.getSelectedFile();
						System.out.println(f.getName());
						text.setText(f.getName());
					}

				}

			});

			frame.setLayout(new BorderLayout());

			panel.add(text);
			panel.add(browse);
			panel.add(send);

			frame.add(panel, BorderLayout.CENTER);
			frame.pack();
			frame.setVisible(true);

		} catch (IOException e) {
			System.out.println("Error!");
			e.printStackTrace();
		}*/

	}

}
