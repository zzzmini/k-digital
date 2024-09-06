package makePhone;

public abstract class Phone implements PhoneInterface{
	public abstract void name();
	public abstract void os();
	public abstract void touch();
	public abstract void kakao();
	@Override
	public void call() {
		System.out.println("통화 무조건 됨");
	}
	@Override
	public void message() {
		System.out.println("메시지 보내짐");
	}
}
