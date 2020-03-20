package top.tinn.Top200.Problem_119;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        Integer[] row=new Integer[rowIndex+1];
        for (int i=0;i<=rowIndex;i++){
            for (int j=i;j>=0;j--){
                if (i==j||j==0) row[j]=1;
                else row[j]+=row[j-1];
            }
        }
        return Arrays.asList(row);
    }

    @Test
    public void test(){
        System.out.println(getRow(3));
    }
}
