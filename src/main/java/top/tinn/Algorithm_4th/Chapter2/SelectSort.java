package top.tinn.Algorithm_4th.Chapter2;

/**
 * @ClassName SelectSort
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 13:39
 */
public class SelectSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 0; i < len; i++){
            int min = i;
            for (int j = i + 1; j < len; j++){
                if (less(a[j], a[min])) min = j;
            }
            exch(a, min, i);
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed","bug" ,"dad", "yes" ,"zoo", "…" ,"all" ,"bad" ,"yet"};
        Sort sort = new SelectSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
        Integer[] b = {9,6,3,5,1};
        sort.sort(b);
        assert sort.isSorted(b);
        sort.show(b);
    }
}
