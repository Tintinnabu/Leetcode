package top.tinn.剑指offer.Interview_33;

import java.util.Stack;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 9:02
 */
public class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    private boolean verifyPostorder(int[] postorder, int left, int right) {
        if (left >= right) return true;
        int rootVal = postorder[right];
        int i = left;
        while (postorder[i] < rootVal)
            i++;
        for (int j = i; j < right; j++){
            if (postorder[j] <= rootVal)
                return false;
        }
        return verifyPostorder(postorder, left, i-1) && verifyPostorder(postorder, i, right-1);
    }

    public boolean verifyPostorder2(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for (int i = postorder.length - 1; i >= 0; i--){
            if (postorder[i] >= root) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i])
                root = stack.pop();
            stack.push(postorder[i]);
        }
        return true;
    }
}
