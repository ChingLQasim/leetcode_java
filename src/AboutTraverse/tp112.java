package AboutTraverse;
/*
给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和targetSum。
如果存在，返回 true ；否则，返回 false 。
叶子节点 是指没有子节点的节点。
 */

import javax.swing.tree.TreeNode;

public class tp112 {
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
  boolean flag = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
          if (root == null) return false;
          dfs(targetSum, root);
          return flag;
    }
    void dfs(int sum , TreeNode root){
          if (sum - root.val == 0 && root.left == null && root.right == null){
              flag = true;
              return ;
          }
        if (root.left != null)
            dfs(sum - root.val, root.left);
        if (root.right != null)
            dfs(sum - root.val, root.right);
    }
}
