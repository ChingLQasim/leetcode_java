package daily;

import java.util.Arrays;
import java.util.Map;

/*
这个问题和“最多能完成排序的块”相似，但给定数组中的元素可以重复，输入数组最大长度为2000，其中的元素最大为10**8。
arr是一个可能包含重复元素的整数数组，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
我们最多能将数组分成多少块？
 */
public class tp768 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 1;
        if (arr.length == 1) return ans;
        int [] r = new int[arr.length];
        r[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0 ; i --){
            r[i] = Math.min(r[i + 1], arr[i]);
        }
        int l = arr[0];
        Arrays.stream(arr).forEach(System.out::println);
        for (int i = 1; i < arr.length ; i ++){
            l = Math.max(l , arr[i]);
            ans = l > r[i] ? ans : ++ans;
        }
        return ans;
    }
}
