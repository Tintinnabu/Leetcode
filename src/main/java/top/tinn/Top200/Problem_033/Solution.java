package top.tinn.Top200.Problem_033;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * 30. 串联所有单词的子串
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 * @Author Tinn
 * @Date 2020/4/21 20:32
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < words.length; i++){
            ret = helper(s, words, i, words[0].length(), ret);
        }
        return ret;
    }

    public List<Integer> helper(String s, String[] words, int index, int distance,List<Integer> preRet) {
        List<Integer> ret = new ArrayList<>();
        if (index == 0 || preRet.size() != 0){
            int i = 0;
            while (i < s.length()){
                i = s.indexOf(words[index], i);
                if (i >= 0 && i < s.length()){
                    ret.add(i);
                    i += distance;
                }else
                    break;
            }
            if (index == 0) return ret;
        }
        else return preRet;
        //综合
        int i = 0, j = 0;
        List<Integer> result = new ArrayList<>();
        while (i < preRet.size() && j < ret.size()){
            int t1 = preRet.get(i);
            int t2 = ret.get(j);
            if (t1 < t2){
                if (t1 + distance == t2){
                    result.add(t1);
                }
                i++;
            }else{
                if (t2 + distance == t1){
                    result.add(t2);
                }
                j++;
            }
        }
        return result;
    }


    @Test
    public void test(){
        String s = "barfoothefoobarman";
        String[] words = {"foo","bar"};
        //System.out.println(findSubstring(s, words));
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        //System.out.println(findSubstring(s2, words2));
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar","foo","the"};
        System.out.println(findSubstring(s3, words3));
    }
}
