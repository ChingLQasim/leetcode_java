package AboutMath;

/*
请你帮忙给从 1 到 n的数设计排列方案，使得所有的「质数」都应该被放在「质数索引」（索引从 1 开始）上；你需要返回可能的方案总数。
让我们一起来回顾一下「质数」：质数一定是大于 1 的，并且不能用两个小于它的正整数的乘积来表示。
由于答案可能会很大，所以请你返回答案 模 mod10^9 + 7之后的结果即可。

 */
public class tp1175 {
    public int numPrimeArrangements(int n) {
        int ans = 0 , primes = 0;
        if (n < 3) return 1;
        primes ++;
        for (int i = 3; i <= n; i++) {
            if (judPrimes(i)){
                primes ++;
            }
        }

        return (int)(factorial((long)primes) % 1000000007 *(factorial((long)n - (long)primes) % 1000000007) % 1000000007);
    }

    public boolean judPrimes(int n){
        if(n % 2 == 0) return false;
        for (int i = 3; i <= n / i; i+=2) {
            if (i != n && n % i == 0){
                return false;
            }
        }
        return true;
    }

    public long factorial(long n){
        return n == 1 ? 1 : ((long)factorial(n - 1) % 1000000007) * (n % 1000000007) % 1000000007;
    }
}
