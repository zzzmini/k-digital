package dto;

public class SearchResultDTO {
    private String name;
    private int age;
    private String address;
    private String phone;

    public SearchResultDTO(String name, int age, String address, String phone) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.phone = phone;
    }
    public String toString() {
        String str = String.format("%s \t  %d \t %s \t %s"
                , name, age, address, phone);
        return str;
    }
}
