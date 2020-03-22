package top.tinn.Top200.Problem_168;

import org.junit.jupiter.api.Test;

public class Solution {
    public String convertToTitle(int n) {
        StringBuilder sb=new StringBuilder();
        while (n>0){
            n--;
            int temp=n%26;
            n/=26;
            sb.insert(0,(char)(temp+'A'));
        }
        return sb.toString();
    }


    @Test
    public void test(){
        System.out.println(convertToTitle(28));
    }
}
