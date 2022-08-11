package BitwiseOpertion;
/*
实现加法
 */
public class tp371 {
    public int getSum(int a, int b) {
        while(b != 0){
            int temp = b;
            b = (a & b) << 1;a ^= temp;
        }
        return a;
    }
}
