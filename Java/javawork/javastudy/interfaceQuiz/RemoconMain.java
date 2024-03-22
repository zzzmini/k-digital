package interfaceQuiz;

public class RemoconMain {
    public static void main(String[] args) {
        LGTvImpl lgTv = new LGTvImpl();
        SamsungTvImpl samsungTv = new SamsungTvImpl();

        RemoconAble lg = new LGTvImpl();
        RemoconAble sTv = new SamsungTvImpl();
        lg.greenButton();
        lg.redButton();
        System.out.println("==============================");
        lgTv.greenButton();
        lgTv.redButton();
        samsungTv.greenButton();
        samsungTv.redButton();
    }
}
