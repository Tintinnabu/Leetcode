package top.tinn.Contest_Single_190.Problem_3;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/24 10:46
 */
public class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return pseudoPalindromicPaths(root, 0);
    }

    public int pseudoPalindromicPaths(TreeNode root, int bits) {
        if(root == null){
            return 0;
        }
        bits ^= 1 << root.val;
        if(root.left == null && root.right == null){
            return Integer.bitCount(bits) <= 1 ? 1 : 0;
        }
        int ans = pseudoPalindromicPaths(root.left, bits) + pseudoPalindromicPaths(root.right, bits);
        return ans;
    }
    
    @Test
    public void test(){
        String tree = "[6,6,6,null,6,6,null,null,null,2,8,8,8,3,2,5,6,null,8,null,null,1,1,7,9,null,null,null,null,null,null,null,null,5,null,null,4]";
        System.out.println(pseudoPalindromicPaths(MainClass.stringToTreeNode(tree)));
    }
    
    
}
