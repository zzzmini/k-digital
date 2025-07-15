package repository;

import vo.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberRepository {
    // 멤버들의 정보를 담는 맵
    public static Map<Integer, Member> store = new HashMap<>();
    // 키 값을 생성하고 저장하는 변수
    public static int key = 1;
}
