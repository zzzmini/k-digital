package quiz_02;

public class SelectionSort {
    public static void main(String[] args) {
        // 배열 초기화
        int[] data = {2, 1, 3, 4, 5};
        // 원 데이터 출력
        // 출력하기
        System.out.printf("data : ");
        for (int x : data) {
            System.out.printf(x + " ");
        }
        System.out.println();

        // 정렬처리
        for (int i = 0; i < data.length - 1; i++) {
            // 바뀌었는지 확인하는 플래그
            boolean flag = false;
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] > data[j]) {
                    // 두 개 바꾸기
                    int temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                    flag = true;
                }
            }
            // 출력하기
            System.out.printf((i+1) + "회전 : ");
            for (int x : data) {
                System.out.printf(x + " ");
            }
            System.out.println();
            // 바꾼적이 있는지 확인
            if (flag == false) break;
        }
    }
}
