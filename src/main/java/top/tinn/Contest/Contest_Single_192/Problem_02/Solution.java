package top.tinn.Contest.Contest_Single_192.Problem_02;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Tintinnabu
 * @description
 * @data 2020/6/7
 */
public class Solution {
    private static int mid = 0;
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int mid = arr[(arr.length-1) / 2];
        //找出最大的k个值
        List<Integer> newArr = Arrays.stream(arr).boxed().collect(Collectors.toList());
        Collections.sort(newArr, new Comparator<Integer>() {
            @Override
            public int compare(Integer i, Integer j) {
                if(Math.abs(i - mid) > Math.abs(j - mid)){
                    return 1;
                }else if(Math.abs(i - mid) == Math.abs(j - mid)){
                    return 1;
                }
                return -1;
            }
        });
        return newArr.stream().limit(k).mapToInt(Integer::intValue).toArray();
    }

    private class myComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer i, Integer j) {
            if(Math.abs(i - mid) > Math.abs(j - mid)){
                return -1;
            }else if(Math.abs(i - mid) == Math.abs(j - mid)){
                return -1;
            }
            return 1;
        }
    }

    private boolean isBigger(int i, int j, int mid) {
        if(Math.abs(i - mid) > Math.abs(j - mid)){
            return true;
        }else if(Math.abs(i - mid) == Math.abs(j - mid)){
            return i > j;
        }
        return false;
    }


    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.getStrongest(new int[]{-7,22,17,3}, 2)));
    }
}
