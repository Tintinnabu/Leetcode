package top.tinn.CS_Notes.Algorithm_4th.Chapter2;

/**
 * @ClassName MergeSort
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 14:21
 */
public class MergeSort extends Sort{
    @Override
    public void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    private void sort(Comparable[] a, int lo, int hi){
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private void merge(Comparable[] a, int lo, int mid, int hi){
        Comparable[] aux = new Comparable[a.length];
        for (int l = lo; l <= hi; l++){
            aux[l] = a[l];
        }
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++){
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j],aux[i])) a[k] = aux[j++];
            else if (less(aux[i], aux[j])) a[k] = aux[i++];
        }
    }


    public static void main(String[] args) {
        String[] a = {"bed","bug" ,"dad", "yes" ,"zoo", "…" ,"all" ,"bad" ,"yet"};
        Sort sort = new MergeSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
        Integer[] b = {9,6,3,5,1};
        sort.sort(b);
        assert sort.isSorted(b);
        sort.show(b);
    }
}
