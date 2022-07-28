package AboutMath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
题目描述：
给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 */
public class tp15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans =  new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1, r = len -1 ;
            while (l < r){
                if (nums[i] + nums[l] + nums[r] > 0){
                    r --;
                }else if (nums[i] + nums[l] + nums[r] < 0){
                    l ++;
                }else{
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l + 1]){
                        l ++;
                    }
                    while (l < r && nums[r] == nums[r - 1]){
                        r --;
                    }
                    r --;
                    l ++;
                }

            }
        }
        return ans;
    }
}
