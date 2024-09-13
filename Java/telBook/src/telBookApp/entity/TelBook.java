package telBookApp.entity;

public class TelBook {
	private Long id;
	private String name;
	private int age;
	private String address;
	private String phone;
	
	public TelBook(Long id, String name, int age, String address, String phone) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
	}

	public TelBook() {
		
	}
	
	public void setId(Long id) {
		this.id = id;
	}



	public void setName(String name) {
		this.name = name;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public Long getId() {
		return id;
	}



	public String getName() {
		return name;
	}



	public int getAge() {
		return age;
	}



	public String getAddress() {
		return address;
	}



	public String getPhone() {
		return phone;
	}



	@Override
	public String toString() {
		return "TelBook [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone
				+ "]";
	}
	
}
