package dto;

public class TelDto {
    private int id;
    private String name;
    private int age;
    private String address;
    private String phone;

    public String toString() {
        String str = String.format("아이디 %d \n이름 %s \n나이 %s \n주소 %s \n전화번호 %s \n",
                id, name, age, address, phone);
        return str;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
