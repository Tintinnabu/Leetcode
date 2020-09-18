package top.tinn.NowCoder.JD_0917.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/17 19:40
 */
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean reach = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int g = 0; g < groups; g++){
            //initial
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            char[][] map = new char[n][m];
            int[] gongzhu = new int[2];
            int[] wangzi = new int[2];
            reach = false;
            for (int i = 0; i < n; i++){
                String cur = scanner.next();
                for (int j = 0; j < m; j++){
                    map[i][j] = cur.charAt(j);
                    if (cur.charAt(j) == 'E'){
                        gongzhu = new int[]{i, j};
                    }else if (cur.charAt(j) == 'S'){
                        wangzi = new int[]{i, j};
                    }
                }
            }
            //process
            boolean[][] visited = new boolean[n][m];
            if (dfs(map, gongzhu, wangzi, visited)){
                sb.append("YES\n");
            }else {
                sb.append("NO\n");
            }
        }
        //print
        System.out.println(sb);
    }

    public static boolean dfs(char[][] map, int[] start, int[] end, boolean[][] visited){
        if (reach){
            return true;
        }
        int i = start[0], j = start[1];
        int n = map.length, m = map[0].length;
        //越界 或者 已达 或者 遇到障碍物
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || map[i][j] == '#'){
            return false;
        }
        if (start[0] == end[0] && start[1] == end[1]){
            return true;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++){
            int newI = i + dx[k];
            int newJ = j + dy[k];
            reach |= dfs(map, new int[]{newI, newJ}, end, visited);
        }
        return reach;
    }
}
