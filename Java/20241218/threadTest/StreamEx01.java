package threadTest;

import java.io.InputStream;

public class StreamEx01 {
    public static void main(String[] args) {
        InputStream in = System.in;  // 바이트스트림(아스키코드 한글자씩)
        try {
            int data = in.read();
            System.out.println((char)data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
