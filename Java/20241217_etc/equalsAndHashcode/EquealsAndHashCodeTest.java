package equalsAndHashcode;

public class EquealsAndHashCodeTest {
    public static void main(String[] args) {
        // primitive type(원시타입)
        // int, double, long, boolean
        int a = 3;
        int b = 3;
        if (a == b) {
            System.out.println("a와 b는 같다.");
        } else {
            System.out.println("a와 b는 같지 않다.");
        }

        String str1 = "장원영";
        String str2 = "장원영";
        if (str1 == str2) {
            System.out.println("str1과 str2는 같다.");
        } else {
            System.out.println("str1과 str2는 같지 않다.");
        }

        String str3 = new String("장원영");
        String str4 = new String("장원영");
        if (str3 == str4) {
            System.out.println("str3과 str4는 같다.");
        } else {
            System.out.println("str3과 str4는 같지 않다.");
        }

        Person p1 = new Person("장원영", 20);// 1000번지
        Person p2 = new Person("장원영", 10);// 2000번지
        if (p1.name.equals(p2.name)) {
            System.out.println("p1.name과 p2.name은 같다.");
        } else {
            System.out.println("같지 않다.");
        }

        if (p1.equals(p2)) {
            System.out.println("p1과 p2는 같다.");
        } else {
            System.out.println("p1과 p2는 같지 않다.");
        }
    }
}
