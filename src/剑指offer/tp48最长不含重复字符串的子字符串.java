package 剑指offer;

public class tp48最长不含重复字符串的子字符串 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s.length() == 0) return 0;
            int l = 0, r = 0;
            int ans = 1;
            int [] hash = new int[128];
            char[] chars = s.toCharArray();
            while(r < s.length()){
                hash[chars[r] - ' ']++;
                if (hash[chars[r] - ' '] > 1){
                    ans = Math.max(ans, r - l);
                    while(hash[chars[r] - ' '] > 1){
                        hash[chars[l++] - ' ']--;
                    }
                }
                r++;
            }
//        System.out.println(l + " "+ r);
            return Math.max(ans, r - l);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
//
//
//
// 示例 1:
//
// 输入: "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//
// 示例 2:
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//
// 示例 3:
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//
//
//
// 提示：
//
//
// s.length <= 40000
//
//
// 注意：本题与主站 3 题相同：https://leetcode-cn.com/problems/longest-substring-without-
//repeating-characters/
//
// Related Topics 哈希表 字符串 滑动窗口 👍 495 👎 0

}
