package top.tinn.NowCoder.Meituan_0927.Problem_04;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/27 11:07
 */
public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int xs = scanner.nextInt() - 1;
        int ys = scanner.nextInt() - 1;
        int xt = scanner.nextInt() - 1;
        int yt = scanner.nextInt() - 1;
        int[][] a = new int[n][m];
        int[][] path = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                a[i][j] = scanner.nextInt();
                path[i][j] = Integer.MAX_VALUE;
            }
        }
        path[xt][yt] = 0;
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                b[i][j] = scanner.nextInt();
            }
        }

        //initial finished
        boolean[][] visited = new boolean[n][m];
        dfs(xs, ys, xt, yt, a, b, 0, visited, path);
        System.out.println(min);
    }

    private static void dfs(int xs, int ys, int xt, int yt, int[][] a, int[][] b, int curpath, boolean[][] visited, int[][] path) {
        if (xs < 0 || xs >= visited.length || ys < 0 || ys >= visited[0].length){
            return;
        }
        if (curpath > path[xs][ys]){
            return;
        }else {
            path[xs][ys] = Math.min(curpath, path[xs][ys]);
        }
        if (xs == xt && ys == yt){
            min = Math.min(min, curpath);
            return;
        }
        int aij = a[xs][ys];
        int bij = b[xs][ys];
        int ab = aij + bij;
        if ( curpath >= 0){
            int k =curpath / ab;
            if (curpath < k * ab + aij && curpath >= k * ab){
                visited[xs][ys] = true;
                dfs(xs + 1, ys, xt, yt, a, b, curpath + 1, visited, path);
                dfs(xs - 1, ys, xt, yt, a, b, curpath + 1, visited, path);
                visited[xs][ys] = false;
            }

        }
        if (curpath >= aij){
            int k = (curpath - aij) / ab;
            if ((k + 1) * ab > curpath && curpath >= k *ab + aij){
                visited[xs][ys] = true;
                dfs(xs, ys + 1, xt, yt, a, b, curpath + 1, visited, path);
                dfs(xs, ys - 1, xt, yt, a, b, curpath + 1, visited, path);
                visited[xs][ys] = false;
            }
        }
    }
}
