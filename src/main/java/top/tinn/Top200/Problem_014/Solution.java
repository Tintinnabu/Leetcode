package top.tinn.Top200.Problem_014;

import org.junit.jupiter.api.Test;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length<1) return "";
        int i=0;
        boolean flag=true;
        for (;i<strs[0].length();i++){
            char matchChar=strs[0].charAt(i);
            for (int j=1;j<strs.length;j++){
                if (i>=strs[j].length()||strs[j].charAt(i)!=matchChar) {
                    flag=false;
                    break;
                }
            }
            if (!flag) break;
        }
        return strs[0].substring(0,i);
    }

    @Test
    public void test(){
        System.out.println(longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}
