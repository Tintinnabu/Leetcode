package top.tinn.NowCoder.Ctrip_0908.Problem_03;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/8 19:48
 */
public class Main {
    private static int max;
    private static int[] dx = {0, -1, 1, 0};
    private static int[] dy = {1, 0, 0, -1};
    private static int M;
    private static int N;
    private static int L;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        M = scanner.nextInt();
        N = scanner.nextInt();
        int E0 = scanner.nextInt();
        int X = scanner.nextInt();
        L = scanner.nextInt();
        int[][] array = new int[M][N];
        max = Integer.MAX_VALUE;
        for (int i = 0; i < M; i++){
            for (int j = 0; j < N; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        dfs(array, 0, 0, E0, X, 0, 0);
        dfs(array, 0, 0, E0, X, 0, 2);
        System.out.println(max);
    }

    private static void dfs(int[][] array, int i, int j, int E0, int X, int cur, int target) {
        if (i == array.length - 1 && j == array[0].length - 1){
            max = Math.min(max, cur);
            return;
        }
        int preI = i, preJ = j;
        int newI = preI + dx[target];
        int newJ = preJ + dy[target];
        if (newI < 0 || newI >= M || newJ < 0 || newJ >= N){
            return;
        }
        if (array[newI][newJ] > E0 + X * L){
            return;
        }
        //一直前进，只有在没油或者碰到边界才会停下
        while (newI >= 0 && newI < M && newJ >= 0 && newJ < N
        && array[newI][newJ] <= E0){
            cur++;
            E0 -= array[newI][newJ];
            preI = newI;
            preJ = newJ;
            newI += dx[target];
            newJ += dy[target];
        }
        //如果是碰到边界
        if (newI < 0 || newI >= M || newJ < 0 || newJ >= N){
            //变相
            for (int t = 0; t < 4; t++){
                if (t != target && t + target != 3){
                    dfs(array, preI, preJ, E0, X, cur, t);
                }
            }
        }
        //如果是没油了
        if (E0 < array[newI][newJ]){
            //油够加，变相
            //油不够加，变相
            for (int t = 0; t < 4; t++){
                if (t != target && t + target != 3){
                    dfs(array, preI, preJ, E0, X, cur, t);
                }
            }
            //油够加，加油
            if (X * L + E0 >= array[newI][newJ]){
                while (E0 < array[newI][newJ] && X > 0){
                    E0 += L;
                    X--;
                }
                dfs(array, preI, preJ, E0, X, cur, target);
            }

        }
    }
}
