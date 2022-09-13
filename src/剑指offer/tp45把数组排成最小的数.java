package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class tp45把数组排成最小的数 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> list = new ArrayList<>();
        public String minNumber(int[] nums) {
            for (int num : nums) {
                list.add(String.valueOf(num));
            }
            list.sort((a, b)->{
                if (a.length() == b.length()) return a.compareTo(b);
                else {
                    int len = Math.max(a.length(), b.length()), suba = a.length(), subb = b.length();
                    String ta = new String(a), tb = new String(b);
                    while(suba != len){
                        ta+=String.valueOf(a.charAt(suba % a.length()));
                        suba++;
                    }
                    while(subb != len){
                        tb+=String.valueOf(b.charAt(subb % b.length()));
                        subb++;
                    }
                    if(ta.compareTo(tb)==0) {
                        return new String(a + b).compareTo(new String(b + a));
                    }
                    return ta.compareTo(tb);
                }
            });
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : list) {
                stringBuilder.append(s);
            }
            return stringBuilder.toString();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
//
//
//
// 示例 1:
//
// 输入: [10,2]
//输出: "102"
//
// 示例 2:
//
// 输入: [3,30,34,5,9]
//输出: "3033459"
//
//
//
// 提示:
//
//
// 0 < nums.length <= 100
//
//
// 说明:
//
//
// 输出结果可能非常大，所以你需要返回一个字符串而不是整数
// 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
//
//
// Related Topics 贪心 字符串 排序 👍 541 👎 0

}
