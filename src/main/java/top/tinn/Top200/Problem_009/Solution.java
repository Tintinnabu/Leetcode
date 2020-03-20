package top.tinn.Top200.Problem_009;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        List<Integer> list=new ArrayList<>();
        int c=0;
        int save=x;
        int y=0;
        while(x>0){
            c=x%10;
            x/=10;
            y=10*y+c;
        }
        return y==save;
    }


    @Test
    public void test(){
        System.out.println(isPalindrome(123));
    }
}
