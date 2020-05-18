package top.tinn.Over200.Problem_365;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * @ClassName Solution
 * @Description
 * @Author Tintinnabu
 * @Date 2020/5/16 17:03
 */
public class Solution {
    /**
     *
     * @param x
     * @param y
     * @param z
     * @return
     */
    public boolean canMeasureWater2(int x, int y, int z) {
        if (x + y < z){
            return false;
        }
        if (x == 0 || y == 0){
            return z == 0 || x + y == z;
        }
        int gcd = getGCD(x, y);
        return z % gcd == 0;
    }

    private int getGCD(int x, int y) {
        while (x % y != 0){
            int temp = x % y;
            x = y;
            y = temp;
        }
        return y;
    }

    public boolean canMeasureWater(int x, int y, int z) {
        if (z == 0) {
            return true;
        }
        if (x + y < z){
            return false;
        }
        State initState = new State(0, 0);
        //BFS
        Queue<State> queue = new LinkedList<>();
        Set<State> visited = new HashSet<>();

        queue.offer(initState);
        visited.add(initState);

        while (!queue.isEmpty()){
            State head = queue.poll();
            int curX = head.getX();
            int curY = head.getY();

            if (curX == z || curY == z || curX + curY == z){
                System.out.println(head);
                return true;
            }
            List<State> nextStates = getNextStates(curX, curY, x, y);
            System.out.println(nextStates);

            for (State nextState : nextStates){
                if (!visited.contains(nextState)){
                    queue.offer(nextState);
                    visited.add(nextState);
                }
            }
        }
        return false;
    }

    private List<State> getNextStates(int curX, int curY, int x, int y) {
        // 最多 8 个对象，防止动态数组扩容，不过 Java 默认的初始化容量肯定大于 8 个
        List<State> nextStates= new ArrayList<>(8);
        //x加满
        State state1 = new State(x, curY);
        //y加满
        State state2 = new State(curX, y);
        //x清空
        State state3 = new State(0, curY);
        //y清空
        State state4 = new State(curX, 0);
        //x倒入y，y满，x有剩余
        State state5 = new State(curX - y + curY, y);
        //x全部倒入y
        State state6 = new State(0, curY + curY);
        //y倒入x，x满，y有剩余
        State state7 = new State(x, curY - x + curX);
        //y全部导入x
        State state8 = new State(curX + curY, 0);
        if (curX < x){
            nextStates.add(state1);
        }
        if (curY < y){
            nextStates.add(state2);
        }
        if (curX > 0){
            nextStates.add(state3);
        }
        if (curY > 0){
            nextStates.add(state4);
        }
        if (curX + curY > y){
            nextStates.add(state5);
        }else {
            nextStates.add(state6);
        }
        if (curX + curY > x){
            nextStates.add(state7);
        }else{
            nextStates.add(state8);
        }
        return nextStates;
    }

    @Test
    public void test(){
        System.out.println(canMeasureWater(2, 6, 5));
    }
}
