package SlidingWindow;

import java.util.Deque;
import java.util.LinkedList;

public class tp239 {//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位
//。
//
// 返回 滑动窗口中的最大值 。
//
//
//
// 示例 1：
//
//
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
// 示例 2：
//
//
//输入：nums = [1], k = 1
//输出：[1]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
// 1 <= k <= nums.length
//
//
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 1823 👎 0

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] maxSlidingWindow(int[] nums, int k) {
            if (nums.length == 1) return new int[]{nums[0]};
            if (k == 1) return nums;
            int [] ans = new int[nums.length - k + 1];
            Deque<Integer> queue = new LinkedList<>();
            for (int i = 0; i < nums.length; i++) {
                while (!queue.isEmpty() && nums[queue.getLast()] < nums[i])
                    queue.removeLast();
                queue.add(i);
                if (queue.getFirst() == i - k){
                    queue.removeFirst();
                }
                if (i - k + 1 >= 0){
                    ans[i - k + 1] = nums[queue.getFirst()];
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
