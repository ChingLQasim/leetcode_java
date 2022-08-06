package DoublePointer;

import java.util.Arrays;

/*
珂珂喜欢吃香蕉。这里有 n 堆香蕉，第 i 堆中有piles[i]根香蕉。警卫已经离开了，将在 h 小时后回来。
珂珂可以决定她吃香蕉的速度 k （单位：根/小时）。每个小时，她将会选择一堆香蕉，
从中吃掉 k 根。如果这堆香蕉少于 k 根，她将吃掉这堆的所有香蕉，然后这一小时内不会再吃更多的香蕉。
珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
返回她可以在 h 小时内吃掉所有香蕉的最小速度 k（k 为整数）。

 */
public class tp875 {
    public int minEatingSpeed(int[] piles, int h) {
        int ans = 0, sum = 0;
        Arrays.sort(piles);
        int max = piles[piles.length - 1];
        int l = 1;
        while (l < max){
            int mid = max + l >> 1;
            if (check(mid, piles, h) >= 0) {
                max = max + l >> 1;
            }else{
                l = (max + l >> 1)  + 1;
            }
        }
        return l;
    }
    int check(int cur, int[] piles, int k){
        for (int i:
                piles) {
            k -= cur >= i ? 1 : (i % cur) == 0 ?  i / cur : i /cur + 1;
        }
        return k;
    }
}
