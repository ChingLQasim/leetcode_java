package 剑指offer;

import java.util.HashSet;
import java.util.Set;

public class tp38字符串的排列 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        Set<String> set = new HashSet<>();
        public String[] permutation(String s) {
            dfs(s.toCharArray(), new boolean[s.length()], new StringBuilder());
            String[] ans = new String[set.size()];
            int i = 0;
            for(String str : set){
                ans[i++] = str;
            }
            return ans;
        }
        void dfs(char[] s, boolean[] vi, StringBuilder sb) {
            if (sb.length() == s.length) {
                set.add(sb.toString());
                System.out.println(sb);
                return;
            }
            for (int i = 0; i < s.length; i++) {
                if (vi[i] == false){
                    sb.append(s[i]);
                    vi[i] = true;
                }else continue;
                dfs(s, vi, sb);
                sb.deleteCharAt(sb.length() - 1);
                vi[i] = false;
            }
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

//输入一个字符串，打印出该字符串中字符的所有排列。
//
//
//
// 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
//
//
//
// 示例:
//
// 输入：s = "abc"
//输出：["abc","acb","bac","bca","cab","cba"]
//
//
//
//
// 限制：
//
// 1 <= s 的长度 <= 8
//
// Related Topics 字符串 回溯 👍 608 👎 0

}
