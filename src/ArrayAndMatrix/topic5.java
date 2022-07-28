package ArrayAndMatrix;

import com.sun.security.jgss.GSSUtil;
import org.junit.Test;

public class topic5 {
    @Test
    public void FirstNotRepeatingChar() {
        String str = "google";
        int[] hs = new int[128];
        int pos =-1,count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (++hs[str.charAt(i)] > 1)
                count ++;
        }

        if (count == str.length()) return ;
        while(++pos < str.length()&&hs[str.charAt(pos)]== 1);
        System.out.println(pos);
    }
}
