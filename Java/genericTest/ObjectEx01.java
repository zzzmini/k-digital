package genericTest;

public class ObjectEx01 {
	public static void main(String[] args) {
		Object dog = new DogClazz();
		Object cat = new CatClazz();
		System.out.println(((DogClazz)dog).name); 
		System.out.println(((CatClazz)cat).name);
		System.out.println("=============");
		Object[] oAnimal = new Object[2];
		oAnimal[0] = dog;
		oAnimal[1] = cat;
		for(Object o : oAnimal) {
			if(o instanceof DogClazz) {
				System.out.println(((DogClazz)o).name);
			} else {
				System.out.println(((CatClazz)o).name);
			}
		}
	}
}
