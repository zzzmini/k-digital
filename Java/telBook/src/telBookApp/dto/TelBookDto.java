package telBookApp.dto;

import telBookApp.entity.TelBook;

public class TelBookDto {
	private long id;
	private String name;
	private int age;
	private String address;
	private String phone;
	
	// dto를 TelBook entity로 변환
	public static TelBook fromDto(TelBookDto dto) {
		return new TelBook(
				dto.getId(),
				dto.getName(),
				dto.getAge(),
				dto.getAddress(),
				dto.getPhone()
				);
	}
	
	// Entity(TelBook)을 TelBookDto로 변환..
	public static TelBookDto fromEntity(TelBook entity) {
		return new TelBookDto(
				entity.getId(), 
				entity.getName(), 
				entity.getAge(), 
				entity.getAddress(), 
				entity.getPhone());
	}
	
	
	// 입력받은 자료를 바로 TelBookDto로 생성하기
	public static TelBookDto makeDto(String name, int age, 
				String address, String phone) {
		
		return new TelBookDto(name, age, address, phone);
	}
	
	public TelBookDto(String name, int age, String address, String phone) {
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}
	
	
	public TelBookDto(long id, String name, int age, String address, String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}




	@Override
	public String toString() {
		return id +  "\t  "  + name + "\t" + age + "\t" + address + "\t" + phone;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
