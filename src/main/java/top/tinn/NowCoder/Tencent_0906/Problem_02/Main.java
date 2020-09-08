package top.tinn.NowCoder.Tencent_0906.Problem_02;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/6 20:20
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<Set<Integer>> total = new ArrayList<>(m);
        for (int i = 0; i < m; i++){
            int num = scanner.nextInt();
            Set<Integer> group = new HashSet<>();
            for (int j = 0; j < num; j++){
                group.add(scanner.nextInt());
            }
            total.add(group);
        }
        Set<Integer> ans = new HashSet<>();
        ans.add(0);
        boolean[] used = new boolean[m];
        for (int i = 0; i < m; i++){
            Set<Integer> group = total.get(i);
            if (!used[i]){
                for (Integer a : ans){
                    if (group.contains(a)){
                        used[i] = true;
                        ans.addAll(group);
                        i = -1;
                        break;
                    }
                }
            }
        }
        System.out.println(ans.size());
    }
}
