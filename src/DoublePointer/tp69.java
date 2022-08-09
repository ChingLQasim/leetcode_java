package DoublePointer;
/*
给你一个非负整数 x ，计算并返回x的 算术平方根 。

由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。

注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

 */
public class tp69 {
    public int mySqrt(int x) {
        double t = x, ans = 0;
        while(Math.abs(t - x / t) < 1e-12 * t){
            t = (ans + x / t)/2 ;
        }
        return (int)t;
    }
}
