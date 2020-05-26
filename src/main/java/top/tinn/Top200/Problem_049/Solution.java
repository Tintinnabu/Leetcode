package top.tinn.Top200.Problem_049;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Integer, List<String>> hash = new HashMap<>();
        //每个字母对应一个质数
        int[] prime = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };
        for (int i = 0; i < strs.length; i++) {
            int key = 1;
            //累乘得到 key
            for (int j = 0; j < strs[i].length(); j++) {
                key *= prime[strs[i].charAt(j) - 'a'];
            }
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
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
