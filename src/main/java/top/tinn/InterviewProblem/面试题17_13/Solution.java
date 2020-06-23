package top.tinn.InterviewProblem.面试题17_13;

public class Solution {
    private TrieNode root;
    public int respace(String[] dictionary, String sentence) {
        root = new TrieNode();
        makeTrie(dictionary);
        int n = sentence.length();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--){
            dp[i] = n - i;
            TrieNode node = root;
            for (int j = i; j < n; j++){
                int c = sentence.charAt(j) - 'a';
                if (node.childs[c] == null){
                    dp[i] = Math.min(dp[i], dp[j + 1] + j - i + 1);
                    break;
                }
                if (node.childs[c].isWord){
                    dp[i] = Math.min(dp[i], dp[j + 1]);
                }else {
                    dp[i] = Math.min(dp[i], dp[j + 1] + j - i + 1);
                }
                node = node.childs[c];
            }
        }
        return dp[0];
    }

    private void makeTrie(String[] dictionary) {
        for (String str : dictionary){
            TrieNode node = root;
            for (char c : str.toCharArray()){
                int i = c - 'a';
                if (node.childs[i] == null){
                    node.childs[i] = new TrieNode();
                }
                node = node.childs[i];
            }
            node.isWord = true;
        }
    }

    private class TrieNode{
        TrieNode[] childs;
        boolean isWord;

        public TrieNode() {
            childs = new TrieNode[26];
            isWord = false;
        }
    }
}
