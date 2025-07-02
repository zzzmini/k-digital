package ch03;

public class ArrayEx03 {
    public static void main(String[] args) {
        // 배열의 크기만 선언
        int[] nums = new int[5];
        nums[0] = 1;
        nums[3] = 3;
        // nums 의 0 번째 위치에 5를 누적
        nums[0] = nums[0] + 5;


//        nums[5] = 7;
        for (int x : nums) {
            System.out.println(x);
        }
    }
}
