package top.tinn.Top200.Problem_068;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 68. 文本左右对齐
 *
 * 给定一个单词数组和一个长度 maxWidth，重新排版单词，使其成为每行恰好有 maxWidth 个字符，且左右两端对齐的文本。
 *
 * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格 ' ' 填充，使得每行恰好有 maxWidth 个字符。
 *
 * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
 *
 * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
 *
 * 说明:
 *
 * 单词是指由非空格字符组成的字符序列。
 * 每个单词的长度大于 0，小于等于 maxWidth。
 * 输入单词数组 words 至少包含一个单词。
 * 示例:
 *
 * 输入:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * 输出:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * 示例 2:
 *
 * 输入:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * 输出:
 * [
 *   "What   must   be",
 *   "acknowledgment  ",
 *   "shall be        "
 * ]
 * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
 *      因为最后一行应为左对齐，而不是左右两端对齐。
 *      第二行同样为左对齐，这是因为这行只包含一个单词。
 * 示例 3:
 *
 * 输入:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 *          "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * 输出:
 * [
 *   "Science  is  what we",
 *   "understand      well",
 *   "enough to explain to",
 *   "a  computer.  Art is",
 *   "everything  else  we",
 *   "do                  "
 */
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ret=new ArrayList<>();
        helper(words,0,maxWidth,new ArrayList<String>(),ret,0);
        return ret;
    }

    private void helper(String[] words, int wordIndex, int maxWidth, List<String> currList,List<String> ret,int curSize) {
        while (wordIndex<words.length&&curSize+currList.size()-1<maxWidth&&curSize+currList.size()+words[wordIndex].length()<=maxWidth){
            currList.add(words[wordIndex]);
            curSize+=words[wordIndex].length();
            wordIndex++;
        }
        if (wordIndex==words.length) {
            StringBuilder sb=new StringBuilder();
            for (int i=0;i<currList.size()-1;i++){
                sb.append(currList.get(i));
                sb.append(" ");
            }
            sb.append(currList.get(currList.size()-1));
            int size=sb.length();
            for (int i=0;i<maxWidth-size;i++)
                sb.append(" ");
            ret.add(sb.toString());
            return;
        }
        StringBuilder sb=new StringBuilder();
        int backspace=maxWidth-curSize;
        int[] intervals=new int[currList.size()-1];
        for (int i=0;i<intervals.length;i++){
            intervals[i]=(backspace+intervals.length-i-1)/(intervals.length-i);
            backspace-=intervals[i];
        }
        for (int i=0;i<intervals.length;i++){
            sb.append(currList.get(i));
            for (int n=0;n<intervals[i];n++)
                sb.append(" ");
        }
        sb.append(currList.get(currList.size()-1));
        int size=sb.length();
        for (int i=0;i<maxWidth-size;i++) sb.append(" ");
        ret.add(sb.toString());
        helper(words,wordIndex,maxWidth,new ArrayList<>(),ret,0);
    }

    @Test
    public void test(){
        String[] words={"Science","is","what","we","understand","well","enough","to","explain",
                "to","a","computer.","Art","is","everything","else","we","do"};
        int maxSize=20;
        System.out.println(fullJustify(words,maxSize));
    }
}
