package top.tinn.mianshiti.Problem_057;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 面试题57 - II. 和为s的连续正数序列
 *
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *  
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] findContinuousSequence(int target) {
        int left=1,right=1;
        int sum=0;
        Map<Integer,Integer> map=new LinkedHashMap<>();
        while(right<target){
            sum+=right++;
            while(sum>=target||left>=target){
                if(sum==target) map.put(left,right-1);
                sum-=left++;
            }
        }
        int[][] result=new int[map.size()][];
        int i=0;
        for (Integer key:map.keySet()){
            int value=map.get(key);
            int start=key;
            int[] temp=new int[value-key+1];
            for (int j=0;j<value-key+1;j++){
                temp[j]=start;
                start++;
            }
            result[i++]=temp;
        }
        //Arrays.sort(result, Comparator.comparing((int[] s)->(s[0])));
        return result;
    }

    @Test
    public void test(){
        int[][] res=findContinuousSequence(100);
    }
}
