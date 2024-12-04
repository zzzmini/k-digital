package basic.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {9, 8, 2, 4, 3};
        // 값의 바뀜 유무를 확인하는 아이
        boolean flag = false;
        for (int i = 1; i < data.length; i++) {
            for (int j = 0; j < data.length-i; j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                    flag = true;
                }
            }
            // 바뀜이 일어났는지 체크
            if (flag == false) {
                break;
            } else {
                // 1단계 : 8 2 4 3 9
                System.out.println(i + "단계 : " + Arrays.toString(data));
                flag = false;
            }
        }
    }
}
