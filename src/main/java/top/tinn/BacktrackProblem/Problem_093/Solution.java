package top.tinn.BacktrackProblem.Problem_093;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Test
    public void test(){
        //System.out.println(restoreIpAddresses("25525511135"));
        //System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("172162541"));
        System.out.println("216".matches("\\d|[1-9]\\d|[1]\\d{2}|2[0-4]\\d|25[0-5]"));
    }

}
