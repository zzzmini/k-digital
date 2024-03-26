package view;

public class PrintTitle {
    public static void title(){
        String str;
        str = String.format("아이디 \t 이름 \t 나이 \t " +
                "주소 \t 전화번호 \t");
        System.out.println(str);
    }
    public static void line(){
        System.out.println("==============================================");
    }
}
