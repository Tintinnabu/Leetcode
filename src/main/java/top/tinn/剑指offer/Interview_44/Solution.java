package top.tinn.剑指offer.Interview_44;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 21:07
 */
public class Solution {
    public int findNthDigit(int n) {
        if (n < 10) return n;
        return helper(n);
    }

    private int helper(int i) {
        long basis = 9;
        int digits = 1;
        while (i > basis * digits){
            i -= basis * digits;
            basis *= 10;
            digits++;
        }
        int distance = i;
        basis /= 9;
        int num =(int) (basis + (distance % digits == 0 ? -1 : 0) + distance / digits);
        int nth = (distance - 1) % digits;
        for (i = 0; i < nth; i++){
            num %= basis;
            basis /= 10;
        }
        return num / (int)basis;
    }

    @Test
    public void test(){
        System.out.println(findNthDigit(1000000000));
        System.out.println((Integer.MAX_VALUE));
    }
}
