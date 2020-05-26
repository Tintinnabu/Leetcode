package top.tinn.Top200.Problem_022;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/25 22:36
 */
public class Solution {
    private List<String> ret = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return ret;
    }

    private void dfs(String str, int open, int close, int n) {
        if (close == n){
            ret.add(str);
        }
        if (open < n){
            dfs(str + "(", open + 1, close, n);
        }
        if (close < open){
            dfs(str + ")", open, close + 1, n);
        }
    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(3));
    }
}
