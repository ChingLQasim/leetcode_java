package AboutMath;

/*
给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。子数组 是数组中的一个连续部分。
 */
public class tp53 {
    public int maxSubArray(int[] nums) {
        return dp(nums);
    }
    /*
    动态规划
     */
    int dp(int[] nums){
        int maxSum = nums[0];
        int[] curSA = new int[nums.length];
        curSA[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curSA[i] = curSA[i-1] > 0 ? curSA[i - 1] + nums[i] : nums[i];
            maxSum = Math.max(curSA[i], maxSum);
        }
        return maxSum;
    }
    /*
    前缀和
     */
    int prefixSum(int[] nums){
        int max = nums[0], min = 0, sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - min);
            min = Math.min(sum, min);
        }
        return max;
    }


}
