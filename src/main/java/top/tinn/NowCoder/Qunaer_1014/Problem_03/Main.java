package top.tinn.NowCoder.Qunaer_1014.Problem_03;

import java.util.*;

/**
 * @Author: Tinn
 * @Date: 2020/10/14 19:52
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<Character, Set<Integer>> map = new HashMap<>();
        map.put('S', new HashSet<>());
        map.put('H', new HashSet<>());
        map.put('C', new HashSet<>());
        map.put('D', new HashSet<>());
        int[] count = new int[15];
        for (int i = 0; i < n; i++){
            String poke = scanner.next();
            char huase = poke.charAt(0);
            String remain = poke.substring(1);
            if (remain.length() == 2){
                map.get(huase).add(10);
                count[10]++;
            }else if (Character.isDigit(remain.charAt(0))){
                map.get(huase).add(Integer.parseInt(remain));
                count[Integer.parseInt(remain)]++;
            }else {
                if (remain.equals("A")){
                    map.get(huase).add(14);
                    count[14]++;
                }else if (remain.equals("K")){
                    map.get(huase).add(13);
                    count[13]++;
                }else if (remain.equals("Q")){
                    map.get(huase).add(12);
                    count[12]++;
                }else if (remain.equals("J")){
                    map.get(huase).add(11);
                    count[11]++;
                }
            }
        }
        count[1] = count[14];
        //initial finished
        int temp = isTongHuaShun(map);
        if (temp == 1){
            System.out.println("HuangJiaTongHuaShun");
            return;
        }else if (temp == 2){
            System.out.println("TongHuaShun");
            return;
        }
        if (isSitiao(count, n)){
            System.out.println("SiTiao");
            return;
        }
        if (isHulu(count)){
            System.out.println("HuLu");
            return;
        }
        if (isTonghua(map)){
            System.out.println("TongHua");
            return;
        }
        if (isShunZi(count)){
            System.out.println("ShunZi");
            return;
        }
        if (isSanTiao(count)){
            System.out.println("SanTiao");
            return;
        }
        if (isLiangDui(count)){
            System.out.println("LiangDui");
            return;
        }
        if (isYiDui(count)){
            System.out.println("YiDui");
            return;
        }
        System.out.println("Gaopai");
    }

    private static boolean isYiDui(int[] count) {
        int duizi = 0;
        int danpai = 0;
        for (int i = 1; i < count.length; i++){
            if (count[i] >= 2){
                if (duizi == 1){
                    danpai++;
                }else {
                    duizi++;
                }
            }else if (count[i] >= 1){
                danpai++;
            }
        }
        return duizi == 1 && danpai >= 3;
    }

    private static boolean isLiangDui(int[] count) {
        int danpai = 0;
        int duizi = 0;
        for (int i = 1; i < count.length; i++){
            if (count[i] >= 2){
                if (duizi == 2){
                    danpai++;
                }else {
                    duizi++;
                }
            }else if (count[i] > 0){
                duizi++;
            }
        }
        return danpai > 0 && duizi > 1;
    }

    private static boolean isSanTiao(int[] count) {
        int danpai = 0;
        boolean santiao = false;
        for (int i = 1; i < count.length; i++){
            if (count[i] >= 3){
                santiao = true;
            }
            if (count[i] == 1){
                danpai++;
            }
        }
        return danpai > 1 && santiao;
    }

    private static boolean isShunZi(int[] count) {
        for (int i = 1; i <= 10; i++){
            int start = i;
            int loop = 0;
            while (start < count.length && count[start] > 0){
                start++;
                loop++;
            }
            if (loop >= 5){
                return true;
            }
        }
        return false;
    }

    private static boolean isTonghua(Map<Character, Set<Integer>> map) {
        for (char c : map.keySet()){
            if (map.get(c).size() >= 5){
                return true;
            }
        }
        return false;
    }

    private static boolean isHulu(int[] count) {
        boolean three = false;
        boolean two = false;
        for (int i = 1; i < count.length; i++){
            if (count[i] >= 3){
                if (three){
                    two = true;
                }else {
                    three = true;
                }
            }else if (count[i] >= 2){
                two = true;
            }
        }
        return three && two;
    }

    private static boolean isSitiao(int[] count, int n) {
        int si = 0;
        int dan = 0;
        for (int i = 1; i < count.length; i++){
            if (count[i] >= 4){
                si++;
            }else if (count[i] == 1){
                dan++;
            }
        }
        return si > 0 && dan > 0;
    }

    private static int isTongHuaShun(Map<Character, Set<Integer>> map) {
        for (char c : map.keySet()){
            if (map.get(c).size() >= 5){
                Set<Integer> set = map.get(c);
                for (int a : set){
                    int loop = 0;
                    if (!set.contains(a + 1)){
                        int start = a;
                        while (set.contains(start)){
                            start--;
                            loop++;
                        }
                        if (loop >= 5){
                            if (a == 14){
                                return 1;
                            }else {
                                return 2;
                            }
                        }
                    }
                }
            }
        }
        return 0;
    }
}
