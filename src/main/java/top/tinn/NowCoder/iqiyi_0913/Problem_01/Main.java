package top.tinn.NowCoder.iqiyi_0913.Problem_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/13 15:26
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int i = 0; i < str.length(); i++){
            if (!map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), i);
            }else {
                ans = Math.max(ans, i - map.get(str.charAt(i)));
                map.put(str.charAt(i), i);
            }
        }
        System.out.println(ans);
    }
}
