package top.tinn.NowCoder.Shein_0929.Problem_01;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/29 10:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        Map<Character, Integer> count1 = new HashMap<>();
        Map<Character, Integer> count2 = new HashMap<>();
        for (char c : str1.toCharArray()){
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }
        for (char c : str2.toCharArray()){
            count2.put(c, count2.getOrDefault(c, 0) + 1);
        }
        boolean flag = false;
        for (char key : count2.keySet()){
            if (count1.get(key) == null || count1.get(key) < count2.get(key)){
                flag = true;
                break;
            }
        }
        int groups = count2.size();
        if (flag){
            System.out.println(0);
        }else {
            //contains
            Map<Character, Integer> cur = new HashMap<>();
            int l = 0, r = l;
            int curGroups = 0;
            int min = str1.length();
            while (r < str1.length()){
                while (r < str1.length() && curGroups < groups){
                    char c = str1.charAt(r);
                    if (count2.containsKey(c)){
                        cur.put(c, cur.getOrDefault(c, 0) + 1);
                        if (cur.get(c).equals(count2.get(c))){
                            curGroups++;
                        }
                    }
                    r++;
                }
                if (curGroups == groups){
                    while (l < r && curGroups == groups){
                        char c = str1.charAt(l);
                        if (count2.containsKey(c)){
                            cur.put(c, cur.getOrDefault(c, 0) - 1);
                            if (cur.get(c) < count2.get(c)){
                                curGroups--;
                            }
                        }
                        l++;
                    }
                    min = Math.min(min, r - l + 1);
                }
            }
            System.out.println(min);
        }
    }
}
