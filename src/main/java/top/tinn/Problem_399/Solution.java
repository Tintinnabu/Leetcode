package top.tinn.Problem_399;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * 399. 除法求值
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。
 *
 * 示例 :
 * 给定 a / b = 2.0, b / c = 3.0
 * 问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
 * 返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]
 *
 * 输入为: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。 返回vector<double>类型。
 *
 * 基于上述例子，输入如下：
 *
 * equations(方程式) = [ ["a", "b"], ["b", "c"] ],
 * values(方程式结果) = [2.0, 3.0],
 * queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 * 输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。
 * @Author Tinn
 * @Date 2020/4/18 13:57
 */
public class Solution {
    //method 1 图+dfs
    public double[] calcEquation(List<List<String>> equations,
                                 double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> hashMap = new HashMap<>();
        int i = 0;
        for (List<String> l : equations){
            hashMap.computeIfAbsent(l.get(0), k -> new HashMap<>()).put(l.get(1), values[i]);
            hashMap.computeIfAbsent(l.get(1), k -> new HashMap<>()).put(l.get(0), 1 / values[i]);
            i++;
        }
        double[] res = new double[queries.size()];
        i = 0;
        for (List<String> q : queries){
            res[i++] = dfs(q.get(0), q.get(1), 1, new HashSet<String>(), hashMap);
        }
        return res;
    }

    private double dfs(String s, String e, double value, HashSet<String> visit,HashMap<String, HashMap<String, Double>> hashMap ) {
        if (!hashMap.containsKey(s)) return -1;
        if (visit.contains(s)) return -1;
        if (s.equals(e)) {
            return value;
        }
        HashMap<String, Double> next = hashMap.get(s);
        visit.add(s);
        for (String k : next.keySet()) {
            double res = dfs(k, e, next.get(k) * value, visit, hashMap);
            if (res != -1) return res;
        }
        visit.remove(s);
        return - 1;
    }




}
