package ch04.calcArea;

public class Triangle extends Figure{
    public Triangle(int width, int height){
        this.height = height;
        this.width = width;
    }
    public double calcArea(){
        return (getWidth() * getHeight())/2;
    }
    public void printResult(){
        System.out.println("너비 : " + getWidth() +
                "높이 : " + getHeight() +
                "인 삼각형의 넓이는 " + calcArea());
    }
}
