package 剑指offer;

import java.util.ArrayList;
import java.util.List;

public class tp36二叉搜索树与双向链表 {
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.

*/
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    };
    class Solution {
        List<Node> list =  new ArrayList<>();
        public Node treeToDoublyList(Node root) {
            if (root == null) return null;
            preoder(root);int len = list.size();
            Node head = list.get(0);
//        list.stream().forEach(a-> System.out.println(a.val));
            for(int i = 0; i < len; i++){
                list.get(i).left = list.get(i - 1 < 0 ? len - 1 : i - 1);
                list.get(i).right = list.get((i + 1) % len);
            }
//        System.out.println(head.right.left.val);
//        System.out.println(head.left.left.val);
            return head;
        }
        void preoder(Node root){
            if (root == null) return ;
            preoder(root.left);
            list.add(root);
            preoder(root.right);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

//输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向。
//
//
//
// 为了让您更好地理解问题，以下面的二叉搜索树为例：
//
//
//
//
//
//
//
// 我们希望将这个二叉搜索树转化为双向循环链表。链表中的每个节点都有一个前驱和后继指针。对于双向循环链表，第一个节点的前驱是最后一个节点，最后一个节点的后继是
//第一个节点。
//
// 下图展示了上面的二叉搜索树转化成的链表。“head” 表示指向链表中有最小元素的节点。
//
//
//
//
//
//
//
// 特别地，我们希望可以就地完成转换操作。当转化完成以后，树中节点的左指针需要指向前驱，树中节点的右指针需要指向后继。还需要返回链表中的第一个节点的指针。
//
//
//
// 注意：本题与主站 426 题相同：https://leetcode-cn.com/problems/convert-binary-search-tree-
//to-sorted-doubly-linked-list/
//
// 注意：此题对比原题有改动。
//
// Related Topics 栈 树 深度优先搜索 二叉搜索树 链表 二叉树 双向链表 👍 576 👎 0

}
