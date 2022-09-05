package daily;

public class tp652 {
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
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            return getMax(nums, 0,nums.length - 1);
        }
        public TreeNode getMax(int[] nums, int start, int end) {
            if (start >  end){
                return null;
            }
            int max = start;
            for (int i = start; i <= end; i++){
                if (nums[max] < nums[i]){
                    max = i;
                }
            }
            TreeNode node = new TreeNode(nums[max]);
            node.left = getMax(nums,start,max - 1);
            node.right = getMax(nums, max + 1, end);
            return node;
        }
    }
}
