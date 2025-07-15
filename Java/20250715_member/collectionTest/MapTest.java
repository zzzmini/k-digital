package collectionTest;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<Integer, String> myMap = new HashMap<>();
        myMap.put(1, "사과");
        myMap.put(2, "바나나");
        myMap.put(2, "딸기");
        System.out.println(myMap.get(2));
        myMap.put(3, "참외");
        for (Integer i : myMap.keySet()) {
            System.out.println(myMap.get(i));
        }
    }
}
