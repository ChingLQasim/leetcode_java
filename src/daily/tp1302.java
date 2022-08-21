package daily;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class tp1302 {
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

        class Solution {
            public int deepestLeavesSum(TreeNode root) {
                TreeNode[] q = new TreeNode[10001];
                int head = 0, tail = 1, count = 1, sum = 0;
                q[head] = root;
                if (q[head] == null) return 0;
                while (head != tail) {
                    int countcur = 0;
                    sum = 0;
                    while (count > 0) {
                        if (q[head].left != null) {
                            q[tail++] = q[head].left;
                            countcur++;
                        }
                        if (q[head].right != null) {
                            q[tail++] = q[head].right;
                            countcur++;
                        }
                        sum += q[head++].val;
                        count--;
                    }
                    count = countcur;
                }
                return sum;
            }
        }

        public class MainClass {
            public TreeNode stringToTreeNode(String input) {
                input = input.trim();
                input = input.substring(1, input.length() - 1);
                if (input.length() == 0) {
                    return null;
                }

                String[] parts = input.split(",");
                String item = parts[0];
                TreeNode root = new TreeNode(Integer.parseInt(item));
                Queue<TreeNode> nodeQueue = new LinkedList<>();
                nodeQueue.add(root);

                int index = 1;
                while (!nodeQueue.isEmpty()) {
                    TreeNode node = nodeQueue.remove();

                    if (index == parts.length) {
                        break;
                    }

                    item = parts[index++];
                    item = item.trim();
                    if (!item.equals("null")) {
                        int leftNumber = Integer.parseInt(item);
                        node.left = new TreeNode(leftNumber);
                        nodeQueue.add(node.left);
                    }

                    if (index == parts.length) {
                        break;
                    }

                    item = parts[index++];
                    item = item.trim();
                    if (!item.equals("null")) {
                        int rightNumber = Integer.parseInt(item);
                        node.right = new TreeNode(rightNumber);
                        nodeQueue.add(node.right);
                    }
                }
                return root;
            }

            public void main(String[] args) throws IOException {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                String line;
                while ((line = in.readLine()) != null) {
                    TreeNode root = stringToTreeNode(line);

                    int ret = new Solution().deepestLeavesSum(root);

                    String out = String.valueOf(ret);

                    System.out.print(out);
                }
            }
        }
    }
}

