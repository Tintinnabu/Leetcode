package top.tinn.CS_Notes.Algorithm_4th.Chapter2;

/**
 * @ClassName InsertSort
 * @Description 等价于冒泡排序
 * @Author Tinn
 * @Date 2020/4/23 13:44
 */
public class InsertSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int len = a.length;
        for (int i = 1; i < len; i++){
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed","bug" ,"dad", "yes" ,"zoo", "…" ,"all" ,"bad" ,"yet"};
        Sort sort = new InsertSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
        Integer[] b = {9,6,3,5,1};
        sort.sort(b);
        assert sort.isSorted(b);
        sort.show(b);
    }
}
