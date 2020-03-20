package top.tinn.Top200.Problem_067;

import org.junit.jupiter.api.Test;

/**
 * 67. 二进制求和
 *
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 *
 * 输入为非空字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 *
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 *
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Solution {
    public String addBinary(String a, String b) {
        char[] charA=a.toCharArray();
        char[] charB=b.toCharArray();
        int lenA=a.length();
        int lenB=b.length();
        StringBuilder sb=new StringBuilder();
        int c=0;
        for (int i=1;i<=Math.max(lenA,lenB);i++){
            int add1=0,add2=0;
            if (lenA-i>=0) add1= charA[lenA-i]-'0';
            if (lenB-i>=0) add2=charB[lenB-i]-'0';
            int add=add1+add2+c;
            sb.insert(0,add%2);
            c=add/2;
        }
        if (c>0) sb.insert(0,1);
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(addBinary("",""));
    }
}
