package top.tinn.NowCoder.PDD_1023.Problem_03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/10/23 19:23
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> opts = new ArrayList<>();
        int maxOr = -1, orVal = -1;
        int minAnd = -1, andVal = (2 << m);
        for (int i = 0; i < n; i++){
            int opt = scanner.next().charAt(0);
            int val = scanner.nextInt();
            opts.add(new int[]{opt, val});
            if (opt == '|'){
                if (val > orVal){
                    maxOr = i;
                    orVal = val;
                }
            }else if (opt == '&'){
                if (val < andVal){
                    minAnd = i;
                    andVal = val;
                }
            }
        }
        int lines = 0;
        int cur;
        int index;
        StringBuilder sb = new StringBuilder();
        if (maxOr > minAnd){
            cur = orVal;
            index = maxOr;
            sb.append("| "+ opts.get(maxOr)[1]);
        }else {
            index = minAnd;
            cur = minAnd;
            sb.append("& " + opts.get(minAnd)[1]);
        }
        sb.append("\n");
        lines++;
        for (int j = index + 1; j < opts.size(); j++){
            int opt = opts.get(j)[0];
            int val = opts.get(j)[1];
            if (opt == '|'){
                if (cur != (val | cur)){
                    sb.append("| " + val);
                    lines++;
                }
            }else if (opt == '&'){
                if (cur != (val & cur)){
                    sb.append("& " + val);lines++;
                }
            }else {
                if (cur != (val ^ cur)){
                    sb.append("^ ").append(val);lines++;

                }
            }

            sb.append("\n");
        }
        System.out.println(lines);
        System.out.println(sb.toString());
    }
}
