package top.tinn.InterviewProblem.Problem_059;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 面试题59 - II. 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 *
 * 示例 1：
 *
 * 输入:
 * ["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
 * [[],[1],[2],[],[],[]]
 * 输出: [null,null,null,2,1,2]
 * 示例 2：
 *
 * 输入:
 * ["MaxQueue","pop_front","max_value"]
 * [[],[],[]]
 * 输出: [null,-1,-1]
 *  
 *
 * 限制：
 *
 * 1 <= push_back,pop_front,max_value的总操作数 <= 10000
 * 1 <= value <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxQueue {
    private Queue<Integer> queue;
    private Deque<Integer> mark;
    public MaxQueue() {
        queue=new ArrayDeque<>();
        mark=new ArrayDeque<>();
    }

    public int max_value() {
        return mark.isEmpty()?-1:mark.peek();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!mark.isEmpty()&&mark.peekLast()<value)
            mark.pollLast();
        mark.offer(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        int val=queue.poll();
        if (mark.peek()==val) mark.poll();
        return val;
    }
}
