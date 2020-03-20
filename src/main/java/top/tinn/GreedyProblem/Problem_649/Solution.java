package top.tinn.GreedyProblem.Problem_649;

public class Solution {
    public String predictPartyVictory(String senate) {
        char[] c=senate.toCharArray();
        int person=0;
        boolean R=true,D=true;
        while (R&&D){
            R=false;D=false;
            for (int i=0;i<c.length;i++){
                if (c[i]=='R'){
                    R=true;
                    if (person<0) c[i]='O';
                    person++;
                }else if (c[i]=='D'){
                    D=true;
                    if (person>0) c[i]='0';
                    person--;
                }
            }
        }
        return person>0?"Radiant":"Dire";
    }
}
