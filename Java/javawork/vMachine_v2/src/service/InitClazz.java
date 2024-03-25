package service;

import vo.ProductVO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InitClazz {
    // 리스트 안의 제품목록 출력
    public static void printMenu(){
        System.out.println("===================== 메뉴 =====================");
        Iterator<ProductVO> iterator = lists.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().toString());
        }
        System.out.println("================================================");
    }

    // 사용자가 투입한 금액(잔액)
    public static int remainMoney = 0;
    public static List<ProductVO> lists = new ArrayList<>();
}
