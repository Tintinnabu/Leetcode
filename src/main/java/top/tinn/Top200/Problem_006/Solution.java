package top.tinn.Top200.Problem_006;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solutionb
 * @Description
 * @Author Tinn
 * @Date 2020/4/21 15:18
 */
public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = 0; i < numRows; i++){
            int sumInterval = (numRows - 1) * 2;
            if (i == 0 || i == numRows - 1){
                for (int j = i; j < s.length(); j+=sumInterval)
                    sb.append(chars[j]);
            }else {
                int[] interval = new int[2];
                interval[0] = 2 * i;
                interval[1] = sumInterval - interval[0];
                int mark = -1;
                for (int j = i; j < s.length(); j+= mark < 0 ? interval[0] : interval[1]){
                    sb.append(chars[j]);
                    mark *= -1;
                }
            }
        }
        return sb.toString();
    }

    @Test
    public void test(){
        String s = "A";
        int numRows = 1;
        System.out.println(convert(s, numRows));
    }
}
