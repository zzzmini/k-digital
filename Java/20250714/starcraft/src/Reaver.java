public class Reaver extends ProtosUnit {
    private String name = "리버";

    public String confirmName() {
        return this.name;
    }

    public void basicAttack(ProtosUnit e) {
        System.out.println(this.name + "이 " + e.confirmName() + "을 공격");
    }
}
