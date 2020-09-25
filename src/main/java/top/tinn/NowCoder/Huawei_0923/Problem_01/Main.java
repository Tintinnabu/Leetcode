package top.tinn.NowCoder.Huawei_0923.Problem_01;

import java.util.Scanner;

/**
 * @Author: Tinn
 * @Date: 2020/9/23 20:02
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.next();
        String ganrao = scanner.next();
        int len = ganrao.length();
        int curLen = (int)(0.8 * len);
        int maxStart = len - curLen;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        while (i < sentence.length()){
            if (!flag){
                for (int start = 0; start <= maxStart; start++){
                    //开始匹配
                    if (sentence.charAt(i) == ganrao.charAt(start)){
                        int j = startMatch(sentence, i, ganrao, start, len - start, len);
                        //匹配成成功
                        if (j != -1){
                            flag = true;
                            int temp = i;
                            i = j;
                            while (j - temp > 0){
                                sb.append('*');
                                j--;
                            }
                        }
                    }
                }
            }
            sb.append(sentence.charAt(i));
            i++;
        }
        System.out.println(sb.toString());
    }

    private static int startMatch(String sentence, int i, String ganrao, int start, int len, int totalLen) {
        int m = 0;
        while (m < len){
            if (i < sentence.length() &&
                    sentence.charAt(i) == ganrao.charAt(start)){
                i++;
                start++;
            }else if (i + 1 < sentence.length() &&
                    sentence.charAt(i + 1) == ganrao.charAt(start)){
                i += 2;
                start++;
            }else {
                break;
            }
            m++;
        }
        return m >= (int)(totalLen * 0.8) ? i : -1;
    }
}
