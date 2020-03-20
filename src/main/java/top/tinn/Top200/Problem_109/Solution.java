package top.tinn.Top200.Problem_109;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * 109. 有序链表转换二叉搜索树
 *
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if (head==null) return null;
        if (head.next==null) return new TreeNode(head.val);
        ListNode slow=head,fast=head.next;
        while (fast.next != null && fast.next.next != null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode right=slow.next.next;
        TreeNode root=new TreeNode(slow.next.val);
        root.right=sortedListToBST(right);
        slow.next=null;
        root.left=sortedListToBST(head);
        return root;
    }

    @Test
    public void test(){
        ListNode head= MainClass.stringToListNode("[-10,-3,0,5,9]");
        TreeNode root=sortedListToBST(head);
        System.out.println(root);
    }
}
