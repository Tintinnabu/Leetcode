package top.tinn.Top200.Problem_187;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/21 15:01
 */
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> result = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++){
            String temp = s.substring(i, i + 10);
            if (set.contains(temp)) result.add(temp);
            else set.add(temp);
        }
        return new ArrayList<>(result);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        int len = s.length();
        if (len == 0 || len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        char map[] = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        int key = 0;
        char[] array = s.toCharArray();
        //第一组单独初始化出来
        for (int i = 0; i < 10; i++) {
            key = key << 2 | map[array[i] - 'A'];
        }
        set.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 2;
            key |= map[array[i] - 'A'];
            key &= 0xfffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }
        }
        return new ArrayList<>(res);
    }

    @Test
    public void test(){
        String s = "AAAAAAAAAAA";
        System.out.println(findRepeatedDnaSequences(s));
    }
}
