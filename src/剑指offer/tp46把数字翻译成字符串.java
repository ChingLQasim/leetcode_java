package 剑指offer;

public class tp46把数字翻译成字符串 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int ans = 1;
        public int translateNum(int num) {
            String nums = String.valueOf(num);trans(nums);
            return ans;
        }
        void trans(String nums){
            if (nums.length() >= 2){
                int i = Integer.parseInt(nums.substring(0, 2));
                if (i < 26 && i > 9){
                    ans ++;
                    trans(nums.substring(2, nums.length()));
                    trans(nums.substring(1, nums.length()));
                }else{
                    trans(nums.substring(1, nums.length()));
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可
//能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
//
//
//
// 示例 1:
//
// 输入: 12258
//输出: 5
//解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
//
//
//
// 提示：
//
//
// 0 <= num < 2³¹
//
//
// Related Topics 字符串 动态规划 👍 485 👎 0

}
