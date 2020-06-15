package top.tinn.Over200.Problem_382;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;

import java.util.Random;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/15
 */
public class Solution {
    private ListNode head;
    private Random random;
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        random = new Random();
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int count = 0;
        int reserve = 0;
        while (node != null){
            count++;
            int rand = 1 + random.nextInt(count);
            if (rand == count){
                reserve = node.val;
            }
            node = node.next;
        }
        return reserve;
    }

    public static void  main(String[] args){
        Random random = new Random();
        int i = 0;
        while (i < 20){
            System.out.println(random.nextInt(1));
            i++;
        }
    }
}
