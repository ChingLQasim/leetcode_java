package BitwiseOpertion;

/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。
 */
public class tp260 {
    public int[] singleNumber(int[] nums) {
        int a =0, b = 0, temp = 0;
        for (int x:
             nums) {
            temp ^= x;
        }
        int tp = 1;
        while((temp & tp) == 0) tp<<=1;
        for (int x:
             nums) {
            if ((x & tp) == 0){
                a ^= x;
            }else b ^= x;
        }
        return new int[]{a, b};
    }
}
