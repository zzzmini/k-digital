package makePhone;

public class AndroidPhone extends Phone {
	public void name() {
		System.out.println("몰라");
	}

	@Override
	public void os() {
		System.out.println("OS는 Android");
	}

	@Override
	public void touch() {
		System.out.println("터치 기능 있음.");
	}

	@Override
	public void kakao() {
		System.out.println("카톡 가능");
	}

}
