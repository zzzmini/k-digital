package ch04.a;

public class Cal {
    void plus(){
        System.out.println("Plus");
    }
    private void minus(){
        System.out.println("Minus");
    }
    public void multi(){
        minus();
        System.out.println("Multi");
    }
    protected void divide(){
        System.out.println("Divide");
    }
}
