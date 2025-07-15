package vo;

public class Member {
    private int id;
    private String name;
    private int age;

    public String toString() {
        return id + "\t" + name + "\t" + age;  // \t : tab, \n : 한줄 띄기
    }

    // Getter
    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
