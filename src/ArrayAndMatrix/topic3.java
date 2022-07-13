package ArrayAndMatrix;

import org.junit.Test;

public class topic3 {
    @Test
    public void replaceSpace () {
        //调用原生api
        String s = "We Are Happy";
        s = s.replace(" ", "%20");
        System.out.println(s);
    }
}
