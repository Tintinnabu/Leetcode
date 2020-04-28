package top.tinn.Algorithm_4th.Chapter2;

/**
 * @ClassName HeapSort
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 16:18
 */
public class HeapSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length - 1;
        for (int k = N/2; k >= 0; k--){
            sink(a, k, N);
        }
        while (N > 0){
            exch(a, 0, N--);
            sink(a, 0, N);
        }
    }

    private void sink(Comparable[] a, int k, int N) {
        while (k*2 < N){
            int j = 2 * k;
            if (j < N && less(a, j, j + 1)) j++;
            if (less(a, k, j)) {
                exch(a, k, j);
                k = j;
            }else break;
        }
    }

    private boolean less(Comparable[] a, int i, int j) {
        int ret = a[i].compareTo(a[j]);
        return ret < 0;
    }


    public static void main(String[] args) {
        String[] a = {"a","s","o","r","t","e","x","a","m","p","l","e"};
        Sort sort = new HeapSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
        Integer[] b = {9,6,3,5,1};
        sort.sort(b);
        assert sort.isSorted(b);
        sort.show(b);
    }
}
