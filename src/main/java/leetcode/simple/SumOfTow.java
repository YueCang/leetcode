package leetcode.simple;

/**
 * @ClassName SumOfTow
 * @Description:
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * @Author Lyb
 * @Date 2021/4/6
 **/
public class SumOfTow {
    public static void main(String[] args) {

        int[] nums = {2,7,11,15};
        int target = 17;

        sumOfTow(nums,target);

    }

    public static int[] sumOfTow(int[] nums, int target){

        int[] position = new int[2];

        flag:for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];

                if(sum == target){
                    position[0] = i;
                    position[1] = j;
                    break flag;
                }
            }
        }

        return position;
    }
}
