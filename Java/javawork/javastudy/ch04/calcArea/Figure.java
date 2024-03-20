package ch04.calcArea;

public class Figure {
    int width;
    int height;
    public Figure(){}
    public Figure(int width, int height){
        this.width = width;
        this.height = height;
    }
    public int getWidth(){
        return this.width;
    }
    public void setWidth(int width){
        this.width = width;
    }
    public int getHeight(){
        return this.height;
    }
    public void setHeight(int height){
        this.height = height;
    }
}
