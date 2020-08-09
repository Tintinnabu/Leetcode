package top.tinn.BacktrackProblem.Problem_093;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 93. 复原IP地址
 *
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 *
 * 示例:
 *
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/restore-ip-addresses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result=new ArrayList<>();
        backtrack(new StringBuilder(s),0,3,result);
        return result;
    }

    private void backtrack(StringBuilder s, int start, int remainPos,List<String> result) {
        String regex="\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5]";
        if (remainPos<0) return;
        if (remainPos==0) {
            if (s.substring(start).matches(regex))
                result.add(s.toString());
            return;
        }
        for (int i=start+1;i<=start+3&&i<s.length();i++){
            if (s.substring(start,i).matches( regex)){
                s.insert(i,".");
                backtrack(s,i+1,remainPos-1,result);
                s.deleteCharAt(i);
            }
        }
    }


    public List<String> restoreIpAddresses2(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        if (len > 12 || len < 4) {
            return res;
        }
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, res);
        return res;
    }

    private void dfs(String s, int len, int begin, int remain, Deque<String> path, List<String> res) {
        if (begin == len){
            if (remain == 0){
                res.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3 && i < len; i++){
            if (remain * 3 < len - i){
                continue;
            }
            if (isIpSegment(s, begin, i)){
                path.addLast(s.substring(begin, i + 1));
                dfs(s, len, i + 1, remain - 1, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isIpSegment(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0'){
            return false;
        }
        int res = 0;
        while (left <= right){
            res = 10 * res + s.charAt(left) - '0';
            left++;
        }
        return res >= 0 && res <= 255;
    }

    @Test
    public void test(){
        //System.out.println(restoreIpAddresses("25525511135"));
        //System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses2("172162541"));
        System.out.println("216".matches("\\d|[1-9]\\d|[1]\\d{2}|2[0-4]\\d|25[0-5]"));
    }

}
