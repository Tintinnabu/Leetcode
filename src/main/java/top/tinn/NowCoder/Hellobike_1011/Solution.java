package top.tinn.NowCoder.Hellobike_1011;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Tinn
 * @Date: 2020/10/11 17:16
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 找到输入字符串中连续不含重复字符的最长子串。如果有多个相同长度的，只需取第一个。
     * @param str string字符串 非空字符串
     * @return string字符串
     */
    public String findMaxSubstr (String str) {
        // write code here
        Map<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int l = 0, r = l;
        int start = 0;
        while (r < str.length()){
            while (r < str.length() && map.getOrDefault(str.charAt(r), 0) == 0){
                map.put(str.charAt(r), map.getOrDefault(str.charAt(r), 0) + 1);
                r++;
            }
            int len = r - l;
            if (len > maxLen){
                maxLen = len;
                start = l;
            }
            if (r < str.length()){
                char repeat = str.charAt(r);
                while (l < r && map.get(repeat) > 0){
                    map.put(str.charAt(l), map.get(str.charAt(l)) - 1);
                    l++;
                }
            }
        }
        return str.substring(start, start + maxLen);
    }

    @Test
    public void test(){
        System.out.println(findMaxSubstr("abcdbcdcbabcdefggcwa"));
        System.out.println(findMaxSubstr("The Linux kernel is an open source software project of fairly large scope."));
    }
}
