package arrayListTest;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        List<String> colors = new ArrayList<>();
        colors.add("흰색");
        colors.add("빨강");
        colors.add("핑크");
        String color = colors.get(2);
//        System.out.println(color);
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
        // 수정
        colors.set(0, "하양");
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
        colors.remove(1);
        for (int i = 0; i < colors.size(); i++) {
            System.out.println(colors.get(i));
        }
    }
}
