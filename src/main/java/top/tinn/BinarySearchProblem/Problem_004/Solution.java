package top.tinn.BinarySearchProblem.Problem_004;

import org.junit.jupiter.api.Test;

/**
 * 4. 寻找两个有序数组的中位数
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        if (m>n){
            int[] temp=nums1;
            nums1=nums2;
            nums2=temp;
            int temp2=m;
            m=n;
            n=temp2;
        }
        int iMin=0,iMax=m,halfLen=(n+m+1)/2;
        while (iMin<=iMax){
            int i=iMin+(iMax-iMin)/2;
            int j=halfLen-i;
            if (i<iMax&&nums2[j-1]>nums1[i]) iMin=i+1;
            else if (i>iMin&&nums1[i-1]>nums2[j]) iMax=i-1;
            else {
                int maxLeft;
                if (i==0) maxLeft=nums2[j-1];
                else if (j==0) maxLeft=nums1[i-1];
                else maxLeft=Math.max(nums1[i-1],nums2[j-1]);
                if ((m+n)%2==1) return maxLeft;
                int minRight;
                if (i==m) minRight=nums2[j];
                else if (j==n) minRight=nums1[i];
                else minRight=Math.min(nums1[i],nums2[j]);
                return (minRight+maxLeft)/2.0;
            }
        }
        return 0.0;
    }


    @Test
    public void test(){
        int[] nums1={1,2};
        int[] nums2={3,4};
        System.out.println(findMedianSortedArrays(nums1,nums2));
    }
}
