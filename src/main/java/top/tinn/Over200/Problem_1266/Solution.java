package top.tinn.Over200.Problem_1266;

public class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        if (points.length < 2){
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < points.length; i++){
            int dx = Math.abs(points[i][0] - points[i - 1][0]);
            int dy = Math.abs(points[i][1] - points[i - 1][1]);
            ans = ans + Math.min(dx, dy) + Math.abs(dx - dy);
        }
        return ans;
    }
}
