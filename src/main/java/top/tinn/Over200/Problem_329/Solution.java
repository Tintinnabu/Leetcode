package top.tinn.Over200.Problem_329;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] count = new int[row][col];
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                for (int k = 0; k < 4; k++){
                    int curX = i + dx[k];
                    int curY = j + dy[k];
                    //有比自己小的邻居2,入度+1
                    if (0 <= curX && curX < row && 0 <= curY && curY < col
                            && matrix[curX][curY] < matrix[i][j]){
                        count[i][j]++;
                    }
                }
            }
        }
        Deque<int[]> deque = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (count[i][j] == 0){
                    deque.add(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!deque.isEmpty()){
            ans++;
            for (int size = deque.size(); size > 0 ; size--){
                int[] poll = deque.poll();
                for (int k = 0; k < 4; k++){
                    int curX = poll[0] + dx[k];
                    int curY = poll[1] + dy[k];
                    //有比自己小的邻居2,入度+1
                    if (0 <= curX && curX < row && 0 <= curY && curY < col
                            && matrix[curX][curY] > matrix[poll[0]][poll[1]]){
                        //入度-1
                        if (--count[curX][curY] == 0){
                            deque.add(new int[]{curX, curY});
                        }
                    }
                }
            }
        }
        return ans;
    }
}
