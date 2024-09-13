package genericTest_2;

public class GenericTestMain {
	//  오전 9시 : 축구, 12시 : 농구
	public static Bag<? extends BBball> whatTheBall(int time) {
		if(time == 9) {
			BBball scBall = new SoccerBall();
			Bag<BBball> bag = new Bag<BBball>();
			bag.setBall(scBall);
			return bag;
		} else if(time == 12) {
			BBball bcBall = new BasketBall();
			Bag<BBball> bag = new Bag<BBball>();
			bag.setBall(bcBall);
			return bag;
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		Bag<? extends BBball> bag1 = whatTheBall(9);
		Bag<? extends BBball> bag2 = whatTheBall(12);
		System.out.println(bag1.getBall().getName());
		System.out.println(bag2.getBall().getName());
	}
}











