package 剑指offer;

import java.util.HashMap;

public class tp07重建二叉树 {
    class Solution {
        public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
        HashMap<Integer, Integer> map = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder.length == 1) return new TreeNode(preorder[0]);
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }
            return construct(0, 0, inorder.length - 1, preorder);
        }
        public TreeNode construct(int root , int left, int right, int[] preorder){
            if (left > right) return null;
            TreeNode node = new TreeNode(preorder[root]);
            int pos = map.get(preorder[root]);
            node.left = construct(root + 1,left, pos-1, preorder);
            node.right = construct(root + pos - left + 1, pos + 1, right, preorder);
            return node;
        }
    }

}
