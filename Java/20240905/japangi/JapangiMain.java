package japangi;

public class JapangiMain {
	public static void main(String[] args) {
		JapangiServiceInterface service = new JapangiServieImple();
		service.deleteProduct("김형민");
	}
}
