package threadTest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StreamEx03 {
    public static void main(String[] args) {
//        InputStream in = System.in;
//        InputStreamReader ir = new InputStreamReader(in);
//        BufferedReader br = new BufferedReader(ir);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String data = br.readLine();
            System.out.println(data);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
