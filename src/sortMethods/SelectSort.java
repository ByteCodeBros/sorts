package sortMethods;

import java.util.Comparator;

public class SelectSort <T extends Comparable<T>>{
    boolean guidance = true;
    long comparisons = 0L;
    long movimentations = 0L;

    public SelectSort(boolean guidance) {
        this.guidance = guidance;
    }

    public T[] sort(T[] A, Comparator<? super T> cmp) {
        for (int i = 0; i < A.length - 1; i++) {
            int elect = i;
            for (int j = i + 1; j < A.length; j++)
                if (this.guidance) {
                    if (cmp.compare(A[j],A[elect]) < 0)
                        elect = j;
                    comparisons++;
                } else {
                    if (cmp.compare(A[j],A[elect]) > 0)
                        elect = j;
                    comparisons++;
                }comparisons++;

            // Realiza a troca
            T temp = A[elect];
            A[elect] = A[i];
            A[i] = temp;
            movimentations+=3;
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