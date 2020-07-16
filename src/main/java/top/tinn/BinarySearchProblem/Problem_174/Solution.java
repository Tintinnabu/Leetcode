package top.tinn.BinarySearchProblem.Problem_174;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 174. 地下城游戏
 *
 * 一些恶魔抓住了公主（P）并将她关在了地下城的右下角。地下城是由 M x N 个房间组成的二维网格。我们英勇的骑士（K）最初被安置在左上角的房间里，他必须穿过地下城并通过对抗恶魔来拯救公主。
 *
 * 骑士的初始健康点数为一个正整数。如果他的健康点数在某一时刻降至 0 或以下，他会立即死亡。
 *
 * 有些房间由恶魔守卫，因此骑士在进入这些房间时会失去健康点数（若房间里的值为负整数，则表示骑士将损失健康点数）；其他房间要么是空的（房间里的值为 0），要么包含增加骑士健康点数的魔法球（若房间里的值为正整数，则表示骑士将增加健康点数）。
 *
 * 为了尽快到达公主，骑士决定每次只向右或向下移动一步。
 *
 *  
 *
 * 编写一个函数来计算确保骑士能够拯救到公主所需的最低初始健康点数。
 *
 * 例如，考虑到如下布局的地下城，如果骑士遵循最佳路径 右 -> 右 -> 下 -> 下，则骑士的初始健康点数至少为 7。
 *
 * -2 (K)	-3	3
 * -5	-10	1
 * 10	30	-5 (P)
 *  
 *
 * 说明:
 *
 * 骑士的健康点数没有上限。
 *
 * 任何房间都可能对骑士的健康点数造成威胁，也可能增加骑士的健康点数，包括骑士进入的左上角房间以及公主被监禁的右下角房间。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dungeon-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon.length==0||dungeon[0].length==0) return 0;
        int rowSize=dungeon.length;
        int colSize=dungeon[0].length;
        int[][] dp=new int[rowSize][colSize];
        dp[rowSize-1][colSize-1]=Math.max(0,-dungeon[rowSize-1][colSize-1]);
        for (int i=rowSize-2;i>=0;i--){
            int needMin=dp[i+1][colSize-1]-dungeon[i][colSize-1];
            dp[i][colSize-1]=Math.max(0,needMin);
        }
        for (int j=colSize-2;j>=0;j--){
            int needMin=dp[rowSize-1][j+1]-dungeon[rowSize-1][j];
            dp[rowSize-1][j]=Math.max(0,needMin);
        }
        for (int i=rowSize-2;i>=0;i--){
            for (int j=colSize-2;j>=0;j--){
                int needMin=Math.min(dp[i][j+1],dp[i+1][j])-dungeon[i][j];
                dp[i][j]=Math.max(0,needMin);
            }
        }
        return dp[0][0]+1;
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int row = dungeon.length - 1;
        if (row < 0){
            return 0;
        }
        int col = dungeon[0].length - 1;
        int[][] dp = new int[row + 1][col + 1];
        for (int i = row; i >= 0; i--){
            for (int j = col; j >= 0; j--){
                if (i == row && j == col){
                    dp[i][j] = dungeon[i][j] <= 0 ? 1 - dungeon[i][j] : 1;
                }else if (i == row){
                    dp[row][j] = Math.max(1, dp[row][j + 1] - dungeon[row][j]);
                }else if (j == col){
                    dp[i][col] = Math.max(1, dp[i + 1][col] - dungeon[i][col]);
                }else{
                    dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
                }
            }
        }
        return dp[0][0];
    }

    @Test
    public void test(){
        int[][] dungeon=new int[3][3];
        dungeon[0]=new int[]{-2,-3,3};
        dungeon[1]=new int[]{-5,-10,1};
        dungeon[2]=new int[]{10,30,-5};
        System.out.println(calculateMinimumHP2(dungeon));
    }
}
