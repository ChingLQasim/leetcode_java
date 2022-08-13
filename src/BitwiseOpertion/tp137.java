package BitwiseOpertion;
/*
给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
public class tp137 {
    public int singleNumber(int[] nums) {
        int cur = 0, count[] = new int[32];
        for (int a:
             nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += a & 1;
                a >>= 1;
            }
        }
        for (int i = 31; i >= 0; i--) {
            cur <<= 1;
            cur |= count[i] % 3;
        }
        return cur;
    }
}
