package ch01;
// 클래스 변수
class IveMember {
    // 장원영을 표현할 수 있는
    // Properties(Member)-속성
    static String name;
    int age;
    double height;

    // 메서드(Method)
    void dance() {
        System.out.println("장원영이 춤춰요");
    }
}

class Jang {
    public static void main(String[] args) {
        IveMember jang = new IveMember();  //인스턴스
//        jang.name = "장원영";
        IveMember.name = "안유진";

        jang.age=23;
        jang.height = 173.5;
        jang.dance();
        System.out.println(jang.name);
    }
}