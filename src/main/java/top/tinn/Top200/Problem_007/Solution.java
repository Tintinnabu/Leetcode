package top.tinn.Top200.Problem_007;

import org.junit.jupiter.api.Test;

public class Solution {
    public int reverse(int x) {
        boolean sign=true;
        if (x<0) sign=false;
        x=x>=0?x:-x;
        while (x>0&&x%10==0) x/=10;
        int c=0;
        double newX=0;
        while (x>0){
            c=x%10;
            x/=10;
            newX=10*newX+c;
        }
        if (sign&&newX>Integer.MAX_VALUE) newX=0;
        if (!sign&&-newX<Integer.MIN_VALUE) newX=0;
        int res=(int)newX;
        return sign?res:-res;
    }

    @Test
    public void test(){
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
        System.out.println(reverse(120));
        System.out.println(reverse(1534236469));
    }
}
