package top.tinn.NowCoder.Dianxinyun_1015;

/**
 * @Author: Tinn
 * @Date: 2020/10/15 18:36
 */
public class Main2 {
    public static void main(String[] args) {
        for (int a = 0; a <= 9; a++){
            for (int b = 0; b <= 9; b++){
                for (int c = 0; c <=9; c++){
                    for (int d = 0; d <= 9; d++){
                        if (sum(a, b, c, d) == 8888){
                            System.out.printf("%d %d %d %d\n", a, b, c, d);
                        }
                    }
                }
            }
        }
    }

    private static int sum(int a, int b, int c, int d) {
        return (a + b) * 1000 + (b + c) * 100 + (c + d) * 10 + (d + a);
    }
}
