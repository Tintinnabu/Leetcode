package top.tinn.UnionFindProblem.Problem_990;

import top.tinn.UnionFindProblem.UnionFind;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/6/8 8:39
 */
public class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        // 先让相等的字母形成连通分量
        for(String equation : equations){
            if (equation.charAt(1) == '='){
                uf.union(equation.charAt(0) - 'a', equation.charAt(3) - 'a');
            }
        }
        // 检查不等关系是否打破相等关系的连通性
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                char x = eq.charAt(0);
                char y = eq.charAt(3);
                // 如果相等关系成立，就是逻辑冲突
                if (uf.connected(x - 'a', y - 'a'))
                    return false;
            }
        }
        return true;
    }
}
