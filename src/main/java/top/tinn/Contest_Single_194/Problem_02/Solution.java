package top.tinn.Contest_Single_194.Problem_02;

import java.util.*;

public class Solution {
    public String[] getFolderNames(String[] names) {
        String[] res = new String[names.length];
        Map<String, Integer> cnt = new HashMap<>();
        for (int i = 0; i < names.length; i++){
            String name = names[i];
            if (cnt.containsKey(name)){
                res[i] = name + "(" + cnt.get(name) + ")";
                while (cnt.containsKey(res[i])){
                    cnt.put(name, cnt.getOrDefault(name, 0) + 1);
                    res[i] = name + "(" + cnt.get(name) + ")";
                }
            }else {
                res[i] = name;
            }
            cnt.put(res[i], cnt.getOrDefault(res[i], 0) + 1);
        }
        return res;
    }

}
