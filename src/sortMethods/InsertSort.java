package sortMethods;

import java.util.Comparator;

public class InsertSort <T extends Comparable<T>>{
    boolean guidance = true;
    long comparisons = 0L;
    long movimentations = 0L;

    public InsertSort(boolean guidance) {
        this.guidance = guidance;
    }

    public T[] sort(T[] A, Comparator<? super T> cmp) {
        int i, j;
        T key;

        for (j = 1; j < A.length; j++) {

            key = A[j];
            movimentations++;

            i = j - 1;

            if (this.guidance) {
                while (i >= 0 && cmp.compare(A[i],key) > 0 ) {
                    comparisons+=2;
                    A[i + 1] = A[i];
                    movimentations++;
                    i--;
                }
            } else {
                while (i >= 0 && cmp.compare(A[i],key) < 0 ) {
                    comparisons+=2;
                    A[i + 1] = A[i];
                    movimentations++;
                    i--;
                }
            } comparisons++;

            A[i + 1] = key;
            movimentations++;
        }
        return A;
    }

    public long getMovimentations(){
        return this.movimentations;
    }

    public long getComparisons(){
        return this.comparisons;
    }
}
