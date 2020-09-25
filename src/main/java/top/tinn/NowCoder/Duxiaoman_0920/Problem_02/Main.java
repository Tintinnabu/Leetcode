package top.tinn.NowCoder.Duxiaoman_0920.Problem_02;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/20 20:35
 */
public class Main {
    static int min;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = Integer.parseInt(scanner.nextLine());
        StringBuilder ret = new StringBuilder();
        while (groups > 0){
            //initial
            String[] nm = scanner.nextLine().split(" ");
            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);
            char[][] map = new char[n][m];
            int startI = 0, startJ = 0;
            min = Integer.MAX_VALUE;
            boolean[][] visited = new boolean[n][m];
            for (int i = 0; i < n; i++){
                String row = scanner.nextLine();
                for (int j = 0; j < m; j++){
                    map[i][j] = row.charAt(j);
                    if (row.charAt(j) == '@'){
                        startI = i;
                        startJ = j;
                    }
                }
            }
            //process
            dfs(map, startI, startJ, visited, 0);
            //end process
            if (min == Integer.MAX_VALUE){
                ret.append("-1\n");
            }else {
                ret.append(min).append("\n");
            }
            groups--;
        }
        System.out.println(ret.toString());
    }

    private static void dfs(char[][] map, int curI, int curJ, boolean[][] visited, int count) {
        //已经超出已有最小值
        if (count >= min){
            return;
        }
        //到达边界
        if (curI < 0 || curI >= map.length || curJ < 0 || curJ >= map[0].length){
            min = Math.min(min, count);
            return;
        }
        //已达 或者 不可破坏
        if (visited[curI][curJ] || map[curI][curJ] == '#'){
            return;
        }
        //遇到可破坏障碍
        if (map[curI][curJ] == '*'){
            if (count == min - 1){
                return;
            }
            for (int i = 0; i < 4; i++){
                int newI = curI + dx[i];
                int newJ = curJ + dy[i];
                visited[curI][curJ] = true;
                dfs(map, newI, newJ, visited, count + 1);
                visited[curI][curJ] = false;
            }


        }
        if (map[curI][curJ] == '.' || map[curI][curJ] == '@'){
            for (int i = 0; i < 4; i++){
                int newI = curI + dx[i];
                int newJ = curJ + dy[i];
                visited[curI][curJ] = true;
                dfs(map, newI, newJ, visited, count);
                visited[curI][curJ] = false;
            }

        }
    }
}
