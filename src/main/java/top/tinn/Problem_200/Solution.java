package top.tinn.Problem_200;

import org.junit.jupiter.api.Test;

public class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length<1) return 0;
        int num=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    num++;
                    dfs(grid,i,j);
                }
            }
        }
        return num;
    }

    private void dfs(char[][] grid,int row,int column){
        if(row<0||row>=grid.length||column<0||column>=grid[0].length||grid[row][column]=='0')
            return;
        grid[row][column]='0';
        dfs(grid,row+1,column);
        dfs(grid,row-1,column);
        dfs(grid,row,column+1);
        dfs(grid,row,column-1);
    }

    @Test
    public void test(){
        char[][] grid=new char[4][5];
        grid[0]=new char[]{'1','1','1','1','0'};
        grid[1]=new char[]{'1','1','0','1','0'};
        grid[2]=new char[]{'1','1','0','0','0'};
        grid[3]=new char[]{'1','0','0','1','0'};
        System.out.println(numIslands(grid));
    }
}
