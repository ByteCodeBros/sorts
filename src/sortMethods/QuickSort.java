package sortMethods;

import java.util.Comparator;

public class QuickSort <T extends Comparable<T>>{
    boolean guidance;
    long comparisons = 0L;
    long movimentations = 0L;

    public QuickSort(boolean guidance){
        this.guidance = guidance;
    }

    public void sort(T[] A, int begin, int end, Comparator<? super T> cmp) {
        if(begin < end){
            int pivotPos = Partition(A, begin, end, cmp);

            sort(A, begin, pivotPos - 1, cmp);
            sort(A, pivotPos + 1, end, cmp);
        } comparisons++;
    }

    private int Partition(T[] A, int begin, int end, Comparator<? super T> cmp){
        T pivot = A[begin + (end - begin) / 2];
        int b = begin + 1;
        int e = end;

        if(this.guidance){
            while(b <= e) {
                // se o elemento atual é menor
                // ou maior que o pivo
                if (cmp.compare(A[b],pivot) <= 0) {
                    // incrementa o indice do menor elemento
                    b++;
                }else if (cmp.compare(pivot,A[e]) < 0) {
                    comparisons++;
                    e--;
                }else {
                    comparisons++;
                    swap(A, b, e);
                    b++;
                    e--;
                } comparisons++;
            }
        } else{
            while(b <= e){
                // se o elemento atual é menor
                // ou maior que o pivo
                if(cmp.compare(A[b],pivot) >= 0) {
                    // incrementa o indice do maior elemento
                    b++;
                }else if (cmp.compare(pivot,A[e]) > 0) {
                    comparisons++;
                    e--;
                }else{
                    comparisons++;
                    swap(A, b, e);
                    b++;
                    e--;
                } comparisons++;
            }
        } comparisons++;

        A[begin] = A[e];
        A[e] = pivot;
        movimentations+=2;
        return e;
    }

    private void swap(T[] A, int x, int y){
        T tmp;
        tmp = A[x];
        A[x] = A[y];
        A[y] = tmp;
        movimentations+=3;
    }

    public long getMovimentations(){
        return this.movimentations;
    }

    public long getComparisons(){
        return this.comparisons;
    }
}
