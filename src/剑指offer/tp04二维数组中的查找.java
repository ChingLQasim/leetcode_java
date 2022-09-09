package 剑指offer;

public class tp04二维数组中的查找 {
    class Solution {
        public boolean findNumberIn2DArray(int[][] matrix, int target) {
            if (matrix.length == 0) return false;
            int n = 0, m = matrix[0].length - 1;
            while (m >= 0 && n <= matrix.length - 1) {
                if (matrix[n][m] == target) return true;
                if (matrix[n][m] > target) m--;
                else n++;
            }
            return false;
        }
    }
}
