package quiz_02;

public class Q_01 {
    public static void main(String[] args) {
        // 배열 만들고 초기화 하기
        int[] nums = {3, 29, 38, 12, 57, 74, 40, 85, 61};
//        최댓값 : 85, 인덱스 : 7
//        최솟값 : 3, 인덱스 : 0
        // 최댓값과 인덱스를 담을 변수
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;

        // 최솟값과 인덱스를 담을 변수
        int min = Integer.MAX_VALUE;
        int minIndex = 0;

        // 배열을 순회하면서 위 값들을 찾는다.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                maxIndex = i;
            }
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        // 출력하기
        System.out.println("최댓값 : " + max + ", 인덱스 : " + maxIndex);
        System.out.println("최솟값 : " + min + ", 인덱스 : " + minIndex);
    }
}
