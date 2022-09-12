package 剑指offer;

public class tp16数值的整数次方 {
    class Solution {
        public double myPow(double x, int n) {
            long N = n; return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
        }
        public double quickMul(double x, long N) {
//        if (N == 0) {
//            return 1.0;
//        }
//        double y = quickMul(x, N / 2);
//        return N % 2 == 0 ? y * y : y * y * x;
            double ans = 1.0;
            double x_count = x;
            while (N > 0){
                if (N % 2 == 1) ans *= x_count;
                x_count *= x_count;
                N /= 2;
            }
            return ans;
        }
    }
}
