package chapter1;

import api.chapter1.UF;

public class QuickUnionUF implements UF {

    private int [] id;

    private int count;

    public QuickUnionUF(int N) {
        this.count = N;
        this.id = new int[N];
        for (int i = 0;i < N; i++) {
            this.id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pRoot = id[p],qRoot = id[q];
        if(pRoot == qRoot) return;
        id[p] = qRoot;
        count--;
    }

    @Override
    public int find(int p) {
        while (p != id[p]){
            p = id[p];
        }
        return p;
    }

    @Override
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int count() {
        return count;
    }
}
