package top.tinn.剑指offer.Interview_41;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * @ClassName MedianFinder
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 20:07
 */
public class MedianFinder {
    private PriorityQueue<Integer> left;
    private PriorityQueue<Integer> right;
    /** initialize your data structure here. */
    public MedianFinder() {
        left = new PriorityQueue<>((a, b) -> (b - a));
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        right.add(num);
        left.add(right.poll());
        if (left.size() > right.size())
            right.add(left.poll());
    }

    public double findMedian() {
        return left.size() == right.size() ? (left.peek() + right.peek())/2.0 : right.peek();
    }

    @Test
    public void test(){
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
