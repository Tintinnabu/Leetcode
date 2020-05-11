package top.tinn.剑指offer.Interview_37;

import org.junit.jupiter.api.Test;
import top.tinn.utils.MainClass;
import top.tinn.utils.TreeNode;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/1 10:53
 */
public class Solution {
    private StringBuilder sb;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        sb = new StringBuilder();
        if (root == null) return "";
        dfs(root);
        return sb.substring(0, sb.length() - 1);

    }

    private void dfs(TreeNode treeNode){
        if (treeNode == null){
            sb.append("null,");
        }else {
            sb.append(treeNode.val + ",");
            dfs(treeNode.left);
            dfs(treeNode.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) return null;
        String[] datas = data.split(",");
        return helper(datas, datas.length - 1);
    }

    private int left = 0;
    private TreeNode helper(String[] datas, int right) {
        if (left > right) return null;
        if (datas[left].equals("null")){
            left++;
            return null;
        }
        TreeNode root = stringToTreeNode(datas[left]);
        left++;
        root.left = helper(datas, right);
        root.right = helper(datas, right);
        return root;
    }

    private TreeNode stringToTreeNode(String s){
        if (s.equals("null")) return null;
        return new TreeNode(Integer.parseInt(s));
    }


    @Test
    public void test(){
        TreeNode treeNode = MainClass.stringToTreeNode("[1,2,3,null,null,4,5]");
        String serial = serialize(treeNode);
        System.out.println(serial);
        TreeNode de = deserialize(serial);
        System.out.println(serialize(de));
    }
}
