package mapTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        // key, value 의 쌍
        Map<String, Integer> store = new HashMap<>();
        // add
        store.put("water", 1);
        store.put("fruit", 2);
        // 같은 키 값은 수정
        store.put("fruit", 3);
        store.put("my", 1);
        // 삭제
        store.remove("my");

        for (String key : store.keySet()) {
            System.out.println(key + " : " + store.get(key));
        }
    }
}
