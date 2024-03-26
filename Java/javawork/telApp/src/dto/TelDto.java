package dto;

public class TelDto {
    private int id;
    private String name;

    @Override
    public String toString() {
        String str;
        str = String.format("%d \t %s \t %d \t " +
                "%s \t %s \t", id, name, age, address, telNum);
        return str;
    }

    private int age;
    private String address;
    private String telNum;

    public TelDto(){}
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelNum() {
        return telNum;
    }

    public void setTelNum(String telNum) {
        this.telNum = telNum;
    }

    public TelDto(int id, String name, int age, String address, String telNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.telNum = telNum;
    }
    public TelDto(String name, int age, String address, String telNum) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.telNum = telNum;
    }

    public static TelDto of(String name, int age, String address,String telNum){
        return new TelDto(name, age, address, telNum);
    }
    public static TelDto allOf(int id, String name, int age, String address,String telNum){
        return new TelDto(id, name, age, address, telNum);
    }
}
