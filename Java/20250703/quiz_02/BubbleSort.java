package quiz_02;

public class BubbleSort {
    public static void main(String[] args) {
        // 배열 초기화
        int[] data = {9, 8, 2, 4, 3};
        // 출력
        System.out.printf("초기 배열 : ");
        for (int i = 0; i < data.length; i++) {
            System.out.printf(String.valueOf(data[i]) + " ");
        }
        System.out.println();
        // 버블정렬 시작
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data.length - i; j++) {
                // 비교해서 앞이 크면 바꾸기
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j+1] = temp;
                }
            }
            // 회전결과 출력
            System.out.printf(i + "회전 : ");
            for (int k = 0; k < data.length; k++) {
                System.out.printf(String.valueOf(data[k]) + " ");
            }
            System.out.println();
        }
    }
}
