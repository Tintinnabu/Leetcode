package top.tinn.Algorithm_4th.Chapter2;

/**
 * @ClassName ShellSort
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 14:01
 */
public class ShellSort extends Sort {
    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        int h = 1;
        while (h < N / 3) h = 3*h + 1;
        while (h >= 1){
            for (int i = h; i < N; i++){
                for (int j = i; j >= h && less(a[j], a[j - h]);j -= h){
                    exch(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

    public static void main(String[] args) {
        String[] a = {"bed","bug" ,"dad", "yes" ,"zoo", "…" ,"all" ,"bad" ,"yet"};
        Sort sort = new ShellSort();
        sort.sort(a);
        assert sort.isSorted(a);
        sort.show(a);
        Integer[] b = {9,6,3,5,1};
        sort.sort(b);
        assert sort.isSorted(b);
        sort.show(b);
    }
}
