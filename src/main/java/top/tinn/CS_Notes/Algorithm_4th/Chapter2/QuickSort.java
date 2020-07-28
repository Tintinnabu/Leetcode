package top.tinn.CS_Notes.Algorithm_4th.Chapter2;

import java.util.Random;

/**
 * @ClassName QuickSort
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 14:10
 */
public class QuickSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int left, int right) {
        if (left >= right) return;
        Random random = new Random();
        int pivotIdx = random.nextInt(right - left) + left;
        Comparable pivot = a[pivotIdx];
        int i = left, j = right, cur = i;
        while (cur <= j){
            if (less(a[cur], pivot)){
                exch(a, i, cur);
                i++;
                cur++;
            }else if (less(pivot, a[cur])){
                exch(a, cur, j);
                j--;
            }else {
                cur++;
            }
        }
        sort(a, left, i - 1);
        sort(a, j + 1, right);
    }

    public static void main(String[] args) {
        String[] a = {"bed","bug" ,"dad", "yes" ,"zoo", "…" ,"all" ,"bad" ,"yet"};
        Sort sort = new QuickSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
        Integer[] b = {9,6,3,5,1};
        sort.sort(b);
        assert sort.isSorted(b);
        sort.show(b);
    }
}
