package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    ServerSocket serverSocket;
    Socket socket;
    BufferedReader br;  // 클라이언트가 보낸 메시지 읽기 용
    public BufferedReader keyboard; // 클라이언트에 보낼 입력 메시지 용
    public BufferedWriter bw; // 클라이언트에 보낼 버퍼
    public ServerSide(){
        System.out.println("1. 서버 소켓 시작 ------");

        try {
            serverSocket = new ServerSocket(10000);
            System.out.println("2. 서버소켓 생성 완료-------");
            System.out.println("3. 클라이언트 연결 대기 중------");
            socket = serverSocket.accept();
            System.out.println("4. 클라이언트 연결 완료");
            // 클라이언트가 보낸 메시를 읽어 들이는 버퍼 생성
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 키보드로 입력받는 메시지 저장용
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            // 입력받은 메시지를 소켓에 담을 버퍼
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            // 클라이언트에 보내는 역할의 스레드를 생성해서 실행
            WriteThread writeThread = new WriteThread();
            Thread thread = new Thread(writeThread);
            thread.start();

            while (true) {
                String clinetMsg = br.readLine();
                System.out.println("클라이언트 메시지 : " +clinetMsg);
            }
        } catch (IOException e) {
            System.out.println("서버소켓 에러 : " + e.getMessage());
        }
    }

    class WriteThread implements Runnable{
        @Override
        public void run() {
            while (true) {
                try {
                    String keyboardMsg = keyboard.readLine();
                    bw.write(keyboardMsg + "\n");
                    bw.flush();
                } catch (IOException e) {
                    System.out.println("서버소켓 키보드 입력에러 : " + e.getMessage());
                }
            }
        }
    }


    public static void main(String[] args) {
        new ServerSide();
    }
}

