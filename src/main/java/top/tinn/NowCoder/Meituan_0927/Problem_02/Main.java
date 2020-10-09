package top.tinn.NowCoder.Meituan_0927.Problem_02;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/9/27 10:28
 */
public class Main {
    static boolean[] locked;
    static Set<Integer> has;
    static StringBuilder ret;
    static boolean[] inShujia;
    //书号 - 行号
    static Map<Integer, Integer> shujia;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int Q = scanner.nextInt();
        scanner.nextLine();
        locked = new boolean[N + 1];
        shujia = new HashMap<>();
        has = new HashSet<>();
        ret = new StringBuilder();
        inShujia = new boolean[N + 1];
        for (int i = 0; i < Q; i++){
            String[] str = scanner.nextLine().split(" ");
            if (str[0].equals("1")){
                put(Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            }else if (str[0].equals("2")){
                locked[Integer.parseInt(str[1])] = true;
            }else if (str[0].equals("3")){
                locked[Integer.parseInt(str[1])] = false;
            }else if (str[0].equals("4")){
                borrow(Integer.parseInt(str[1]));
            }else if (str[0].equals("5")){
                back(Integer.parseInt(str[1]));
            }
        }
        System.out.println(ret.toString());
    }

    private static void back(int x) {
        //没有书可还 或者 书架上锁
        if (!has.contains(x) || locked[shujia.get(x)] || inShujia[x]){
            return;
        }else {
            inShujia[x] = true;
            has.remove(x);
        }
    }

    private static void borrow(int x) {
        if (shujia.containsKey(x) && !locked[shujia.get(x)] && inShujia[x]){
            ret.append(shujia.get(x));
            inShujia[x] = false;
            has.add(x);
        }else {
            ret.append(-1);
        }
        ret.append("\n");
    }

    private static void put(int x, int y) {
        //已经借到
        if (has.contains(x)){
            return;
        }
        //书架上有 但是被锁
        if (shujia.containsKey(x) && locked[shujia.get(x)]){
            return;
        }
        //放置的行有锁
        if (locked[y]){
            return;
        }
        shujia.put(x, y);
        inShujia[x] = true;
    }
}
