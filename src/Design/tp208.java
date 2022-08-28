package Design;

/**
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 *  void insert(String word) 向前缀树中插入字符串 word 。
 *  boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 *  boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class tp208 {
    class TreeNode{
        private TreeNode[] links;
        private final int num = 26;
        boolean isEnd = false;
        public TreeNode(){
            links = new TreeNode[num];
        }
        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TreeNode get(char ch){
            return links[ch - 'a'];
        }

        public void put(char ch, TreeNode node){
            links[ch - 'a'] = node;
        }
        public void setEnd(){
            isEnd = true;
        }
        public boolean isEnd(){
            return isEnd;
        }
    }
    class Trie {
        private TreeNode root;
        public Trie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)){
                    node.put(c, new TreeNode());
                }
                node = node.get(c);
            }
            node.setEnd();
        }

        public boolean search(String word) {
            TreeNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.containsKey(c)) return false;
                else {
                    node = node.get(c);
                }
            }
            return node.isEnd();
        }

        public boolean startsWith(String prefix) {
            TreeNode node = root;
            for (char c : prefix.toCharArray()) {
                if (!node.containsKey(c)) return false;
                else {
                    node = node.get(c);
                }
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
}
