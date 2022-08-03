package AboutPalindrome;

/*
如果一个正整数自身是回文数，而且它也是一个回文数的平方，那么我们称这个数为超级回文数。

现在，给定两个正整数L 和R （以字符串形式表示），返回包含在范围 [L, R] 中的超级回文数的数目。

 */
public class tp906 {
    public int superpalindromesInRange(String left, String right) {
        Long lt = Long.parseLong(left);
        Long rt = Long.parseLong(right);
        int ans = 0;
        for (Long i = 1L; i < 100000; i++) {
            String base = String.valueOf(i);
            String odd = base + new StringBuilder(base).reverse().toString().substring(1, base.length());
            Long curodd = Long.parseLong(odd) * Long.parseLong(odd);
            if(curodd <= rt && curodd >=lt && isPalinddrome(String.valueOf(curodd)) ){
                ans++;
            }
            String even = base + new StringBuilder(base).reverse().toString();
            Long curoeven = Long.parseLong(even) * Long.parseLong(even);
            if(curoeven <= rt && curoeven >=lt && isPalinddrome(String.valueOf(curoeven)) ){
                ans++;
            }
        }
        return ans;
    }
    boolean isPalinddrome(String s){
        int len = s.length();
        if (len == 1) return true;
        int l = 0, r = len - 1;
        while(l  < r){
            if (s.charAt(l) != s.charAt(r)) return false;
            l ++;r --;
        }
        return true;
    }
}
