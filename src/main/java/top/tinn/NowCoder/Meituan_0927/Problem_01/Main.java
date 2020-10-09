package top.tinn.NowCoder.Meituan_0927.Problem_01;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/27 10:04
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();
        int f = scanner.nextInt();
        int g = scanner.nextInt();
        int[][] node = {new int[]{a, e}, new int[]{b, f}, new int[]{c, g}};
        Arrays.sort(node, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o2[0] - o1[0];
                }
                return o2[1] - o1[1];
            }
        });
        int i = 0;
        long count = 0;
        while (d > 0 && i < 3) {
            if (node[i][0] <= d) {
                d -= node[i][0];
                count += node[i][0] * node[i][1];
                i++;
            } else {
                count += d * node[i][1];
                break;
            }
        }
        System.out.println(count);
    }
}
