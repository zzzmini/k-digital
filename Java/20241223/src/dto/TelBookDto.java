package dto;

public class TelBookDto {
    private int id;
    private String name;
    private int age;
    private String address;
    private String telNum;

    public TelBookDto(){}

    public TelBookDto(int id, String name, int age, String address, String telNum) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.telNum = telNum;
    }

    @Override
    public String toString() {
        return id +  "\t  "  + name + "\t" + age + "\t" + address + "\t" + telNum;
    }

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
}
