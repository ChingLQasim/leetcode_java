package DoublePointer;

/*
峰值元素是指其值严格大于左右相邻值的元素。
给你一个整数数组nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
你可以假设nums[-1] = nums[n] = -∞ 。
你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

 */
public class tp162 {
    public int findPeakElement(int[] nums) {
        int ans = 0;
        int l = 0, r = nums.length - 1;
        if (r == 0) return r;
        while(l < r){
            if (nums[l + 1] > nums[l]) {
                if (nums[l + 1] > (l + 2 >= nums.length ? Integer.MIN_VALUE : nums[l + 2])) return l + 1;
                else l++;
            }else if (nums[l + 1] < nums[l] && l == 0) return l;
            else l++;
            if (nums[r - 1] > nums[r]) {
                if (nums[r - 1] > (r - 2 < 0 ? Integer.MIN_VALUE : nums[r - 2])) return r - 1;
                else r--;
            } else if (nums[r - 1] < nums[r] && r == nums.length - 1) return r;
            else r--;
        }
        return -1;
    }
}
