package top.tinn.Top200.Problem_066;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[] plusOne(int[] digits) {
        int c=0,i=digits.length-1;
        for (;i>=0;i--){
            int temp=digits[i]+c+1;
            c=temp/10;
            digits[i]=temp%10;
            if (c==0) break;
            c--;
        }
        if (c==0&&i<0){
            int[] ret=new int[digits.length+1];
            System.arraycopy(digits,0,ret,1,digits.length);
            ret[0]=1;
            return ret;
        }
        return digits;
    }

    @Test
    public void test(){
        int[] digits={0};
        System.out.println(Arrays.toString(plusOne(digits)));
    }
}
