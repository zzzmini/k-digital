package ch06;

public class ArrayEx01 {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6};

        //advanced for 구문
        for(int i : nums){
            System.out.println(i);
        }


        System.out.println(nums[0]);
        System.out.println(nums[1]);
        System.out.println(nums[2]);
//        System.out.println(nums[3]);

        for(int i= 0 ; i<nums.length; i++){
            System.out.println("length : " + nums.length);
            System.out.println("nums[" + i + "] = " + nums[i]);
        }


        // 반복처리 할 때 사용하는 방법
        // 1부터 10까지 더하는 루프
        int sum = 0;
        for(int i=1; i<=10; i++){
            sum = sum + i;
//            sum += i;
        }
        System.out.println(sum);
    }
}
