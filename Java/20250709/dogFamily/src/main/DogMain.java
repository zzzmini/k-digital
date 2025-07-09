package main;

import vo.DogFamily;

public class DogMain {
    public static void main(String[] args) {
        DogFamily coco = new DogFamily("마르티즈");
        coco.setName("코코");
        coco.setColor("흰색");
        coco.setAge(2);

//        System.out.println(coco.toString());

        DogFamily chi = new DogFamily("치와와");
        chi.setName("치치");
        chi.setColor("검정");
        chi.setAge(1);

        DogFamily rit = new DogFamily("리트리버");
        rit.setName("덩치");
        rit.setColor("골드");
        rit.setAge(3);
        // 배열에 저장
        DogFamily[] dogs = new DogFamily[3];
        dogs[0] = coco;
        dogs[1] = chi;
        dogs[2] = rit;

        for (DogFamily dog : dogs) {
            System.out.println(dog);
        }
        System.out.println("=====================");
        coco.setAge(5);
        rit.setName("망치");
        for (DogFamily dog : dogs) {
            System.out.println(dog);
        }
    }
}
