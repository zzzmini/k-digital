package ch03;

public class ExampleEx01 {
    static double calc(double gasoline, double distance){
        return (int)(distance / gasoline);
    }

    public static void main(String[] args) {
        double gasoline = 8.86;
        double distance = 182.736;
//        System.out.println(20.624830699774268);
        System.out.println((int)calc(gasoline, distance));
    }
}
