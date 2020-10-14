package top.tinn.NowCoder.Xingye_1012;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/10/12 21:07
 */
public class Solution {
    /**
     * 将输入的十进制数字转换为对应的二进制字符串和十六进制字符串
     * @param number string字符串 十进制数字字符串
     * @return string字符串
     */
    static int THRESHOLD = (2 << 14);
    static char[] MAP = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public String changeFormatNumber (String number) {
        // write code here
        if (number == null || number.length() == 0){
            return "";
        }
        //非法输入

        //越界输入
        if (number.charAt(0) == '-'){
            //补码
            String num = number.substring(1);
            if (num.length() >= 6){
                return "NODATA";
            }
            if (!isInt(num)){
                return "NODATA";
            }
            int numInt = Integer.parseInt(num);
            if (numInt > THRESHOLD){
                return "NODATA";
            }
            int[] binary = binary(numInt);
            bm(binary);
            char[] hex = hex(binary);
            StringBuilder sb = new StringBuilder();
            for (int b : binary){
                sb.append(b);
            }
            sb.append(",");
            for (char h : hex){
                sb.append(h);
            }
            return sb.toString();
        }else {
            String num = number;
            if (num.length() >= 6){
                return "NODATA";
            }
            if (!isInt(num)){
                return "NODATA";
            }
            int numInt = Integer.parseInt(num);
            if (numInt >= THRESHOLD){
                return "NODATA";
            }
            int[] binary = binary(numInt);
            char[] hex = hex(binary);
            StringBuilder sb = new StringBuilder();
            for (int b : binary){
                sb.append(b);
            }
            sb.append(",");
            for (char h : hex){
                sb.append(h);
            }
            return sb.toString();
        }
    }

    private boolean isInt(String num) {
        int ans = 0;
        for (char c : num.toCharArray()){
            if (!Character.isDigit(c)){
                return false;
            }
        }
        return true;
    }

    private void bm(int[] binary) {
        for (int i = 0; i < 16; i++){
            binary[i] = 1 - binary[i];
        }
        int i = 15;
        int c = 1;
        while (i >= 0 && c > 0){
            if (binary[i] == 0){
                binary[i] = 1;
                c = 0;
            }else {
                binary[i] = 0;
            }
            i--;
        }
    }

    private char[] hex(int[] binary) {
        char[] ans = new char[4];
        for (int i = 0; i < 16; i += 4){
            int temp = 0;
            for (int start = i; start < i +4; start++){
                temp = 2 * temp + binary[start];
            }
            ans[i >> 2] = MAP[temp];
        }
        return ans;
    }

    private int[] binary(int numInt) {
        int[] ans = new int[16];
        int point = 0;
        while (numInt != 0){
            ans[15 - point] = numInt % 2;
            numInt >>= 1;
            point++;
        }
        return ans;
    }

    @Test
    public void test(){
        System.out.println(changeFormatNumber("A"));
        System.out.println(changeFormatNumber("15"));
        System.out.println(changeFormatNumber("32767"));
        System.out.println(changeFormatNumber("-1"));
        System.out.println(changeFormatNumber("-32768"));
        System.out.println(changeFormatNumber("-32769"));
        System.out.println(changeFormatNumber("32768"));
    }
}
