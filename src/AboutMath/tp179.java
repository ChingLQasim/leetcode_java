package AboutMath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class tp179 {
    public String largestNumber(int[] nums) {
        List<String> shu = new ArrayList<>();
        for (int a: nums) {
            shu.add(String.valueOf(a));
        }
        Collections.sort(shu, new StringComparator());
        //Collections.reverse(shu);
        String ans = "";
        for (String item: shu) {
            ans += item;
        }
        /*
        这里要注意将前导0去除
         */
        int index = -1;
        if (ans.charAt(0) == '0'){
            while(index < ans.length() - 1){
                index ++;
                if (ans.charAt(index) != '0') break;
            }
        }
        return index < 0 ? ans : ans.substring(index, ans.length());
    }
     class StringComparator implements Comparator<String> {
        /**
         * 重写比较函数
         */
        @Override
        public int compare(String o1, String o2) {
            String a = o1 +o2, b =o2 + o1;
            return b.compareTo(a);
        }
    }
}
