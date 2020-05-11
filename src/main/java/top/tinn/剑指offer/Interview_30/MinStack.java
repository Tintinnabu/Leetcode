package top.tinn.剑指offer.Interview_30;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 21:06
 */
public class MinStack {
    /** initialize your data structure here. */
    private Stack<Integer> stack;
    private int min;
    public MinStack() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        if (x <= min){
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.pop() == min){
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
