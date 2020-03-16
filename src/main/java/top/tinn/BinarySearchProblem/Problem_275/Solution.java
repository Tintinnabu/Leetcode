package top.tinn.BinarySearchProblem.Problem_275;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 275. H指数 II
 *
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照升序排列。编写一个方法，计算出研究者的 h 指数。
 *
 * h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）至多有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
 *
 *  
 *
 * 示例:
 *
 * 输入: citations = [0,1,3,5,6]
 * 输出: 3
 * 解释: 给定数组表示研究者总共有 5 篇论文，每篇论文相应的被引用了 0, 1, 3, 5, 6 次。
 *      由于研究者有 3 篇论文每篇至少被引用了 3 次，其余两篇论文每篇被引用不多于 3 次，所以她的 h 指数是 3。
 *  
 *
 * 说明:
 *
 * 如果 h 有多有种可能的值 ，h 指数是其中最大的那个。
 *
 *  
 *
 * 进阶：
 *
 * 这是 H指数 的延伸题目，本题中的 citations 数组是保证有序的。
 * 你可以优化你的算法到对数时间复杂度吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/h-index-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public int hIndex(int[] citations) {
        int l=0,r=citations.length-1;
        int size=citations.length;
        int ret=0;
        while (l<=r){
            int mid=l+(r-l)/2;
            if (citations[mid]>=size-mid) {
                ret=size-mid;
                r=mid-1;
            }
            else l=mid+1;
        }
        return ret;
    }

    @Test
    public void test(){
        int[] citations={0,1,3,5,6};
        System.out.println(hIndex(citations));
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int n:nums1) map.put(n,map.getOrDefault(n,0)+1);
        List<Integer> result=new ArrayList<>();
        for(int m:nums1){
            if(map.containsKey(m)&&map.get(m)>0){
                result.add(m);
                map.put(m,map.get(m)-1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
