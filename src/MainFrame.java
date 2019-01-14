import javax.swing.JFrame;

public class MainFrame extends JFrame{

	int width;
	int height;
	
	public MainFrame()
	{
		super();
	}
	
	public MainFrame(String name) {
		super(name);
		
	}

	// Creates frame with name & size
	public MainFrame(String name, int width, int height){
		super(name);
		this.width = width;
		this.height = height;
		super.setSize(width / 2 , height / 2);
	}

}
