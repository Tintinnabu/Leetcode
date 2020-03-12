package top.tinn.BacktrackProblem.Problem_401;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        int[] mark={1,2,4,8,16,32};

        List<String> result=new ArrayList<>();
        for(int i=0;i<=num&&i<=4;i++){
            List<String> hourList=new ArrayList<>();
            List<String> minList=new ArrayList<>();
            if (i==0) hourList.add("0");
            else backtrackHour(i,hourList,mark,0,0);
            if (num-i==0) minList.add("0");
            else backtrackMin(num-i,minList,mark,0,0);
            for (String hour:hourList){
                for (String min:minList){
                    if (min.length()<2){
                        result.add(hour+":0"+min);
                    }else
                        result.add(hour+":"+min);
                }
            }
        }
        return result;
    }

    private void backtrackHour(int hoursNum,List<String> hourList, int[] mark,int start,int hrs) {
        if (hrs>=12) return;
        if (hoursNum==0){
            hourList.add(hrs+"");
            return;
        }
        for (int i=start;i<mark.length;i++){
            hrs+=mark[i];
            backtrackHour(hoursNum-1,hourList,mark,i+1,hrs);
            hrs-=mark[i];
        }
    }

    private void backtrackMin(int minSum,List<String> minList, int[] mark,int start,int mins) {
        if (mins>=60) return;
        if (minSum==0){
            minList.add(mins+"");
            return;
        }
        for (int i=start;i<mark.length;i++){
            mins+=mark[i];
            backtrackMin(minSum-1,minList,mark,i+1,mins);
            mins-=mark[i];
        }
    }


    @Test
    public void test(){
        System.out.println(readBinaryWatch(1));
    }
}
