package ch03;

public class OperEx03 {
    public static void main(String[] args) {
        int value = 10;
        System.out.println(1 == 1);
        if(1==1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        System.out.println(5 != 3);
        System.out.println(! true);
        System.out.println(value >= 3);
        // 논리연산자
        int n1 = 1;
        int n2 = 2;
        if(n1==1 && n2==1){
            System.out.println(true);
        } else {
            System.out.println(false);
        }

        if(n1==1 || n2==1){
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
