package top.tinn.NowCoder.Zhaohang_0921.Problem_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/21 19:28
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int groups = scanner.nextInt();
        while (groups > 0){
            int len = scanner.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            int zfx = 0;
            int jx = 0;
            while (len > 0){
                int cur = scanner.nextInt();
                map.put(cur, map.getOrDefault(cur, 0) + 1);
                if (map.get(cur) >= 4){
                    zfx++;
                    map.put(cur, map.get(cur) - 4);
                }
                len--;
            }
            //process jx
            for (Integer value : map.values()){
                if (value != null && value > 1){
                    jx++;
                }
            }
            jx >>= 1;
            System.out.println(zfx + " " + jx);
            groups--;
        }
    }
}
