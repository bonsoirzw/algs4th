package chapter1;

import api.chapter1.UF;

public class WeightedQuickUnionUF implements UF {

    private int [] id;
    private int [] weight;
    private int size;

    public WeightedQuickUnionUF(int N) {
        this.size = N;
        this.id = new int[N];
        this.id = new int[N];
        for (int i = 0; i < N; i++){
            id[i] = i;
            weight[i] = 1;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = find(p),qRoot = find(q);
        if(pRoot == qRoot) return;
        if(weight[p] > weight[q]){
            id[q] = pRoot;
            weight[p] += weight[q];
        }else{
            id[p] = qRoot;
            weight[q] += weight[p];
        }
        size--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return 0;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(q) == find(p);
    }

    @Override
    public int count() {
        return size;
    }
}
