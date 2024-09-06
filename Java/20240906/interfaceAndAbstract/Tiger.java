package interfaceAndAbstract;

public class Tiger extends WildAnimal{

	@Override
	public void attack() {
		System.out.println("물어서 공격");
	}

	@Override
	public void up() {
		System.out.println("나는 나무위로 이동");
	}
	
}
