package top.tinn.DoublePointsProblem.Problem_345;

public class Solution {
    public String reverseVowels(String s) {
        int l=0,r=s.length()-1;
        char[] schar=s.toCharArray();
        while (l<r){
            while (l<r&&!isVowels(schar[l])) l++;
            while (l<r&&!isVowels(schar[r])) r--;
            char temp=schar[l];
            schar[l]=schar[r];
            schar[r]=temp;
            l++;r--;
        }
        return String.valueOf(schar);
    }

    private boolean isVowels(char c){
        if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'||c=='A'||c=='E'||c=='I'||c=='O'||c=='U')
            return true;
        return false;
    }
}
