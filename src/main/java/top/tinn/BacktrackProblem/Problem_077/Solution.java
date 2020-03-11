package top.tinn.BacktrackProblem.Problem_077;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 *
 * 示例:
 *
 * 输入: n = 4, k = 2
 * 输出:
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(n,k,result,new ArrayDeque<>(),1);
        return result;
    }

    private void backtrack(int n, int k, List<List<Integer>> result, ArrayDeque<Integer> temp,int start){
        if (temp.size()==k) result.add(new ArrayList<>(temp));
        else if (temp.size()>k||start>n) return;
        else {
            for (int i=start;i<=n;i++){
                    temp.add(i);
                    backtrack(n,k,result,temp,i+1);
                    temp.removeLast();
            }
        }
    }

    @Test
    public void test(){
        System.out.println(combine(4,2));
    }
}
