package socket;

import interfaceQuiz.Circle;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    BufferedReader keyboard;
    BufferedWriter bw;  // 서버로 보낼 소켓의 버퍼 용
    BufferedReader br; // 서버가 보낸 메시지를 받는 버퍼
    BufferedWriter screen; // 서버가 보낸 메시지를 화면에 출력하는 버퍼
    public ClientSide(){
        try {
            System.out.println("1. 클라이언트 소켓 시작-------");
            Socket socket = new Socket("127.0.0.1",10000);
            System.out.println("2. 서버연결 완료.....");
            // 서버로 보낼 버퍼(BufferedWriter)
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            // 서버에서 받은 메시지를 읽어들이는 버퍼
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            screen = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 서버가 보낸 메시지 처리 스레드
            ReadThread readThread = new ReadThread();
            Thread thread = new Thread(readThread);
            thread.start();

            //키보드 메시지를 입력받은 버퍼
            while (true) {
                System.out.println("클라이언트 입력 대기 중-----");
                keyboard = new BufferedReader(new InputStreamReader(System.in));
                String keyboardMsg = keyboard.readLine();
                // 키보드로 받은 메시지를 소켓의 보낼 버퍼에 싣는다.
                bw.write(keyboardMsg + "\n");
                bw.flush();
            }

        } catch (IOException e) {
            System.out.println("클라이언트 소켓 에러 : " + e.getMessage());
        }
    }

    class ReadThread implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    String serverMsg = br.readLine();
                    System.out.println("서버가 보낸 메시지 : " + serverMsg);
                } catch (IOException e) {
                    System.out.println("클라이언트 소켓에서 입력받는 중 생긴 에러" + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        new ClientSide();
    }
}
