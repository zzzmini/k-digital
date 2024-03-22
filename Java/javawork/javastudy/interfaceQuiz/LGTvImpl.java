package interfaceQuiz;

public class LGTvImpl implements RemoconAble{
    @Override
    public void greenButton() {
        System.out.println("LT TV 전원이 켜졌습니다.");
    }

    @Override
    public void redButton() {
        System.out.println("LT TV 전원이 꺼졌습니다.");
    }
}
