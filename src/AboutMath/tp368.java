package AboutMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
        answer[i] % answer[j] == 0 ，或
        answer[j] % answer[i] == 0
        如果存在多个有效解子集，返回其中任何一个均可。
 */

public class tp368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length, maxLen = 1, maxVal = nums[0];
        int [] dp = new int[len];
        for (int i = 0; i < len; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            if (maxLen < dp[i]){
                maxLen = dp[i];
                maxVal = nums[i];
            }
        }
        if (maxLen == 1) {
            ans.add(nums[0]);
            return ans;
        }
        for (int i = len - 1; i >= 0 && maxLen > 0; i--) {
            if (dp[i] == maxLen && maxVal%nums[i] == 0){
                ans.add(nums[i]);
                maxLen--;
                maxVal = nums[i];
            }
        }
        return ans;
    }
}
