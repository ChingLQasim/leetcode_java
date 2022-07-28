package AboutMath;

import java.util.*;

/*
题目描述：
给你一个由 n 个整数组成的数组nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组[nums[a], nums[b], nums[c], nums[d]]
（若两个四元组元素一一对应，则认为两个四元组重复）：
    · 0 <= a, b, c, d< n
    · a、b、c 和 d 互不相同
    · nums[a] + nums[b] + nums[c] + nums[d] == target
你可以按 任意顺序 返回答案 。
 */
public class tp18 {
    /*
    解法一：回溯法：
     */
    public void bfs(int [] nums, int target, List<Integer> tmp, List<List<Integer>> ans, HashSet hashSet, int startPos){
        if (target == 0 && tmp.size() == 4){
            Integer[] a = new Integer[tmp.size()];
            tmp.toArray(a);
            Arrays.sort(a);
            if (hashSet.contains(Arrays.toString(a))){
                return ;
            }else {
                hashSet.add(Arrays.toString(a));
                //System.out.println(Arrays.toString(tmp.toArray()));
                ans.add(new ArrayList<Integer>(tmp));
                return ;
            }
        }
        int len = nums.length;
        for (int i = startPos; i < len; i++) {
            tmp.add(nums[i]);
            bfs(nums, target - nums[i], tmp, ans, hashSet, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        HashSet hashSet = new HashSet();
        bfs(nums, target, tmp, ans, hashSet, 0);
        return ans;
    }
}
