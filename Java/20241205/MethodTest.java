package basic.method;

public class MethodTest {
    public static void main(String[] args) {
        String printData = "이것 출력해 주세요";
        printTitle(printData);
        System.out.println("출력하고 다녀옴");
        // 두 수를 전달해서 합을 계산하는 메서드(함수)
        int result = addNumbers(3, 4);
        printTitle("결과 " + result);

        // 두 수를 빼는 기능을 만들고 결과를 출력(minusNumbers)
        printTitle("결과 " + minusNumbers(4, 1));

    }

    static int minusNumbers(int numA, int numB) {
        return numA - numB;
    }

    static int addNumbers(int numA, int numB) {
//        int sum = numA + numB;
        return numA + numB;
    }

    static void printTitle(String data) {
        System.out.println(data);
    }
}