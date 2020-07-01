package top.tinn.Over200.Problem_451;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public String frequencySort(String s) {
        //桶排序
        int len = s.length();
        Map<Integer, Set<Character>> map = new TreeMap<>();
        int[] cnt = new int[128];
        for (char c : s.toCharArray()){
            cnt[c]++;
        }
        for (int i = 0; i < 128; i++){
            if (cnt[i] > 0){
                if (map.get(cnt[i]) == null){
                    Set<Character> set = new HashSet<>();
                    map.put(cnt[i], set);
                }
                map.get(cnt[i]).add((char)i);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int key : map.keySet()){
            for (char c : map.get(key)){
                int temp = key;
                while (temp > 0){
                    sb.append(c);
                    temp--;
                }
            }
        }
        return sb.reverse().toString();

    }
    @Test
    public void test(){
        String s = "tree";
        System.out.println(frequencySort(s));
    }

}
