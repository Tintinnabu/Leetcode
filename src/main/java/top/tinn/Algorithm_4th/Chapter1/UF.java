package top.tinn.Algorithm_4th.Chapter1;

/**
 * @ClassName UF
 * @Description union-find 算法的 API
 * @Author Tinn
 * @Date 2020/4/23 11:39
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int N) {
        this.count = N;
        id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        while (p != id[p])
            p = id[p];
        return p;
    }

    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if (qId == pId) return;
        /*for (int i = 0; i < id.length; i++){
            if (id[i] == pId) id[i] = qId;
        }*/
        id[pId] = qId;
        count--;
    }
}
