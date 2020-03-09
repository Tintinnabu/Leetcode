package top.tinn.TreeProblem.Problem_655;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        int height=getHeight(root);
        String[][] res=new String[height][(1<<height)-1];
        for (String[] arr:res) Arrays.fill(arr,"");
        List<List<String>> ans;
        fill(res,root,0,0,res[0].length);
        ans=Arrays.stream(res).map(i->Arrays.stream(i).collect(Collectors.toList())).collect(Collectors.toList());
        return ans;
    }

    private void fill(String[][] res, TreeNode root, int depth, int l, int r) {
        if (root==null) return;
        res[depth][(l+r)/2]=""+root.val;
        fill(res,root.left,depth+1,l,(l+r)/2);
        fill(res,root.right,depth+1,(l+r+1)/2,r);

    }

    private int getHeight(TreeNode root) {
        if (root==null) return 0;
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    @Test
    public void test(){
        String tree="[1,2]";
        System.out.println(printTree(MainClass.stringToTreeNode(tree)));
    }
}
