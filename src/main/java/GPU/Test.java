package GPU;
public class Test {
	public static void main(String[] args) {
		BenchMarkModel model = new BenchMarkModel();
		BenchMarkView view = new BenchMarkView();
		BenchMarkController controller = new BenchMarkController(model, view);
		
		controller.displayView();
		//System.out.println(controller.getSelectedFile());
		//controller.updateView(model);
	}
}
