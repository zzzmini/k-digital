package car_operating;

public class Accessories {
	private boolean sunRoof;
	private boolean airBag;
	// toString() 생성
	public String toString() {
		return "sunRoof : " + this.sunRoof + " ,airBag : " + this.airBag; 
	}
	
	// Getter
	public boolean getSunRoof() {
		return this.sunRoof;
	}
	public boolean getAirBag() {
		return this.airBag;
	}
	
	public Accessories(boolean sunRoof, boolean airBag) {
		this.sunRoof = sunRoof;
		this.airBag = airBag;
	}
}
