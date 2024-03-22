package interfaceQuiz;

public class SamsungTvImpl implements RemoconAble{
    @Override
    public void greenButton() {
        System.out.println("삼성 TV 전원이 켜졌습니다.");
    }

    @Override
    public void redButton() {
        System.out.println("삼성 TV 전원이 꺼졌습니다.");
    }
}
