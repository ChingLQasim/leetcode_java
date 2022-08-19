package daily;

import java.util.Scanner;

/*
描述：
    给定一个 N×M 的矩阵 A，
    请你统计有多少个子矩阵 (最小 1×1，最大 N×M) 满足子矩阵中所有数的和不超过给定的整数 K?
-------
输入格式：
第一行包含三个整数 N,M 和 K。
之后 N 行每行包含 M 个整数，代表矩阵 A。
 */
public class actp4405 {
    class Main{
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(), m = sc.nextInt(), k = sc.nextInt();
            int [][] s = new int[n + 1][m + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    s[i][j] = sc.nextInt() + s[i - 1][j];
                }
            }
            long res = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    for (int l = 1, r = 1, sum = 0; r <= m; r++){
                        sum += s[j][r] - s[i - 1][r];
                        while (sum > k) {
                            sum -= s[j][l] - s[i - 1][l];
                            l ++;
                        }
                        res += r - l + 1;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
