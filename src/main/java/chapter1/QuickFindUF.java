package chapter1;

public class QuickFindUF implements api.chapter1.UF {

    private int [] id;

    private int count;

    public QuickFindUF(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0;i < N; i++) {
            this.id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        if(id[p] == id[q]) return;
        int target = id[q];
        for (int i = 0; i < id.length; i++){
            if(id[i] == id[p]){
                id[i] = target;
            }
        }
        count--;
    }

    @Override
    public int find(int p) {
        return id[p];
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return this.count;
    }
}
