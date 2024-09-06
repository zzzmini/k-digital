package equalsAndHashCode;

import java.util.Objects;

class Person{
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}


	
}


public class EqAndHashTest {
	public static void main(String[] args) {
		int a = 3;
		int b = 3;
		if(a == b) {
			System.out.println("a와 b는 같다.");
		} else {
			System.out.println("a와 b는 같지 않다.");
		}
		String str1 = "홍길동";
		String str2 = "홍길동";
		if(str1 == str2) {
			System.out.println("str1와 str2는 같다.");
		} else {
			System.out.println("str1와 str2는 같지 않다.");
		}
		
		String str3 = new String("장원영");
		String str4 = new String("장원영");
		if(str3 == str4) {
			System.out.println("str3와 str4는 같다.");
		} else {
			System.out.println("str3와 str4는 같지 않다.");
		}
		
		String str5 = new String("장원영");
		String str6 = new String("장원영");
		if(str5.equals(str6)) {
			System.out.println("str5와 str6는 같다.");
		} else {
			System.out.println("str5와 str6는 같지 않다.");
		}
		
		Person p1 = new Person("장원영", 20);
		Person p2 = new Person("장원영", 10);
		
		if(p1.equals(p2)) {
			System.out.println("p1와 p2는 같다.");
		} else {
			System.out.println("p1와 p2는 같지 않다.");
		}
		
		if(p1.name.equals(p2.name)) {
			System.out.println("p1.name와 p2.name는 같다.");
		} else {
			System.out.println("p1.name와 p2.name는 같지 않다.");
		}
	}
}










