package girlgroup;

public class Ive {
    static void danceAndSing(String name){
        System.out.println(name + "가 춤과 노래를 합니다.");
    }

    static String sayHello(String name){
        String answer = name + "이 인사를 합니다.";
        return answer;
    }

    public static void main(String[] args) {
        AnYuJin anYuJin = new AnYuJin();
        JangWonYoung jangWonYoung = new JangWonYoung();
        int speed;
        speed = 0;
        if(3>4){
            System.out.println("참입니다.");
        } else {
            System.out.println("거짓입니다.");
        }


        System.out.println("------------------------------");
        System.out.println(anYuJin.name);
//        anYuJin.name = "An Yu Jin";
        System.out.println(anYuJin.height);
        System.out.println(anYuJin.year);
        anYuJin.dance();
        Ive.danceAndSing(anYuJin.name);
        System.out.println("------------------------------");
        System.out.println(jangWonYoung.name);
        System.out.println(jangWonYoung.height);
        System.out.println(jangWonYoung.year);
        jangWonYoung.sing();
        System.out.println(sayHello(jangWonYoung.name));
//        System.out.println("장원영이 인사를 합니다.");
    }
}
