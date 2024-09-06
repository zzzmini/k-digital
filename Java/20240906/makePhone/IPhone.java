package makePhone;

public class IPhone extends Phone{
	public void name() {
		System.out.println("모름");
	}
	
	@Override
	public void os() {
		System.out.println("OS는 iOS");
	}

	@Override
	public void touch() {
		System.out.println("당근 터치 됨.");
	}

	@Override
	public void kakao() {
		System.out.println("당근 카카오 됨.");
	}
}
