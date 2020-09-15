package top.tinn.NowCoder.Ctrip_0908.Problem_02;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/8 19:33
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] path = scanner.nextLine().split(" ");
        boolean[] used = new boolean[128];
        List<String> ans = new ArrayList<>();
        dfs(ans, 0, new StringBuilder(), path, false, used);
        for (String str : ans){
            System.out.println(str);
        }
    }

    private static void dfs(List<String> ans, int i, StringBuilder sb, String[] path,
                            boolean isLoopDependency, boolean[] used) {
        if (i == path.length){
            String temp = sb.toString();
            if (isLoopDependency){
                temp += "--circular dependency";
            }
            ans.add(temp);
            return;
        }
        for (char c : path[i].toCharArray()){
            if (used[c]){
                sb.append(c);
                dfs(ans, i + 1, sb, path, true, used);
                sb.deleteCharAt(sb.length() - 1);
            }else {
                used[c] = true;
                sb.append(c);
                dfs(ans, i + 1, sb, path, isLoopDependency, used);
                sb.deleteCharAt(sb.length() - 1);
                used[c] = false;
            }
        }
    }
}
