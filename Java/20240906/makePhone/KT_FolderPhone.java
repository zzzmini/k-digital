package makePhone;

public class KT_FolderPhone extends AndroidPhone{
	public void name() {
		System.out.println("KT 안드로이드 폴더폰");
	}

	@Override
	public void touch() {
		System.out.println("터치 안됨");
	}

	@Override
	public void kakao() {
		System.out.println("카톡 안됨");
	}
	
}
