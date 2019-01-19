public class Test {
	public static void main(String[] args) {
		BenchMarkModel model = new BenchMarkModel("title", "date", "time");
		BenchMarkView view = new BenchMarkView();
		BenchMarkController controller = new BenchMarkController(model, view);
		
		controller.displayView();
	}
}
