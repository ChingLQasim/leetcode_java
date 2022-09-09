package BinarySearch;

import java.util.ArrayList;
import java.util.List;

public class tp436 {
    class Solution {
        class Node {
            int pos;
            int val;
            Node (int pos, int val){
                this.pos = pos;
                this.val = val;
            }
        }
        public int[] findRightInterval(int[][] intervals) {
            int [] ans = new int[intervals.length];
            List<Node> list = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                Node node = new Node(i, intervals[i][0]);
                list.add(node);
            }
            list.sort((a, b) -> a.val == b.val ? a.pos - b.pos : a.val - b.val);
            for (int i = 0; i < intervals.length; i++) {
                ans[i] = find(intervals[i], list);
            }
            return ans;
        }
        public int find(int[] interval, List<Node> list) {
            if (interval[1] > list.get(list.size() - 1).val) return -1;
            int l = 0, r = list.size() - 1;
            while (l < r){
                int mid = r + l >> 1;
                Node target = list.get(mid);
                if (target.val >= interval[1]) r = mid;
                else l = ++mid;
            }
            return list.get(r).pos;
        }
    }
}
