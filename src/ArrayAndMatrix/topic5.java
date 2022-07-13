package ArrayAndMatrix;

import com.sun.security.jgss.GSSUtil;
import org.junit.Test;

public class topic5 {
    @Test
    public void FirstNotRepeatingChar() {
        String str = "google";
        int[] cnts = new int[128];
        for (int i = 0; i < str.length(); i++)
            cnts[str.charAt(i)]++;
        for (int i = 0; i < str.length(); i++)
            if (cnts[str.charAt(i)] == 1)
                System.out.println(i);
        return ;
    }
}
