package Tree;

import java.util.ArrayList;
import java.util.List;

public class tp589pre {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };
    List<Integer> ans = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) return new ArrayList<>();
        ans.add(root.val);
        if (root.children.isEmpty())
            return ans;
//        root.children.forEach(node -> preorder(node));
        for (Node node : root.children){
            preorder(node);
        }
        return ans;
    }
}
