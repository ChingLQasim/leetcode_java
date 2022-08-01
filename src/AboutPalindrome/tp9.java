package AboutPalindrome;

/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
例如，121 是回文，而 123 不是。。
 */
public class tp9 {

    /*
    转化为字符串再进行处理
     */
    public boolean isPalindrome(int x) {
        char[] arr = String.valueOf(x).toCharArray();
        int len = arr.length;
        int l = 0, r = len - 1;
        while(l < r){
            if (arr[l] != arr[r]){
                return false;
            }
            l ++;r --;
        }
        return true;
    }
    /*
    直接处理数字
     */
    boolean isPalindrome2(int x){
        int ans  = 0 , len = 1;
        if (x < 0) return false;
        else if (x < 10) return true;
        else if (x % 10 == 0) return false;
        while (x > 0)
        {
            ans *= len;
            ans += x % 10 ;
            len *= 10;
            x /= 10;
        }
        return ans == x;
    }

}
