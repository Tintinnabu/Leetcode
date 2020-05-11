package top.tinn.Over200.Problem_438;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * 给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 *
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 * 不考虑答案输出的顺序。
 * 示例 1:
 *
 * 输入:
 * s: "cbaebabacd" p: "abc"
 *
 * 输出:
 * [0, 6]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 *  示例 2:
 *
 * 输入:
 * s: "abab" p: "ab"
 *
 * 输出:
 * [0, 1, 2]
 *
 * 解释:
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-all-anagrams-in-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int size=s.length()-p.length()+1;
        if(size<1) return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        String key=getKey(p);
        for(int j=0;j<size;j++){
            if (getKey(s.substring(j,j+p.length())).equals(key)) result.add(j);
        }
        return result;
    }

    private String getKey(String p){
        int[] count=new int[26];
        Arrays.fill(count,0);
        for(char c:p.toCharArray()){
            count[c-'a']++;
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i=0;i<26;i++){
            stringBuilder.append('#');
            stringBuilder.append(count[i]);
        }
        return stringBuilder.toString();
    }

    public List<Integer> findAnagrams2(String s, String p) {
        // 用于返回字母异位词的起始索引
        List<Integer> result=new ArrayList<>();
        // 用 map 存储目标值中各个单词出现的次数
        Map<Character,Integer> map=new HashMap<>();
        for(char c:p.toCharArray()) map.put(c,map.getOrDefault(c,0)+1);
        // 用另外一个 map 存储滑动窗口中有效字符出现的次数
        Map<Character,Integer> window=new HashMap<>();
        int left = 0; // 左指针
        int right = 0; // 右指针
        int valid = p.length(); // 只有当 valid == 0 时，才说明 window 中包含了目标子串
        while (right<s.length()){
            // 如果目标子串中包含了该字符，才存入 window 中
            if(map.containsKey(s.charAt(right))){
                window.put(s.charAt(right),window.getOrDefault(s.charAt(right),0)+1);
                // 只有当 window 中该有效字符数量不大于map中该字符数量，才能算一次有效包含
                if(window.get(s.charAt(right))<=map.get(s.charAt(right))) valid--;
            }
            while (valid==0){
                // 如果 window 符合要求，即两个 map 存储的有效字符相同，就可以移动左指针了
                if(right-left+1==p.length()) result.add(left);
                // 但是只有二个map存储的数据完全相同，才可以记录当前的起始索引，也就是left指针所在位置
                if (map.containsKey(s.charAt(left))){
                    window.put(s.charAt(left),window.get(s.charAt(left))-1);
                    if (window.get(s.charAt(left))<map.get(s.charAt(left))) valid++;
                }
                // 如果左指针指的是有效字符,需要更改 window 中的 key 对应的 value
                // 如果 有效字符对应的数量比目标子串少，说明无法匹配了
                left++;
            }
            right++;
        }
        return result;
    }

    @Test
    public void test(){
        String s="cbaebabacd";
        String p="ab";
        System.out.println(findAnagrams2(s,p));
    }
}
