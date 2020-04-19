package top.tinn.Problem_237;

import top.tinn.utils.ListNode;

import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tinn
 * @Date 2020/4/18 20:42
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
