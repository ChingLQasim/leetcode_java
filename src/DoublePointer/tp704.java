package DoublePointer;

/*
给定一个n个元素有序的（升序）整型数组nums和一个目标值target ，
写一个函数搜索nums中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class tp704 {
    int ans = -1;
    public int search(int[] nums, int target) {
        binarySearch(nums, target, 0, nums.length - 1);
        return ans;
    }
    void binarySearch(int[] nums, int target, int l , int r){
        if (l > r) return ;
        int mid = nums[l + r >> 1];
        if (target > mid) binarySearch(nums, target, (l + r >> 1)  + 1, r);
        else if (target == mid){
            ans = l + r >> 1;
        }
        else {
            binarySearch(nums, target, l ,(l + r >> 1)  - 1 );
        }
    }
}

