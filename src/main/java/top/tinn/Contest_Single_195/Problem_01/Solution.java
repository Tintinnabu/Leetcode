package top.tinn.Contest_Single_195.Problem_01;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> set = new HashSet<>();
        int[] start = {0, 0};
        set.add("0,0");
        for (int i = 0; i < path.length(); i++){
            char c = path.charAt(i);
            if (c == 'N'){
                start[1]++;
            }else if (c == 'S'){
                start[1]--;
            }else if (c == 'W'){
                start[0]--;
            }else {
                start[0]++;
            }
            String str = start[0] + "," + start[1];
            if (set.contains(str)){
                return true;
            }
            set.add(str);
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isPathCrossing("NESWW"));
        System.out.println(isPathCrossing("NES"));
    }
}
