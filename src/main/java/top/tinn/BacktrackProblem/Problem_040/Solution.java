package top.tinn.BacktrackProblem.Problem_040;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result=new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates,int target,int start,List<Integer> list){
        if (target==0) result.add(new ArrayList<>(list));
        else {
            for (int i=start;i<candidates.length;i++){
                if (candidates[i]>target) continue;
                if (i>start&&candidates[i]==candidates[i-1]) continue;
                list.add(candidates[i]);
                backtrack(candidates,target-candidates[i],i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    @Test
    public void test(){
        int[] candidates={10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates,8));
    }
}
