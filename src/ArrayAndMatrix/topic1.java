package ArrayAndMatrix;
/*
描述：在一个长度为 n 的数组里的所有数字都在 0 到 n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 */
public class topic1 {
    public int duplicate (int[] numbers) {
        boolean[] hsmap = new boolean[numbers.length];
        int len = numbers.length;
        while(--len != -1){
            if (hsmap[numbers[len]]){
                return numbers[len];
            }else {
                hsmap[numbers[len]] = true;
            }
        }
        return -1;
    }
}
