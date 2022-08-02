package AboutPalindrome;

/*
给你一个字符串 s，找到 s 中最长的回文子串。
 */

public class tp5 {
    /*
    动态规划
     */
    public String longestPalindrome(String s) {
        int len = s.length(), min = 0, max = 0 , max_len = 0;
        if (len == 0 || len == 1) return s;
        boolean [][] dp = new boolean[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][ j - 1]);
                if (dp[i][j] && (j - i + 1) > max_len){
                    max = j;
                    min = i;
                    max_len = j - i + 1;
                }
            }
        }
        return s.substring(min, max + 1);
    }
    /*
    中心扩散法
     */
    public String longestPalindrome2(String s) {
        String o1 = null, o2 = null;
        int len = s.length();
        if (len == 0 || len == 1) return s;
        String ans = s.substring(0,1);
        for (int i = 0; i < len - 1; i++) {
            o1 = extend(i , i , s);
            o2 = extend(i , i + 1, s);
            if (Math.max(o1.length(), o2.length()) > ans.length()){
                ans = o1.length() > o2.length() ? o1 : o2;
            }
        }
        return ans;
    }
    String extend(int l , int r, String s){
        int len = s.length();
        while (l >= 0 && r < len && s.charAt(l) == s.charAt(r)){
            l --;r ++;
        };
        return s.substring(l + 1, r);
    }

}
