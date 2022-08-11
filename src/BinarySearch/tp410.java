package BinarySearch;

/*
给定一个非负整数数组 nums 和一个整数 m ，你需要将这个数组分成 m 个非空的连续子数组。
设计一个算法使得这 m 个子数组各自和的最大值最小。
 */
public class tp410 {
    public int splitArray(int[] nums, int m) {
        int ans  = 0, len = nums.length;
        if (len == 1) return nums[0];
        int l = nums[0], r = 0;
        for (int a:
             nums) {
            l = Math.max(l , a);
            r += a;
        }
        while (l <= r){
            int mid = l + (r - l >> 2);
            if (l == r) return l;
            if (jud(mid, nums, m)) r = mid;
            else l = mid + 1;
        }
        return -1;
    }

    private boolean jud(int mid, int[] nums, int m) {
        int count = 1, cur = 0;
        for (int a:
             nums) {
            if(cur + a > mid){
                cur = a;count ++;
            }else cur += a;
        }
        return count < m;
    }
}
