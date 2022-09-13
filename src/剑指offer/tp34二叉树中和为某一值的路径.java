package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class tp34二叉树中和为某一值的路径 {
    //leetcode submit region begin(Prohibit modification and deletion)
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    class Solution {
        List<List<Integer>> ans = new ArrayList<>();
        int target;
        public List<List<Integer>> pathSum(TreeNode root, int target) {
            if (root == null) return ans;
            this.target = target;
            travel(root, new ArrayList<Integer>());
            return ans;
        }
        void travel(TreeNode root, List<Integer> list){
            if (root == null) return ;
            list.add(root.val);
            if (root.left == null && root.right == null){
                Integer res = list.stream().reduce(0, Integer::sum);
//            System.out.println(res);
                if (res == target) ans.add(new ArrayList<>(list));
                if (!list.isEmpty())
                    list.remove(list.size() - 1);
                return;
            }
            travel(root.left, list);
            travel(root.right, list);
            if (!list.isEmpty())
                list.remove(list.size() - 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

//给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：[[5,4,11,2],[5,8,4,5]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,2,3], targetSum = 5
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], targetSum = 0
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点总数在范围 [0, 5000] 内 
// -1000 <= Node.val <= 1000 
// -1000 <= targetSum <= 1000 
// 
//
// 注意：本题与主站 113 题相同：https://leetcode-cn.com/problems/path-sum-ii/ 
//
// Related Topics 树 深度优先搜索 回溯 二叉树 👍 372 👎 0

}
