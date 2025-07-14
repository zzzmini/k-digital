package abstractTest;

public abstract class Animal {
    // 팀원들이 구현할 곳 - 몸체가 없다
    // 어차피 개무시 될 테니까
    public abstract void speak();

    // 팀장으로서 팀원들과 공유할 메서드
    public void hello() {
        System.out.println("수고해요~~~");
    }
}
