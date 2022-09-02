package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class tp76 {


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minWindow(String s, String t) {
            if (s == "" || t.length() == 0) return "";
            //存储需要的字符
            Map<Character, Integer> map = new HashMap<>();
            for (char c : t.toCharArray()) {
                map.put(c,map.getOrDefault(c,0) + 1);
            }
            //存储最终的答案，其中a[1,2]为字符串位置,a[0]为长度
            int [] a = new int[3];
            a[0] = Integer.MAX_VALUE;
            //左右指针维护窗口
            int l = 0, r = 0, need = 0,exam = map.keySet().size();
            //转换目标字符串
            char[] chars = s.toCharArray();
            //建立滚动映射
            Map<Character, Integer> hashMap = new HashMap<>();
            //遍历目标字符串
            while (r < s.length()){
                hashMap.put(chars[r],
                        //如果已经存在加上一不存在直接放入0
                        hashMap.containsKey(chars[r]) ? hashMap.get(chars[r]) + 1 : 1);
                if (map.containsKey(chars[r]) && hashMap.get(chars[r]).intValue() == map.get(chars[r]).intValue()) need++;
                while (l <= r && (need == exam)){
                    if (r - l + 1 < a[0]){
                        a[0] = r - l + 1;
                        a[1] = l;
                        a[2] = r + 1;
                    }
                    hashMap.put(chars[l], hashMap.getOrDefault(chars[l],1) - 1);
                    if (map.containsKey(chars[l]) && hashMap.get(chars[l]) < map.get(chars[l])) need--;
                    l++;
                }
                r++;
            }
            return a[0] != Integer.MAX_VALUE ? s.substring(a[1],a[2]) : "";
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

//给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
//
//
//
// 注意：
//
//
// 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
// 如果 s 中存在这样的子串，我们保证它是唯一的答案。
//
//
//
//
// 示例 1：
//
//
//输入：s = "ADOBECODEBANC", t = "ABC"
//输出："BANC"
//
//
// 示例 2：
//
//
//输入：s = "a", t = "a"
//输出："a"
//
//
// 示例 3:
//
//
//输入: s = "a", t = "aa"
//输出: ""
//解释: t 中两个字符 'a' 均应包含在 s 的子串中，
//因此没有符合条件的子字符串，返回空字符串。
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 10⁵
// s 和 t 由英文字母组成
//
//
//
//进阶：你能设计一个在
//o(n) 时间内解决此问题的算法吗？
//
// Related Topics 哈希表 字符串 滑动窗口 👍 2112 👎 0

}
