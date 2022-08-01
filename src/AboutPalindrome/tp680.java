package AboutPalindrome;

public class tp680 {
    int left = 0, right = 0;
    public boolean validPalindrome(String s) {
        if (judPali(s, 0, s.length() - 1)) return true;
        else {
            int tmpl = left, tmpr = right;
            return judPali(s, left + 1, right) || judPali(s, tmpl, tmpr - 1);
        }
    }

    boolean judPali(String s, int l, int r){
        if (s.length() == 1) return true;
        while(l < r){
            if (s.charAt(l) != s.charAt(r)) {
                left = l;right = r;
                return false;
            }
            l++;r--;
        }
        return true;
    }
}
