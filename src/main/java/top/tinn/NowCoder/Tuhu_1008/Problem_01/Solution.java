package top.tinn.NowCoder.Tuhu_1008.Problem_01;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author: Tinn
 * @Date: 2020/10/8 19:06
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param y1 int整型 当前日期的年
     * @param m1 int整型 当前日期的月
     * @param d1 int整型 当前日期的日
     * @param y2 int整型 项目截止日期的年
     * @param m2 int整型 项目截止日期的月
     * @param d2 int整型 项目截止日期的日
     * @return int整型
     */
    public int workdays_between (int y1, int m1, int d1, int y2, int m2, int d2) {
        // write code here
        Calendar startDate = Calendar.getInstance();
        startDate.set(y1, m1 - 1, d1);
        Calendar endDate = Calendar.getInstance();
        Calendar cur = startDate;
        endDate.set(y2, m2 - 1, d2);
        endDate.add(Calendar.DAY_OF_YEAR, -1);
        int ans = 0;
        Calendar first = Calendar.getInstance();
        first.set(1, 0, 1);
        long f = first.getTimeInMillis();
        long sd = startDate.getTimeInMillis();
        long weeks1 = (sd - f)/86400000 / 7;
        long days1 = (sd - f)/86400000 % 7;
        long weekday1 = weeks1 * 5 + (days1 > 5 ? 5 : days1);
        long ed = endDate.getTimeInMillis();
        long weeks2 = (ed - f)/86400000 / 7;
        long days2 = (ed - f)/86400000 % 7;
        long weekday2 = weeks2 * 5 + (days2 > 5 ? 5 : days2);

        return (int)(weekday2 - weekday1);
    }

    @Test
    public void test(){
        System.out.println(workdays_between(2020,9,25,2020,9,28));
        List<String> ans = new ArrayList<>();
        List<Integer> ans2 = ans.stream().map(String::length).collect(Collectors.toList());
    }
}
