package genericTest;

public class GenericTest {
	public static void main(String[] args) {
		BigBasket<CatClazz> bs = new BigBasket<>();
		CatClazz cat = new CatClazz();
		bs.data = cat;
		System.out.println(bs.data.name);
	}
}
