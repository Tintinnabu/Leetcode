package top.tinn.Contest.Contest_Single_201.Problem_02;

import org.junit.jupiter.api.Test;

public class Solution {
    public char findKthBit(int n, int k) {
        StringBuilder sb = new StringBuilder("0");
        for (int i = 2; i <= n; i++){
            StringBuilder temp = reverseAndInvert(sb);
            sb.append('1');
            sb.append(temp);
        }
        return sb.charAt(k - 1);
    }

    private StringBuilder reverseAndInvert(StringBuilder sb) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < sb.length(); i++){
            if (sb.charAt(i) == '0'){
                res.append('1');
            }else {
                res.append('0');
            }
        }
        return res.reverse();
    }

    @Test
    public void test(){
        System.out.println(findKthBit(4, 11));;
    }
}
