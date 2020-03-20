package top.tinn.Top200.Problem_058;

import org.junit.jupiter.api.Test;

public class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        char[] c=s.toCharArray();
        int i=c.length-1;
        while (i>=0&&c[i]==' ') i--;
        while (i>=0){
            if (c[i]!=' ') count++;
            else return count;
            i--;
        }
        return count;
    }

    @Test
    public void test(){
        System.out.println(lengthOfLastWord( "Hello World         "));
    }
}
