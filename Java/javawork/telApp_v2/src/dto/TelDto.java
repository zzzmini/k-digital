package dto;

public record TelDto(int id, String name, int age, String addr, String tel) {
    public static TelDto allOf(int id, String name, int age, String addr, String tel){
        return new TelDto(id, name, age, addr, tel);
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", age=" + age +
                ", addr=" + addr + ", tel=" + tel;
    }

    public TelDto(String name, int age, String addr, String tel) {
        this(0, name, age, addr, tel);
    }

    public static TelDto of(String name, int age, String addr, String tel){
        return new TelDto(name, age, addr, tel);
    }
}
