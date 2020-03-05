package top.tinn.Problem_739;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * 739. 每日温度
 *
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 通过次数31,921提交次数54,257
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result=new int[T.length];
        for (int i=0;i<T.length;i++){
            for(int j=i+1;j<T.length;j++){
                if (T[j]>T[i]) {
                    result[i]=j-i;
                    break;
                }
            }
        }
        return result;
    }


    @Test
    public void test(){
        int[] T=new int[]{73,74,75,71,69,72,76,73};
        int[] result=dailyTemperatures(T);
        int[] result2=dailyTemperatures2(T);
    }

    public int[] dailyTemperatures2(int[] T) {
        int[] result=new int[T.length];
        Stack<Integer> stack=new Stack<>();
        for (int i=T.length-1;i>=0;i--){
            while(!stack.isEmpty()&&T[i]>=T[stack.peek()]) stack.pop();
            result[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);
        }
        return result;
    }
}