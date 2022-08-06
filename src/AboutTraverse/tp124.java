package AboutTraverse;
/*
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
路径和 是路径中各节点值的总和。
给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class tp124 {
    int maxSum =Integer.MIN_VALUE;
    public int maxPathSum(tp112.TreeNode root) {
        cal(root);
        return maxSum;
    }
    int cal(tp112.TreeNode root){
        if(root  == null){
            return 0;
        }
        int left = Math.max(cal(root.left), 0);
        int right = Math.max(cal(root.right), 0);
        int curPath = left + right + root.val;
        maxSum = Math.max(maxSum, curPath);
        return root.val + Math.max(left, right);
    }
}
