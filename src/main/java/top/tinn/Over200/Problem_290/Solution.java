package top.tinn.Over200.Problem_290;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] strings = str.split(" ");
        if (pattern.length() != strings.length){
            return false;
        }
        String[] map = new String[26];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++){
            int index = pattern.charAt(i) - 'a';
            if (map[index] == null){
                if (set.contains(strings[i])){
                    return false;
                }
                map[index] = strings[i];
                set.add(strings[i]);
            }else if (!map[index].equals(strings[i])){
                return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        String pattern = "deadbeef";
        String str = "d e a d b e e f";
        System.out.println(wordPattern(pattern, str));
    }
}
