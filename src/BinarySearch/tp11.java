package BinarySearch;
/*
给定一个长度为 n 的整数数组height。有n条垂线，第 i 条线的两个端点是(i, 0)和(i, height[i])。
找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
返回容器可以储存的最大水量。
说明：你不能倾斜容器。
 */

import java.util.HashMap;
import java.util.Map;

public class tp11 {
    public int maxArea(int[] height) {
        int ans = 0, len = height.length;
        Map<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < len; i++) {
            mp.put(i, height[i]);
        }
        return ans;
    }
}
