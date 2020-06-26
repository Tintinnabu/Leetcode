package top.tinn.Over200.Problem_415;

public class Solution {
    public String addStrings(String num1, String num2) {
        char[] char1 = num1.toCharArray();
        char[] char2 = num2.toCharArray();
        int c = 0;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < char1.length || i < char2.length || c > 0){
            int val1 = i < char1.length ? char1[char1.length - i - 1] - '0' : 0;
            int val2 = i < char2.length ? char2[char2.length - i - 1] - '0' : 0;
            int sum = val1 + val2 + c;
            i++;
            sb.append(sum % 10);
            c = sum / 10;
        }
        return sb.reverse().toString();
    }
}
