package top.tinn.NowCoder.Huawei_0923.Problem_03;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/23 19:15
 */
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //initial
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int numOfShops = scanner.nextInt();
        int[][] shop = new int[numOfShops][2];
        int[][] cost = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                cost[i][j] = (int)1e9;
            }
        }
        for (int i = 0; i < numOfShops; i++){
            for (int j = 0; j < 2; j++){
                shop[i][j] = scanner.nextInt();
            }
            cost[shop[i][0]][shop[i][1]] = 0;
        }
        int numOfZ = scanner.nextInt();
        int[][] Z = new int[numOfZ][2];
        for (int i = 0; i < numOfZ; i++){
            for (int j = 0; j < 2; j++){
                Z[i][j] = scanner.nextInt();
            }
            cost[Z[i][0]][Z[i][1]] = Integer.MAX_VALUE;
        }
        int numOfCustomer = scanner.nextInt();
        int[][] customer = new int[numOfCustomer][2];
        for (int i = 0; i < numOfCustomer; i++){
            for (int j = 0; j < 2; j++){
                customer[i][j] = scanner.nextInt();
            }
        }
        //initial finish
        for (int j = 0; j < numOfCustomer; j++){
            for (int i = 0; i < numOfShops; i++){
                dfs(cost, shop[i][0], shop[i][1], customer[j], 0, visited);
            }
        }
        int ans = 0;
        for (int j = 0; j < numOfCustomer; j++){
            if (cost[customer[j][0]][customer[j][1]] < (int)(1e9)){
                ans += 2 * (cost[customer[j][0]][customer[j][1]]);
            }
        }
        System.out.println(ans);
    }

    private static void dfs(int[][] cost, int i, int j, int[] customer, int distance, boolean[][] visited) {
        //越界
        if (i < 0 || i >= cost.length || j < 0 || j >= cost[0].length){
            return;
        }
        //障碍点 或者 已达
        if (cost[i][j] == Integer.MAX_VALUE || visited[i][j]){
            return;
        }
        //保存一下当前的最小距离
        if (cost[i][j] >= distance){
            cost[i][j] = distance;
        }else {
            return;
        }
        int customerI = customer[0];
        int customerJ = customer[1];
        //到达客户地址
        if (i == customerI && j == customerJ){
            if (cost[i][j] > distance){
                cost[i][j] = distance;
            }
        }
        //往四个方向进行dfs
        for (int d = 0; d < 4; d++){
            int newI = i + dx[d];
            int newJ = j + dy[d];
            //大于已有距离，取消
            if (newI < 0 || newI >= cost.length || newJ < 0 || newJ >= cost[0].length){
                continue;
            }
            if (cost[newI][newJ] < distance + 1){
                continue;
            }else {
                visited[i][j] = true;
                dfs(cost, newI, newJ, customer, distance + 1, visited);
                visited[i][j] = false;
            }
        }
    }
}
