package AboutTraverse;

import java.util.ArrayList;
import java.util.List;

/*
给你二叉树的根节点 root 和一个整数目标和 targetSum ，
找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
叶子节点 是指没有子节点的节点

 */
public class tp113 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(targetSum, root, temp, ans);
        return ans;
    }

    void dfs(int sum , TreeNode root, List<Integer> temp,List<List<Integer>> ans){
        if(root == null) return ;
        temp.add(root.val);
        //if (root.left == null && root.right == null) temp.remove(temp.size() - 1);
        if (sum - root.val == 0 && root.left == null && root.right == null){
            ans.add(new ArrayList<>(temp));
            temp.remove(temp.size() - 1);
            //ans.add(temp);
            return ;
        }
        dfs(sum - root.val, root.left, temp,ans);
        dfs(sum - root.val, root.right, temp, ans);
        temp.remove(temp.size() - 1);
    }
}
