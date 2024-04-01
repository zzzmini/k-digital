package thread;

class SubThread implements Runnable{
    @Override
    public void run() {
        for(int i=1; i<=5; i++){
            try {
                System.out.println("서브스레드 : " + i) ;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadEx01 {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        Thread thread = new Thread(subThread);
        thread.start();
        for(int i=1; i<=5; i++){
            try {
                System.out.println("메인스레드 : " + i);
                Thread.sleep(2000);  // 1000 -> 1초
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
