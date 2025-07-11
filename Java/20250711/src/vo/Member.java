package vo;

public class Member {
    private String name;  // 멤버이름
    private String nickName;  // 영문이름

    // Getter
    public String getName() {
        return this.name;
    }

    public String getNickName() {
        return this.nickName;
    }

    // Setter
    public void setName(String name) {
        this.name = name;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String toString() {
        return "name : " + name + ", nickname : " + nickName;
    }
    // 기본 생성자
    public Member(){}

    // 이름을 기본으로 생성하는 생성자
    public Member(String name) {
        this.name = name;
    }
}
