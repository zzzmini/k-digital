package basic.sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] data = {4, 2, 3, 1, 5};
        // 바꿀 대상의 인덱스
        int index = 0;
        int min = 9999999;
        // 바뀔 위치를 지정하는 기능
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i; j < data.length; j++) {
                if (data[j] < min) {
//                    min = data[j];
                    index = j;
                }
            }
            // 가장 작은 값은 인덱스를 찾으면 두개를 교환
            if (index == i) {
                break;
            } else {
                int temp = data[i];
                data[i] = data[index];
                data[index] = temp;

                // 인쇄
                System.out.println((i+1) + "단계 : " + Arrays.toString(data));
                min = 999999;
            }
        }
    }
}
