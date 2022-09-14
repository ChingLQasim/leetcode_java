package 剑指offer;

public class tp66构建乘积数组 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] constructArr(int[] a) {
            if (a.length == 0 || a.length == 1) return a;
            int[] b = new int[a.length], c = new int[a.length];
            b[0] = 1;c[a.length - 1] = 1;
            for(int i = 1; i < a.length ; i++){
                b[i] = b[i - 1] * a[i - 1];
            }
            for (int i = a.length - 2; i >= 0 ; i--){
                c[i] = c[i + 1] * a[i + 1];
            }
            for (int i = 0 ; i < a.length ; i ++){
                a[i] =  b[i] * c[i];
            }
            return a;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
//
//
//
// 示例:
//
//
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24]
//
//
//
// 提示：
//
//
// 所有元素乘积之和不会溢出 32 位整数
// a.length <= 100000
//
//
// Related Topics 数组 前缀和 👍 268 👎 0

}
