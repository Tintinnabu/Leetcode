package top.tinn.NowCoder.Vivo_0912.Problem_03;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/12 20:37
 */
public class Solution {
    public String compileSeq (String input) {
        // write code here
        int[] dep = Arrays.stream(input.split(",")).mapToInt(s -> Integer.parseInt(s)).toArray();
        Map<Integer, List<Integer>> target = new HashMap<>();
        LinkedList<Integer> start = new LinkedList<>();
        for (int i = 0; i < dep.length; i++){
            if (dep[i] == -1){
                start.add(i);
            }else {
                int dependency = dep[i];
                if (!target.containsKey(dependency)){
                    target.put(dependency, new ArrayList<>());
                }
                target.get(dependency).add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!start.isEmpty()){
            Integer cur = start.poll();
            ans.add(cur);
            List<Integer> t = target.get(cur);
            if (t != null){
                start.addAll(t);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Integer i : ans){
            sb.append(i);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    @Test
    public void test(){
        System.out.println(compileSeq("1,2,-1,1"));
        System.out.println(compileSeq("1,-1"));
        System.out.println(compileSeq("-1,-1"));
    }
}
