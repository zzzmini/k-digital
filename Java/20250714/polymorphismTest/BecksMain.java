package polymorphismTest;

import java.util.ArrayList;
import java.util.List;

public class BecksMain {
    public static void main(String[] args) {
        ChainMan chainMan = new ChainMan();
        // 자식의 getWork()
        // 부모꺼 내꺼
        System.out.println(chainMan.getWork());
        // 내꺼 내꺼
        System.out.println(chainMan.condition());

        System.out.println("==============");
        // 부모를 바라보게 하기
        // 사업가 타입인데 부모클래스를 바로봄
        Cooker beak = new ChainMan();
        System.out.println(beak.getWork());
        System.out.println("==============");
        // 요리사 타입의 유튜버를 생성
        Cooker youtuber = new Youtuber();

        // 자식꺼 getWork 가 실행
        System.out.println(youtuber.getWork());
        // 자식 유튜버꺼 getWorking 실행
        String childWork = ((Youtuber) youtuber).getWorking();
        System.out.println(childWork);

        List<Cooker> cookerList = new ArrayList<>();
        cookerList.add(beak);
        cookerList.add(youtuber);
        cookerList.add(chainMan);
        System.out.println("==================");
        for (int i = 0; i < cookerList.size(); i++) {
            System.out.println(cookerList.get(i).getWork());
        }
    }
}
