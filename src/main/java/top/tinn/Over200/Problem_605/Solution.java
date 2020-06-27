package top.tinn.Over200.Problem_605;

public class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int i = 0;
        while (i < flowerbed.length){
            int cnt = 0;
            if (i == 0 && flowerbed[0] == 0){
                cnt++;
                i++;
            }
            while (i < flowerbed.length && flowerbed[i] == 0 && flowerbed[i - 1] == 0){
                cnt++;
                i++;
            }
            if (i == flowerbed.length && flowerbed[i - 1] == 0){
                cnt++;
            }
            i++;
            n -= (cnt >> 1);
            if (n <= 0){
                return true;
            }
        }
        return false;
    }
}
