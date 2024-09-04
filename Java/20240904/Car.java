Car.java

package car_operating;

public class Car {
	private String color;
	private String name;
	private String brand;
	private int power;
	private int speed;
	private Accessories accessories;
	
	public String toString() {
		return "brand : " + this.brand
					+ " ,name : " + this.name
					+ " ,color : " + this.color
					+ " ,power : " + this.power + "\n"
					+ " ,speed : " + this.speed
					+ ", Accessories : " + this.accessories;
//					+ " ,sunRoof : " + this.accessories.getSunRoof()
//					+ " ,airBag : " + this.accessories.getAirBag();
	}
	
	
	// 생성자
	public Car(String brand, String name) {
		this.brand = brand;
		this.name = name;
	}
	
	// Setter
	public void setAccesories(Accessories accessoires) {
		this.accessories = accessoires;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public void setPower(int power) {
		this.power = power;
	}
	
	// Getter
	public String getColor() {
		return this.color;
	}
	public int getpower() {
		return this.power;
	}
	// Method
	public void jelobaeg() {
		if(this.speed > 0) {
			System.out.println("제로백은 멈춘 후 시도해야 합니다.");
		} else {
			this.speed = 100;	
			System.out.println("현재 스피드는 " + this.speed + "km 입니다.");
		}
		
	}
	public void speedUp() {
		if(this.speed < 100) {
			this.speed = this.speed + 30;	
		} else {
			System.out.println("과속입니다.");
		}
		System.out.println("현재 스피드는 " + this.speed + "km 입니다.");
	}
	public void speedDown() {
		if(this.speed - 30 < 0) {
			this.speed = 0;
			System.out.println("차가 멈췄습니다.");	
		} else {
			this.speed = speed - 30;
		}
		System.out.println("현재 스피드는 " + this.speed + "km 입니다.");
	}
	
	
}



