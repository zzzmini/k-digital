public class StarcraftMain {
    public static void main(String[] args) {
        // 자식 타입으로 선언(상속)
        // 내꺼 내꺼, 부모꺼 내꺼
        Zealot zealot = new Zealot();
        Dragoon dragoon = new Dragoon();
        DarkTemplar dartTemplar = new DarkTemplar();

        String name = zealot.confirmName();
        System.out.println(name);
        zealot.basicAttack(dragoon);
        dragoon.basicAttack(dartTemplar);

        System.out.println("============");
        // 부모타입으로 선언
        // 부모꺼 부모꺼, 자식한테 똑 같은 메서드 있으면 자식꺼..실행
        // 결국 부모꺼는 개무시
        ProtosUnit z = new Zealot();
        ProtosUnit d = new DarkTemplar();
        d.basicAttack(z);
        System.out.println("============");
        ProtosUnit r = new Reaver();
        r.basicAttack(dragoon);
    }
}
