package top.tinn.Top200.Problem_164;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 164. 最大间距
 *
 * 给定一个无序的数组，找出数组在排序之后，相邻元素之间最大的差值。
 *
 * 如果数组元素个数小于 2，则返回 0。
 *
 * 示例 1:
 *
 * 输入: [3,6,9,1]
 * 输出: 3
 * 解释: 排序后的数组是 [1,3,6,9], 其中相邻元素 (3,6) 和 (6,9) 之间都存在最大差值 3。
 * 示例 2:
 *
 * 输入: [10]
 * 输出: 0
 * 解释: 数组元素个数小于 2，因此返回 0。
 * 说明:
 *
 * 你可以假设数组中所有元素都是非负整数，且数值在 32 位有符号整数范围内。
 * 请尝试在线性时间复杂度和空间复杂度的条件下解决此问题。
 */

public class Solution {
    class Bucket{
        int min;
        int max;
        public Bucket(){
        }
        public Bucket(int min,int max){
            this.min=min;
            this.max=max;
        }
    }
    public int maximumGap(int[] nums) {
        if (nums.length<2) return 0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int n:nums){
            min=Math.min(min,n);
            max=Math.max(max,n);
        }
        if (max==min) return 0;
        int bucketSize=Math.max(1,(max-min)/(nums.length-1));
        int bucketNum=(max-min)/bucketSize+1;
        Bucket[] buckets=new Bucket[bucketNum];
        for (int n:nums){
            int bucketIdex=(n-min)/bucketSize;
            if (buckets[bucketIdex]==null){
                buckets[bucketIdex]=new Bucket(n,n);
            }
            else {
                buckets[bucketIdex].min=Math.min(buckets[bucketIdex].min,n);
                buckets[bucketIdex].max=Math.max(buckets[bucketIdex].max,n);
            }
        }
        int ret=Integer.MIN_VALUE;
        int preMax=Integer.MIN_VALUE;
        for (int i=0;i<bucketNum;i++){
            if (buckets[i]!=null){
                //ret=Math.max(ret,buckets[i].max-buckets[i].min);
                if (preMax!=Integer.MIN_VALUE) ret=Math.max(buckets[i].min-preMax,ret);
                preMax=buckets[i].max;
            }
        }
        return ret;
    }

    @Test
    public void test(){
        System.out.println(maximumGap(new int[]{1,1,1,1,1,5,5,5,5,5}));
    }
}
