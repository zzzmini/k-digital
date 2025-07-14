public class Dragoon extends ProtosUnit {
    private String name = "드라군";
    // 부모 메서드를 overriding 함.
    public void basicAttack(ProtosUnit e1) {
        System.out.println("드라군 메서드");
        System.out.println(this.name + "이 " + e1.confirmName() + "을 공격");
    }
    // 부모 메서드를 overriding 함.
    public String confirmName() {
        return this.name;
    }
}
