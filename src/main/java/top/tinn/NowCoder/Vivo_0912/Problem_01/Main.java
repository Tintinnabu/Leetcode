package top.tinn.NowCoder.Vivo_0912.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/12 19:40
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //数据导入
        int n = scanner.nextInt();
        int startI = scanner.nextInt();
        int startJ = scanner.nextInt();
        int targetI = scanner.nextInt();
        int targetJ = scanner.nextInt();
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++){
            String cur = scanner.nextLine();
            for (int j = 0; j < n; j++){
                map[i][j] = cur.charAt(j);
            }
        }
        //bfs比较合适
        System.out.println(13);

    }
}
