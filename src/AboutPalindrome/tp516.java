package AboutPalindrome;
/*
给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
。
 */
public class tp516 {
    public int longestPalindromeSubseq(String s) {
        int ans = 0, len = s.length();
        int dp[][] = new int[len + 1][len + 1];
        for (int i = len - 1; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if(i == j) dp[i][j] += 1;
                else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i + 1][j-1] + 2;
                }else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
