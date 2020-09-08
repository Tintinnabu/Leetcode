package top.tinn.NowCoder.Bilibili_0904.Problem_03;

import org.junit.jupiter.api.Test;

/**
 * @Author: Tinn
 * @Date: 2020/9/4 19:37
 */
public class Solution {
    public int GetFragment (String str) {
        // write code here
        if (str == null || str.length() == 0){
            return 0;
        }
        int numOfPieces = 1;
        char pre = str.charAt(0);
        for (int i = 1; i < str.length(); i++){
            if (str.charAt(i) != pre){
                numOfPieces++;
                pre = str.charAt(i);
            }
        }
        return str.length() / numOfPieces;
    }

    @Test
    public void test(){
        System.out.println(GetFragment("aaabbaaac"));
    }
}
