package abstractClassTest;

public class AbstractClassTestMain {
	public static void main(String[] args) {
		Animal dog = new Dog();
		dog.speak();
		
		Bird bird = new Bird();
		bird.speak();
		bird.hello();
		
		Animal tiger = new Tiger();
		tiger.speak();
	}
}
