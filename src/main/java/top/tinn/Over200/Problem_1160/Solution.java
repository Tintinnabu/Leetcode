package top.tinn.Over200.Problem_1160;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] map=new int[26];
        for (char c:chars.toCharArray()) map[c-'a']++;
        return backtrack(words,map,0,0);
    }

    private int backtrack(String[] words, int[] map, int num,int wordIdx) {
        if (wordIdx==words.length) return num;
        int[] newMap= Arrays.copyOf(map,26);
        boolean flag=true;
        for (char c:words[wordIdx].toCharArray()) {
            if (newMap[c - 'a']-- < 1) {
                flag=false;
                break;
            }
        }
        if (flag) return backtrack(words,map,num+words[wordIdx].length(),wordIdx+1);
        return backtrack(words,map,num,wordIdx+1);
    }

    @Test
    public void test(){
        String[] words={"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(countCharacters(words,chars));
    }
}
