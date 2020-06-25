package top.tinn.Over200.Problem_1232;

public class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length < 3){
            return true;
        }
        int x1 = coordinates[0][0], y1 = coordinates[0][1];
        int x2 = coordinates[1][0], y2 = coordinates[1][1];
        for (int i = 2; i < coordinates.length; i++){
            int x3 = coordinates[i][0], y3 = coordinates[i][1];
            if ((y3 - y2) * (x1 - x2) != (y1 - y2) * (x3 - x2)){
                return false;
            }
        }
        return true;
    }
}
