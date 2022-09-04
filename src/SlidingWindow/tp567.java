package SlidingWindow;

import java.util.HashMap;
import java.util.Map;
//
//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
//
// 换句话说，s1 的排列之一是 s2 的 子串 。
//
//
//
// 示例 1：
//
//
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
//
//
// 示例 2：
//
//
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= s1.length, s2.length <= 10⁴
// s1 和 s2 仅包含小写字母
//
//
public class tp567 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;
        int windowSize = s1.length(), length = s2.length(), l = 0, r = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> hashmap = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        while(r < length){
            char cr = s2.charAt(r);
            if (r - l < windowSize){
                if (map.containsKey(cr)){
                    hashmap.put(cr,
                            hashmap.getOrDefault(cr, 0 ) + 1);
                    if (hashmap.get(cr).intValue() > map.get(cr).intValue()){
                        while(l <= r && hashmap.get(s2.charAt(l)).intValue()
                                > map.get(s2.charAt(l)).intValue()){
                            hashmap.put(s2.charAt(l),
                                    hashmap.get(s2.charAt(l)) - 1);
                            l++;
                        }
                    }
                    r++;
                }else{
                    r++;
                    while(l < r ){
                        if (hashmap.containsKey(s2.charAt(l)))
                            hashmap.put(s2.charAt(l),
                                    hashmap.get(s2.charAt(l)) - 1);
                        l++;
                    }
                }
            }
            if (r - l == windowSize){
                System.out.println(r + "--" + l);
                return true;
            }
        }
        return false;
    }
}
