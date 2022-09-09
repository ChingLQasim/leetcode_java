package daily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class tp1329 {
    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int row = mat.length, col = mat[0].length;
            for(int j = col - 1; j >=0 ; j--){
                int i = 0, k = j;
                List<Integer> temp = new ArrayList<>();
                temp.add(mat[i][j]);
                while (++i < row && ++k < col){
                    temp.add(mat[i][k]);
                }
                Collections.sort(temp);
                i = 0; k = j;
                mat[i][j] = temp.get(i);
                while (++i < row && ++k < col){
                    mat[i][k] = temp.get(i);
                }
            }
            if(row > 1){
                for (int i = 1; i < row - 1; i++){
                    int j = 0, k = i;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(mat[k][j]);
                    while (++j < col && ++k < row){
                        temp.add(mat[k][j]);
                    }
                    Collections.sort(temp);
                    j = 0; k = i;
                    mat[k][j] = temp.get(j);
                    while (++k < row && ++j < col){
                        mat[k][j] = temp.get(j);
                    }
                }
            }
            return mat;
        }
    }
}
