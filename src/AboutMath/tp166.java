package AboutMath;

import java.util.HashMap;

/*
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。
如果小数部分为循环小数，则将循环的部分括在括号内。
如果存在多个答案，只需返回 任意一个 。
对于所有给定的输入，保证 答案字符串的长度小于 104 。
 */
public class tp166 {
    public String fractionToDecimal(long numerator, long denominator) {
        String ans = "";
        HashMap mp = new HashMap<>();
        if ((double)numerator / (double) denominator < 0.0) ans +="-";
        numerator = Math.abs(numerator);denominator = Math.abs(denominator);
        long n = numerator / denominator;
        long res = numerator % denominator;
        ans += String.valueOf(n);
        if (res == 0) return ans;
        ans+=".";
        int index = ans.length();
        while(res  != 0 && mp.get(res) == null){
            mp.put(res, index);
            index++;
            n = (res * 10) / denominator;
            res = (res * 10) % denominator;
            ans += String.valueOf(n);
        }
        if (res != 0){
            StringBuffer sb =  new StringBuffer(ans);
            sb.insert((Integer) mp.get(res), "(");
            ans = sb.toString() + ")";
        }
        return ans;
    }
}
