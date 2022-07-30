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

    /*
    回溯剪枝
     */
    void findNum(int[] nums, int target, int N, List<Integer> tmp, List<List<Integer>> ans){
        if (nums.length < N || N < 2) return ;
        if (N == 2){
            int l = 0, r = nums.length -1;
            while(l < r){
                if (nums[l] + nums[r] == target) {
                    List<Integer> bufList = new ArrayList<>(tmp);
                    bufList.add(nums[l]);
                    bufList.add(nums[r]);
                    ans.add(bufList);
                    l += 1;
                    r -= 1;
                    while (l < r && nums[l] == nums[l - 1])
                        l += 1;
                    while (r > l && nums[r] == nums[r + 1])
                        r -= 1;
                }
                else if (nums[l] + nums[r] < target) l += 1;
                else r -= 1;
            }
        } else {
            for (int i = 0; i < nums.length; i++)
                if (i == 0 || i > 0 && nums[i - 1] != nums[i]) {
                    int[] buf_nums = new int[nums.length - i - 1];
                    for (int j = i + 1; j < nums.length; j++)
                        buf_nums[j - i - 1] = nums[j];
                    List<Integer> bufList = new ArrayList<>(tmp);
                    bufList.add(nums[i]);
                    findNum(buf_nums, target - nums[i], N - 1,
                            bufList, ans);
                }
            }
        }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        HashSet hashSet = new HashSet();
        bfs(nums, target, tmp, ans, hashSet, 0);
        findNum(nums, target, 4, tmp, ans);
        return ans;
    }
}
