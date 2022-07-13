package ArrayAndMatrix;
/*
描述：给定一个二维数组，其每一行从左到右递增排序，从上到下也是递增排序。给定一个数，判断这个数是否在该二维数组中。
 */
public class topic2 {
    public boolean Find(int target, int [][] array) {
        if (array == null) return false;
        int n = array.length;
        int m = array[0].length;
        if (n * m == 0) return false;
        int row = 0, col = m-1;
        while(row <= n - 1 && col >= 0){
            if (target == array[row][col]){
                return true;
            } else if (target > array[row][col]) {
                row ++;
            }else {
                col --;
            }
        }
        return false;
    }
}
