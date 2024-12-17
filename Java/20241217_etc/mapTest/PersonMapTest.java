package mapTest;

import equalsAndHashcode.Person;

import java.util.HashMap;
import java.util.Map;

public class PersonMapTest {
    public static void main(String[] args) {
        Map<Integer, Person> ive = new HashMap<>();
        int key = 1;
        Person jang = new Person("장원영", 20);
        Person ahn = new Person("안유진", 21);
        Person lee = new Person("이서", 19);
        ive.put(key, jang);
        key ++;
        ive.put(key, ahn);
        key ++;
        ive.put(key, lee);
        for (Integer k : ive.keySet()) {
            System.out.println("key : " + k + ", value = " + ive.get(k));
        }
    }
}
