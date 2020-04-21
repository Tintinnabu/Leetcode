package top.tinn.Problem_295;

import java.util.PriorityQueue;

/**
 * @ClassName MedianFinder
 * @Description
 * @Author Tinn
 * @Date 2020/4/20 16:02
 */
public class MedianFinder {

    private int count;
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;
    /** initialize your data structure here. */
    public MedianFinder() {
        count = 0;
        maxHeap = new PriorityQueue<>((x,y)->(y-x));
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        count++;
        maxHeap.offer(num);
        minHeap.add(maxHeap.poll());
        if ((count & 1) !=0)
            maxHeap.add(minHeap.poll());
    }

    public double findMedian() {
        //偶数
        if ((count & 1) == 0)
            return (double)(maxHeap.peek() + minHeap.peek()) / 2;
        return (double)maxHeap.peek();
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        //medianFinder.addNum(1);
        medianFinder.addNum(2);
        //System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}
