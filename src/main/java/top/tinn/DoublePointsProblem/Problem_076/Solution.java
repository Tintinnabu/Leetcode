package top.tinn.DoublePointsProblem.Problem_076;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 *
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 *
 * 示例：
 *
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 * 说明：
 *
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public String minWindow(String s, String t) {
        int l=0,r=0,start=0,match=0;
        int minLen=Integer.MAX_VALUE;
        Map<Character,Integer> tMap=new HashMap<>();
        Map<Character,Integer> windowMap=new HashMap<>();
        for (char c:t.toCharArray()) tMap.put(c,tMap.getOrDefault(c,0)+1);
        while (r<s.length()){
            char c=s.charAt(r);
            if (tMap.containsKey(c)){
                windowMap.put(c,windowMap.getOrDefault(c,0)+1);
                if (windowMap.get(c).equals(tMap.get(c))) match++;
            }
            r++;
            while (match==tMap.size()){
                if(r-l<minLen){
                    start=l;
                    minLen=r-l;
                }
                char c2=s.charAt(l);
                if (tMap.containsKey(c2)){
                    windowMap.put(c2,windowMap.getOrDefault(c2,0)-1);
                    if (windowMap.getOrDefault(c2,0)<tMap.get(c2)) match--;
                }
                l++;
            }
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }

    @Test
    public void test(){
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
