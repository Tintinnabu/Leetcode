package top.tinn.Probloem_049;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] strChar=str.toCharArray();
            Arrays.sort(strChar);
            String key=new String(strChar);
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }


    public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>();
        int[] count=new int[26];
        for(String str:strs){
            Arrays.fill(count,0);
            for(char c:str.toCharArray()) count[c-'a']++;
            StringBuilder stringBuilder=new StringBuilder();
            for(int i=0;i<26;i++){
                stringBuilder.append("#");
                stringBuilder.append(count[i]);
            }
            String key=stringBuilder.toString();
            if(!map.containsKey(key)) map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
    @Test
    public void test(){
        String[] strs=new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }
}
