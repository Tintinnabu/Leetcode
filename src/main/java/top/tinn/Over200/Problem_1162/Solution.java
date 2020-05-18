package top.tinn.Over200.Problem_1162;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 20:56
 */
public class Solution {
    public int maxDistance(int[][] grid) {
        int row = grid.length;
        if (row == 0){
            return 0;
        }
        int col = row;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (grid[i][j] == 1){
                    queue.offer(new int[]{i, j});
                }
            }
        }
        //从陆地开始BFS,直到队列中陆地为0
        boolean hasOcean = false;
        int[] cur = null;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        while (!queue.isEmpty()){
            cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; i++){
                int newX = x + dx[i];
                int newY = y + dy[i];
                if (newX < 0 || newX >= col || newY < 0 || newY >= row || grid[newX][newY] > 0){
                    continue;
                }
                grid[newX][newY] = grid[x][y] + 1;
                hasOcean = true;
                queue.offer(new int[]{newX, newY});
            }
        }
        if (cur == null || !hasOcean){
            return -1;
        }
        return grid[cur[0]][cur[1]] - 1;
    }

    @Test
    public void test(){
        int[][] grid = new int[2][2];
        grid[0] = new int[]{1, 0};
        grid[1] = new int[]{0, 0};
        System.out.println(maxDistance(grid));
    }
}
