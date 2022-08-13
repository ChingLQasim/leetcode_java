package daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
有n个人被分成数量未知的组。每个人都被标记为一个从 0 到 n - 1 的唯一ID。
给定一个整数数组 groupSizes ，其中groupSizes[i]是第 i 个人所在的组的大小。例如，如果groupSizes[1] = 3，则第 1 个人必须位于大小为 3 的组中。
返回一个组列表，使每个人 i 都在一个大小为groupSizes[i]的组中。
每个人应该恰好只出现在一个组中，并且每个人必须在一个组中。如果有多个答案，返回其中任何一个。可以保证给定输入至少有一个有效的解。
 */
public class tp1282 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, ArrayList<Integer>> lens = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if (lens.containsKey(groupSizes[i])){
                lens.get(groupSizes[i]).add(i);
            }else {
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                lens.put(groupSizes[i],tmp);
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> entry : lens.entrySet()){
            int nums = entry.getKey();
            ArrayList<Integer> li = entry.getValue();
            int re = li.size() / nums;
            for (int i = 0; i < re; i++) {
                ans.add(li.subList(i*nums, i*nums + nums));
            }
        }
        return ans;
    }
}
