package top.tinn.Top200.Problem_118;

import org.junit.jupiter.api.Test;
import top.tinn.utils.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret=new ArrayList<>();
        if (numRows==0) return ret;
        List<Integer> row=new ArrayList<Integer>(){{add(1);}};
        ret.add(row);
        for (int i=2;i<=numRows;i++){
            List<Integer> temp=new ArrayList<>();
            for (int j=1;j<i-1;j++){
                temp.add(row.get(j-1)+row.get(j));
            }
            temp.add(0,1);
            temp.add(1);
            ret.add(temp);
            row=temp;
        }
        return ret;
    }


    @Test
    public void test(){
        System.out.println(generate(5));
    }
}
