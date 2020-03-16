package top.tinn.DoublePointsProblem.Problem_088;

import org.junit.jupiter.api.Test;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 num1 成为一个有序数组。
 *
 *  
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 *  
 *
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums2.length==0) return;
        int n1=m-1,n2=n-1;
        int insertPos=m+n-1;
        while (n1>=0&&n2>=0){
            if (nums1[n1]<=nums2[n2])
                nums1[insertPos--]=nums2[n2--];
            else nums1[insertPos--]=nums1[n1--];
        }
        while (n2>=0)
            nums1[insertPos--]=nums2[n2--];
        int i=1;
    }

    @Test
    public void test(){
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={2,5,6};
        merge(nums1,3,nums2,3);
    }
}
