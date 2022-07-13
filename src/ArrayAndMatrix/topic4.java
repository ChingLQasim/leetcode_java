package ArrayAndMatrix;

import java.util.ArrayList;

public class topic4 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int r1 = 0, r2 = matrix.length - 1, c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            // 上
            for (int i = c1; i <= c2; i++)
                ans.add(matrix[r1][i]);
            // 右
            for (int i = r1 + 1; i <= r2; i++)
                ans.add(matrix[i][c2]);
            if (r1 != r2)
                // 下
                for (int i = c2 - 1; i >= c1; i--)
                    ans.add(matrix[r2][i]);
            if (c1 != c2)
                // 左
                for (int i = r2 - 1; i > r1; i--)
                    ans.add(matrix[i][c1]);
            r1++; r2--; c1++; c2--;
        }
        return ans;
    }
    void print(int[][] matrix, ArrayList<Integer> list, int row, int col, int x , int y)
    {
        if (row == 1 && col == 1) list.add(matrix[x][y]);
        for (int i = 0; i < col; i++) {
            list.add(matrix[x][y+i]);
        }
        for (int i = 1; i < row; i++) {
            list.add(matrix[x+i][y]);
        }
        for (int i = col - 1; i >= 0; i--) {
            list.add(matrix[x + row - 1][y+i]);
        }
        for (int i = col - 1; i > 0; i++) {
            list.add(matrix[x+i][y]);
        }
    }
}
