package daily;

public class tp1343 {
    class Solution {
        public double angleClock(int hour, int minutes) {
            double temp = Math.abs(minutes * 6 - (hour % 12 * 30 + minutes * 0.5));
            return Math.min(temp, 360 - temp);
        }
    }
}
