package top.tinn.Contest.Contest_Single_200.Problem_03;

public class Solution {
    public int minSwaps(int[][] grid) {
        int n =  grid.length;
        int[] f = new int[n];
        // 记录每一行里面从右边开始数第一个1的位置
        // 要满足对角线以上的格子全部都是 0，必须满足:f[i] <= i
        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--){
                if (grid[i][j] == 1){
                    f[i] = j;
                    break;
                }
            }
        }
        int ans = 0, pos = 0;
        for (int i = 0; i < n; i++){
            if (f[i] <= i){
                continue;
            }
            int j;
            for (j = i + 1; j < n; j++){
                if (f[j] <= i){
                    //pos为最先满足条件的行数
                    pos = j;
                    break;
                }
            }
            if (j == n){
                return -1;
            }
            for (int k = pos; k > i; k--){
                //交换f[k-1]和f[k]
                int tmp = f[k-1];
                f[k-1] = f[k];
                f[k] = tmp;
            }
            ans += pos - i;
        }
        return ans;
    }
}
