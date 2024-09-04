package car_operating;

public class CarMain {
	public static void main(String[] args) {
		Car sonata = new Car("현대", "소나타");
		sonata.setColor("흰색");
		sonata.setPower(2000);
		// 액세서리를 선택
		Accessories accessories = new Accessories(true, false);
		
		// 액세서리를 차에 장착
		sonata.setAccesories(accessories);
		
		
		// 클래스 출력
		System.out.println(sonata);
		// 제로백 확인
		sonata.jelobaeg();
		// 가속 확인
		sonata.speedUp();
		
		// 감속확인
		sonata.speedDown();
		sonata.speedDown();
		sonata.speedDown();
		sonata.speedDown();
	}
}
