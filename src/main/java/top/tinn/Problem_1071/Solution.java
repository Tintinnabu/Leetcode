package top.tinn.Problem_1071;

import org.junit.jupiter.api.Test;

public class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(str1.length()<str2.length()){
            String t=str1;
            str1=str2;
            str2=t;
        }
        int len2=str2.length();
        int len1=str1.length();
        for(int i=len2;i>=1;i--){
            if (isSon(str2,i)) {
                if (len1 % i == 0) {
                    String temp = str2.substring(0, i);
                    int j;
                    for (j = 0; j < len1; j = j + i) {
                        if (str1.startsWith(temp, j)) ;
                        else break;
                    }
                    if (j == len1)
                        return temp;
                }
            }
        }
        return "";
    }

    private boolean isSon(String str2,int end){
        if(str2.length()%end==0){
            String temp=str2.substring(0,end);
            int j;
            for(j=0;j<str2.length();j=j+end){
                if(str2.startsWith(temp,j));
                else break;
            }
            if(j==str2.length())
                return true;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(gcdOfStrings("TAUXXTAUXXTAUXXTAUXXTAUXX","TAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXXTAUXX"));
    }
}
