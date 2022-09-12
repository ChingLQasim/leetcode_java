package 剑指offer;

public class tp33二叉搜索树的后序遍历 {
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public class treeNode {
            int val;
            treeNode left;
            treeNode right;
            treeNode(int x) { val = x; }
        }
        int pos = 0;
        private int[] position;
        public boolean verifyPostorder(int[] postorder) {
            if (postorder.length == 0 || postorder.length == 1) return true;
            this.position = postorder;
            treeNode root = new treeNode(postorder[postorder.length - 1]);
            for(int i = postorder.length - 2; i >=0 ;i --){
                construct(root, postorder[i]);
            }
//        inorder(root);
            return post(root);
        }
//    void inorder(treeNode root){
//        if (root == null) return;
//        inorder(root.left);
//        System.out.println(root.val);
//        inorder(root.right);
//    }

        void construct(treeNode root, int value){
            if (root.val > value){
                if (root.left != null) construct(root.left, value);
                else {
                    root.left = new treeNode(value);
                }
            }else {
                if (root.right != null) construct(root.right, value);
                else {
                    root.right = new treeNode(value);
                }
            }
        }
        boolean post(treeNode root){
            if (root == null) return true;
            return post(root.left) && post(root.right) && root.val == position[pos++];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
//
//
//
// 参考以下这颗二叉搜索树：
//
//      5
//    / \
//   2   6
//  / \
// 1   3
//
// 示例 1：
//
// 输入: [1,6,3,2,5]
//输出: false
//
// 示例 2：
//
// 输入: [1,3,2,6,5]
//输出: true
//
//
//
// 提示：
//
//
// 数组长度 <= 1000
//
//
// Related Topics 栈 树 二叉搜索树 递归 二叉树 单调栈 👍 605 👎 0

}
