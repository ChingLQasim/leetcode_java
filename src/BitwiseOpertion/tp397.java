package BitwiseOpertion;
/*
给定一个正整数n ，你可以做如下操作：
如果n是偶数，则用n / 2替换n 。
如果n是奇数，则可以用n + 1或n - 1替换n 。
返回 n变为 1 所需的 最小替换次数 。
 */
public class tp397 {
    /*
    递归搜索
     */
    public int integerReplacement(int n) {
        if (n == Integer.MAX_VALUE) return 32;
        if (n == 1) return 0;
        else if (n % 2 == 0) return 1 + integerReplacement(n / 2);
        else  return 1 + Math.min(integerReplacement(n - 1), integerReplacement(n + 1));
    }
    /*
    位运算
     */
    int integerReplacement2(int n){
        if (n == 1)
            return 0;
        if (n == Integer.MAX_VALUE)
            return 32;
        int count = 0;
        while (n > 3) {
            if (n % 2 == 0)
                n >>= 1;
            else if ((n + 1) % 4 == 0)
                n += 1;
            else
                n -= 1;
            count++;
        }
        return n == 3 ? count + 2 : count + 1; // 处理 n==3 的特殊情况
    }
}
