package top.tinn.剑指offer.Interview_09;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @ClassName CQueue
 * @Description
 * @Author Tintinnabu
 * @Date 2020/4/30 10:22
 */
public class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            if (stack1.isEmpty()) return -1;
            else {
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }

    @Test
    public void test(){
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        System.out.println(cQueue.deleteHead());
    }
}
