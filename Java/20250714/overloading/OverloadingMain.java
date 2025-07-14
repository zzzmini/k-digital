package overloading;

import java.util.Scanner;

public class OverloadingMain {
    public static void main(String[] args) {
        Running running = new Running();
        running.run();
        running.run(5);
        running.run(2.1);
        running.run(1, 5);
    }
}
