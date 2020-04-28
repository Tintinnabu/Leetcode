package top.tinn.Algorithm_4th.Chapter1;

/**
 * @ClassName WeightedQuickUnionUF
 * @Description
 * @Author Tinn
 * @Date 2020/4/23 13:11
 */
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] sz;
    private int count;

    public WeightedQuickUnionUF(int N) {
        this.count = count;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            sz[i] = 1;
        }
    }

    public int count(){
        return count;
    }

    public boolean connected(int p, int q){
        return find(p) == find(q);
    }

    public int find(int p){
        //添加路径压缩
        int cur = p;
        while (p != id[p])
            p = id[p];
        while (cur != id[cur]){
            int next = id[cur];
            id[cur] = p;
            cur = next;
        }
        return p;
    }

    public void union(int p, int q){
        int pId = find(p);
        int qId = find(q);
        if (qId == pId) return;
        /*for (int i = 0; i < id.length; i++){
            if (id[i] == pId) id[i] = qId;
        }*/
        /*id[pId] = qId;*/
        if (sz[pId] < sz[qId]){
            id[pId] = qId;
            sz[qId] += sz[pId];
        }else {
            id[qId] = pId;
            sz[pId] +=sz[qId];
        }
        count--;
    }
}
