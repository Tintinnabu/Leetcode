package top.tinn.NowCoder.Youzan_1011.Problem_02;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/10/11 19:27
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param digits int整型ArrayList
     * @return string字符串
     */
    String ret;
    public String largestMultipleOfThree (ArrayList<Integer> digits) {
        // write code here
        ret = null;
        List<String> ans = new ArrayList<>();
        dfs(digits, 0, 0, ans);
        if (ret == null){
            return "";
        }else if (ret.charAt(0) == '0' && ret.charAt(ret.length() - 1) == '0'){
            return "0";
        }
        return ret;
    }

    private void dfs(ArrayList<Integer> digits, int index, int curSum, List<String> ans) {
        if (index == digits.size()){
            if (curSum % 3 == 0){
                List<String> ans2 = new ArrayList<>(ans);
                Collections.sort(ans2, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        String temp1 = o1 + o2;
                        String temp2 = o2 + o1;
                        return temp2.compareTo(temp1);
                    }
                });
               StringBuilder sb = new StringBuilder();
               for (String s : ans2){
                   sb.append(s);
               }
               String str = sb.toString();
                if (ret == null ||ret.compareTo(str) < 0){
                    ret = str;
                }
            }
        }
        for (int i = index; i < digits.size(); i++){
            int cur = digits.get(i);
            ans.add(String.valueOf(cur));
            dfs(digits, i + 1, curSum + cur, ans);
            ans.remove(ans.size() - 1);
        }
    }

    @Test
    public void test(){
        ArrayList<Integer> digits5= new ArrayList<>(Arrays.asList(8,1,9,0,0,3));
        System.out.println(largestMultipleOfThree(digits5));
    }
}
