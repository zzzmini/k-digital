package view;

public class ViewImpl implements ViewInterface{
    @Override
    public void addView() {
        System.out.println("멤버 추가 화면");
    }

    @Override
    public void updateView() {
        System.out.println("멤버 수정 화면");
    }

    @Override
    public void removeView() {
        System.out.println("멤버 삭제 화면");
    }

    @Override
    public void ListView() {
        System.out.println("멤버 리스트보기 화면");
    }
}
