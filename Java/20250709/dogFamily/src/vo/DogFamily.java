package vo;

public class DogFamily {
    private String kind;
    private String name;
    private String color;
    private int age;

    // 품종만 갖는 생성자 만들기
    public DogFamily(String kind) {
        this.kind = kind;
    }

    // toString() 만들기
    public String toString() {
        return "dog = {kind = " + kind +
                ", name = " + name +
                ", color = " + color +
                ", age = " + age + "}";
    }

    // getter
    public String getKind() {
        return this.kind;
    }

    public String getName() {
        return this.name;
    }

    public String getColor() {
        return this.color;
    }

    public int getAge() {
        return this.age;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
