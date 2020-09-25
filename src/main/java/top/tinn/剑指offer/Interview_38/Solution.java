package top.tinn.剑指offer.Interview_38;


import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 15:55
 */
public class Solution {
    public String[] permutation(String s) {
        List<String> list = new ArrayList<>();
        char[] c = s.toCharArray();
        backtrack(c, 0, list);
        return list.toArray(new String[0]);
    }

    private void backtrack(char[] c, int index, List<String> list) {
        if (index == c.length - 1){
            list.add(String.valueOf(c));
            return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < c.length; i++){
            if (set.contains(c[i])) continue;
            set.add(c[i]);
            swap(c, i, index);
            backtrack(c, index + 1, list);
            swap(c, i, index);
        }
    }

    private void swap(char[] c, int i, int index) {
        char temp = c[i];
        c[i] = c[index];
        c[index] = temp;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(permutation2("aba")));;
    }

    public String[] permutation2(String s) {
        char[] schar = s.toCharArray();
        Arrays.sort(schar);
        List<String> ans = new ArrayList<>();
        dfs(schar, new boolean[schar.length], new StringBuilder(), ans);
        return ans.stream().toArray(String[]::new);
    }

    private void dfs(char[] schar, boolean[] visited, StringBuilder sb, List<String> ans){
        if (sb.length() == schar.length){
            ans.add(sb.toString());
            return;
        }
        for (int j = 0; j < schar.length; j++){
            if (!visited[j]){
                if (j == 0 || (!visited[j - 1] && schar[j] == schar[j - 1])
                || schar[j] != schar[j - 1]){
                    visited[j] = true;
                    sb.append(schar[j]);
                    dfs(schar, visited, sb, ans);
                    visited[j] = false;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
