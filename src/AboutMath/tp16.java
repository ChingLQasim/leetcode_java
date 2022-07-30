package AboutMath;

import java.util.Arrays;

/*
给你一个长度为 n 的整数数组nums和 一个目标值target。请你从 nums 中选出三个整数，使它们的和与target最接近。

返回这三个数的和。

假定每组输入只存在恰好一个解。

 */
public class tp16 {
    public int threeSumClosest(int[] nums, int target) {
        int len = nums.length, ans = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = len -1 ;
            while (l < r){
                int temp = nums[i] + nums[l] + nums[r];
                if (temp == target) return temp;
                if (Math.abs(temp -target) < Math.abs(ans - target)){
                    ans = temp;
                }
                if (temp > target){
                    r --;
                }else if (temp < target){
                    l ++;
                }

            }
        }
        return ans;
    }
}
