package sortMethods;

import java.util.Comparator;

public class HeapSort <T extends Comparable<T>>{
    boolean guidance;
    long comparisons = 0L;
    long movimentations = 0L;

    public HeapSort(boolean guidance){
        this.guidance = guidance;
    }

    public void sort(T[] A, int N, Comparator<? super T> cmp) {
        BuildHeap(A, N, cmp);
        // Extrai elemento do heap Um a Um
        for (int i = N; i >= 1; i--) {
            // Troca A[0] com A[i]
            swap(A,0,i);

            if(this.guidance) {

                // chama max heapify no heap reduzido
                MaxHeapify(A, 0, i - 1, cmp);
            }else
                // chama min heapify no heap reduzido
                MinHeapify(A, 0, i - 1, cmp);
            comparisons++;
        }
    }

    private void BuildHeap(T[] A, int N, Comparator<? super T> cmp) {
        // Montar heap (rearranjar a array)
        for (int i = N / 2; i >= 0; i--) {
            if(this.guidance) {
                MaxHeapify(A, i, N, cmp);
            } else
                MinHeapify(A, i, N, cmp);
            comparisons++;
        }
    }

    // Para construir um Maxheapify numa subarvore. n é o tamanho do heap
    private void MaxHeapify(T[] A, int i, int N, Comparator<? super T> cmp) {
        int largest;
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // Se o filho esquerdo for maior que a raiz
        if (l <= N && cmp.compare(A[l],A[i]) > 0 )
            largest = l;
        else
            largest = i;
        comparisons+=2;

        // Se o filho direito for maior que a maior até o momento (largest)
        if (r <= N && cmp.compare(A[r],A[largest]) > 0 )
            largest = r;
        comparisons+=2;

        // Se o maior (largest) não for a raiz
        if (largest != i) {
            swap(A,i,largest);
            // Chama recursivamente na árvore reduzida
            MaxHeapify(A, largest, N, cmp);
        }
        comparisons++;
    }

    // Para construir um Maxheapify numa subarvore. n é o tamanho do heap
    private void MinHeapify(T[] A, int i, int N, Comparator<? super T> cmp) {
        int least;
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // Se o filho esquerdo for maior que a raiz
        if (l <= N && cmp.compare(A[l],A[i]) < 0 )
            least = l;
        else
            least = i;
        comparisons+=2;

        // Se o filho direito for maior que a maior até o momento (largest)
        if (r <= N && cmp.compare(A[r],A[least]) < 0 )
            least = r;
        comparisons+=2;

        // Se o maior (largest) não for a raiz
        if (least != i) {
            swap(A,i,least);
            // Chama recursivamente na árvore reduzida
            MinHeapify(A, least, N, cmp);
        }
        comparisons++;
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
