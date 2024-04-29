package sortMethods;

import java.util.Comparator;

// Java program to
// implement Tree Sort
public class TreeSort <T extends Comparable<T>>{
    boolean guidance;
    long comparisons = 0L;
    long movimentations = 0L;

    // Classe contendo filhos
    // direito e esquerdo e o
    // valor da chave
    class Node {
        T key;
        Node left, right;

        public Node(T item) {
            key = item;
            left = right = null;
        }
    }

    // raiz da BST
    Node root;

    public Node getRoot() {
        return root;
    }

    public TreeSort(boolean guidance) {
        this.guidance = guidance;
        root = null;
    }

    void insert(T key, Comparator<? super T> cmp) {
        root = insertRec(root, key, cmp);
    }

    /* Funcao recursiva para inserir chave na na BST */
    Node insertRec(Node root, T key, Comparator<? super T> cmp) {

		/* Se a arvore esta vazia,
		retorna um novo no */
        if (root == null){
            root = new Node(key);
            movimentations++;
            return root;
        }comparisons++;

        if(guidance) {
            if (cmp.compare(key, root.key) <= 0) {
                root.left = insertRec(root.left, key, cmp);
                movimentations++;
            }else if (cmp.compare(key, root.key) >= 0){
                root.right = insertRec(root.right, key, cmp);
                comparisons++;
                movimentations++;
            }
            comparisons++;
        }else{
            if (cmp.compare(key, root.key) >= 0) {
                root.left = insertRec(root.left, key, cmp);
                movimentations++;
            }else if (cmp.compare(key, root.key) <= 0) {
                root.right = insertRec(root.right, key, cmp);
                comparisons++;
                movimentations++;
            }
            comparisons++;
        }comparisons++;
        /* retorna a raiz */
        return root;
    }

    // Funcao para vizualizar a arvore
    public void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    public T[] treeIns(T[] A, Comparator<? super T> cmp) {
        for (T t : A) {
            insert(t, cmp);
        }
        return A;
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getMovimentations() {
        return movimentations;
    }
}
