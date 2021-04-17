package chapter3;

import java.util.*;
import java.util.stream.IntStream;

public class BST<K extends Comparable<K>, V>  {

    private Node root;

    public V get(K key){
        return get(root,key);
    }

    private V get(Node node,K key) {
        if(node == null) return null;
        int cmp = key.compareTo(node.key);
        if(cmp == 0) return node.value;
        else if(cmp > 0) return get(node.right,key);
        else return get(node.left,key);
    }

    /**
     * 如果K存在以Node x 为根节点的子树中就更新，否则就将<K,V>键值对插入到该子树中
     * @param x Node
     * @param key K
     * @param value V
     * @return Node
     */
    private Node put(Node x,K key,V value){
        if(x == null) return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if(cmp == 0) x.value = value;
        else if(cmp > 0) x.right = put(x.right,key,value);
        else x.left = put(x.left,key,value);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    private Node min(Node x){
        if(x == null) return null;
        if(x.left == null) return x;
        return min(x.left);
    }

    public K min(){
        return min(root).key;

    }

    public void put(K key,V value){
        root = put(root,key,value);
    }

    private Node floor(Node x,K k){
        if(x == null) return null;
        int cmp = k.compareTo(x.key);
        if(cmp == 0) return x;
        else if(cmp < 0) return floor(x.left,k);
        Node tmp = floor(x.right,k);
        return tmp == null ? x : tmp;
    }

    public K floor(K k){
        Node t = floor(root,k);
        return t == null ? null : t.key;
    }

    private Node select(Node x,int k){
        if(x == null) return null;
        int size = size(x.left);
        if(size == k) return x;
        else if(k > size) return select(x.right,k -size - 1);
        else return select(x.left,k);
    }

    public Node select(int k){
        return select(root,k);
    }

    private int rank(K key,Node x){
        if(x == null) return 0;
        int cmp = key.compareTo(x.key);
        if(cmp == 0) return size(x.left) + 1;
        else if(cmp < 0) return rank(key,x.left);
        else return size(x.left) + 1 + rank(key,x.right);
    }

    public int rank(K key){
        return rank(key,root);
    }

    private Node deleteMin(Node x){
        if(x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    public void deleteMin(){
        deleteMin(root);
    }

    private Node delete(Node x,K key){
        if(x == null) return null;
        int cmp = key.compareTo(x.key);
        if(cmp > 0) x.right = delete(x.right,key);
        else if(cmp < 0) x.left = delete(x.left,key);
        else{
            if(x.left == null) return x.right;
            if(x.right == null) return x.left;
            Node t = x;
            x = min(x.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }

        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void delete(K key){
        delete(root,key);
    }

    public int size(Node x) {
        return x == null ? 0 : 1 + size(x.left) + size(x.right);
    }

    public void levelShow(){
       if(root == null) return;
       Queue<Node> queue = new LinkedList<>();
       queue.offer(root);
       queue.offer(null);
       while (!queue.isEmpty()){
           Node curNode = queue.poll();
           if(curNode == null){
               System.out.println();
               if(queue.size() > 0) queue.offer(null);
           }else{
               System.out.print(curNode.key + " ");
               if(curNode.left != null) queue.offer(curNode.left);
               if(curNode.right != null) queue.offer(curNode.right);
           }
       }
    }


    public Iterable keys() {
        return null;
    }

    private class Node{

        K key;
        V value;
        Node left,right;
        //以该节点为更节点子树节点的数目
        int N;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public Node(K key, V value, int n) {
            this.key = key;
            this.value = value;
            N = n;
        }
    }

    public static void main(String[] args) {
        BST<Character,Integer> bst = new BST<>();
        Random random = new Random();
        IntStream.rangeClosed(0,26).mapToObj(i -> ((char)('a' + random.nextInt(25)))).forEach(c -> bst.put(c,1));
        bst.levelShow();

//        List<List> list = Collections.singletonList(bst.level());
//        list.stream().forEach(l -> {
//            l.stream().forEach(i -> System.out.print(i + " "));
//            System.out.println();
//        });
    }
}
