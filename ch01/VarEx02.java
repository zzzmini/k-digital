package ch01;
class Note {
    int num = 1;
    int price = 1000;
    int quantity = 1;
}

public class VarEx02 {
    public static void main(String[] args) {
        붕어빵 bang = new 붕어빵();

        System.out.println(bang.color);
        System.out.println(bang.price);

        Note note = new Note();
        Note note1 = new Note();
        Integer intNum = 100;

        System.out.println("첫번째 노트 가격 : " + note.price);
        note1.price = 2000;
        System.out.println("두번째 노트 가격 : " + note1.price);
    }
}
