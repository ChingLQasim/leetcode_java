package AboutMath;

import java.util.HashMap;
import java.util.Map;
/*
给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
    ·0 <= i, j, k, l < n
    ·nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */

public class tp454 {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> mp = new HashMap<>();
        int n =nums1.length, ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp =nums1[i] + nums2[j];
                if (mp.get(temp) == null){
                    mp.put(temp, 1);
                }else {
                    mp.replace(temp, mp.get(temp) + 1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = nums3[i] + nums4[j];
                if (mp.get(-temp) != null) {
                    ans += mp.get(-temp);
                }
            }
        }
        return ans;
    }
}
