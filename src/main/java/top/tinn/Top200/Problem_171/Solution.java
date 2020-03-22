package top.tinn.Top200.Problem_171;

import org.junit.jupiter.api.Test;

public class Solution {
    public int titleToNumber(String s) {
        char[] c=s.toCharArray();
        int i=0,res=0;
        while (i<c.length){
            int temp=c[i]-'A'+1;
            res=26*res+temp;
            i++;
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(titleToNumber("ZY"));
    }
}
