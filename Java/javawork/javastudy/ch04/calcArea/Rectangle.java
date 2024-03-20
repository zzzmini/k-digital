package ch04.calcArea;

public class Rectangle {
    Figure figure;
    public Rectangle(Figure figure){
        this.figure = figure;
    }
    public int calcArea(){
        return figure.getWidth() * figure.getHeight();
    }
    public void printResult(){
        System.out.println("너비 : " + figure.getWidth() +
                "높이 : " + figure.getHeight() +
                "인 사각형의 넓이는 " + calcArea());
    }
}
