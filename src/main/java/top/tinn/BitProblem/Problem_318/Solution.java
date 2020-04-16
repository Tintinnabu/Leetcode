package top.tinn.BitProblem.Problem_318;

/**
 * @ClassName Solutio
 * @Description
 * 给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 示例 1:
 *
 * 输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
 * 输出: 16
 * 解释: 这两个单词为 "abcw", "xtfn"。
 * 示例 2:
 *
 * 输入: ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 * 示例 3:
 *
 * 输入: ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-product-of-word-lengths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Tinn
 * @Date 2020/4/15 16:09
 */
public class Solution {
    public int maxProduct(String[] words) {
        int size = words.length;
        int maxVal = 0;
        int[] masks = new int[size];
        int[] lens = new int[size];
        for (int i = 0; i < size; i++){
            int mask = 0;
            for (char c : words[i].toCharArray()){
                mask |= 1 << ( c - 'a');
            }
            masks[i] = mask;
            lens[i] = words[i].length();
        }
        for (int i = 0; i < size; i++){
            for (int j = i + 1; j < size ;j++){
                if ((masks[i] & masks[j]) == 0)
                    maxVal = Math.max(maxVal, lens[i] * lens[j]);
            }
        }
        return maxVal;
    }
}
