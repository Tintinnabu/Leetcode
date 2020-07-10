package top.tinn.Contest.Contest_Single_190.Problem_1;

import org.junit.jupiter.api.Test;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 10:14
 */
public class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int i = 1;
        String[] words = sentence.split(" ");
        for (String word : words){
            if (word.startsWith(searchWord)){
                return i;
            }
            i++;
        }
        return -1;
    }

    @Test
    public void test(){
        System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
    }
}
