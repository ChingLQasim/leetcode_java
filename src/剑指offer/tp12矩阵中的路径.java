package 剑指offer;

public class tp12矩阵中的路径 {

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        char[][] board;
        String word;
        public boolean exist(char[][] board, String word) {
            this.board = board;this.word = word;
            for (int i = 0 ;i < board.length ;i++){
                for (int j = 0; j < board[0].length ; j++) {
                    if (board[i][j] == word.charAt(0) && (isExist(0,i, j, new boolean[board.length][board[0].length]) || word.length() == 1))
                        return true;
                }
            }
            return false;
        }
        public boolean isExist(int pos,int i, int j, boolean[][] visited){
            if (pos + 1 >= word.length()) return true;
            visited[i][j] = true;
            pos = pos + 1; char t = word.charAt(pos);
            boolean a = false, b = false, c = false, d = false;
            if (i + 1 < board.length && board[i + 1][j] == t && visited[i + 1][j] == false) {
                a = isExist(pos, i + 1, j, visited);
            }
            if (i - 1 >= 0 && board[i - 1][j] == t && visited[i - 1][j] == false) {
                b = isExist(pos, i - 1, j, visited);
            }
            if (j + 1 < board[0].length && board[i][j + 1] == t && visited[i][j + 1] == false) {
                c = isExist(pos, i, j + 1, visited);
            }
            if (j - 1 >=0 && board[i][j - 1] == t && visited[i][j - 1] == false) {
                d = isExist(pos, i, j - 1, visited);
            }
            if((a || b || c || d) == false) visited[i][j] = false;
            return a || b || c || d;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
//
//
//
// 例如，在下面的 3×4 的矩阵中包含单词 "ABCCED"（单词中的字母已标出）。
//
//
//
//
//
// 示例 1：
//
//
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
//
//
// 示例 2：
//
//
//输入：board = [["a","b"],["c","d"]], word = "abcd"
//输出：false
//
//
//
//
// 提示：
//
//
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
//
//
// 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
//
// Related Topics 数组 回溯 矩阵 👍 673 👎 0

}
