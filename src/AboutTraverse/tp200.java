package AboutTraverse;

import java.util.ArrayList;
import java.util.List;

/*
给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

 */
public class tp200 {
    List<String> lis = new ArrayList<>();
    public int numIslands(char[][] grid) {
        int ans = 0, rows = grid.length, cols = grid[0].length, count = 0;
        //Map<String, Boolean> visit = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int i1 = 0; i1 < cols; i1++) {
                if (grid[i][i1] == '1'){
                    //visit.put(i + " " + i1, true);
                    //lis.add(i + " " + i1);
                    count++;
                    bfs(i1, i, rows, cols, grid);
                }
            }
        }
        // while (!lis.isEmpty()){
        //     int row = Integer.parseInt(lis.get(0).substring(0,1));
        //     int col = Integer.parseInt(lis.get(0).substring(2,3));
        //     bfs(col, row, rows, cols, grid);
        //     count++;
        // }
        return count;
    }
    void bfs(int col, int row, int rows, int cols, char[][] grid){
        if (col >= cols || row >= rows || col < 0 || row < 0) return ;
        if (grid[row][col] == '0') return ;
        grid[row][col] = '0';
        //lis.remove(row + " " + col);
        bfs(col + 1, row, rows, cols, grid);
        bfs(col - 1, row, rows, cols, grid);
        bfs(col, row + 1, rows, cols, grid);
        bfs(col, row - 1, rows, cols, grid);
    }
}
