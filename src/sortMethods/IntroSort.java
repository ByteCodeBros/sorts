package sortMethods;

// Java implementation of Introsort algorithm

import java.util.Arrays;
import java.util.Comparator;

public class IntroSort <T extends Comparable<T>>{
    boolean guidance;
    long comparisons = 0L;
    long movimentations = 0L;

    public IntroSort(boolean guidance) {
        this.guidance = guidance;
    }

    // funcao swap
    private void swap(T[] A, int i, int j) {
        T temp = A[i];
        A[i] = A[j];
        A[j] = temp;
        movimentations+=3;
    }

    // Para construir um Maxheapify numa subarvore. N é o tamanho do heap
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
        } comparisons++;
    }

    // Para construir um Minheapify numa subarvore. N é o tamanho do heap
    private void MinHeapify(T[] A, int i, int N, Comparator<? super T> cmp) {
        int least; // Initialize least as root
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
        } comparisons++;
    }

    private void BuildHeap(T[] A,int b , int N, Comparator<? super T> cmp) {
        // Construir heap (rearranjar vetor)
        for (int i = N / 2; i >= b; i--) {
            if(this.guidance) {
                MaxHeapify(A, i, N, cmp);
            } else // Ordem decrescente
                MinHeapify(A, i, N, cmp);
            comparisons++;
        }
    }

    public void heapSort(T[] A, int b, int N, Comparator<? super T> cmp) {
        BuildHeap(A, b, N, cmp);

        // extrai elemento do heap Um a Um
        for (int i = N; i >= b+1; i--) {
            // Troca A[0] com A[i]
            swap(A,b,i);
            if(this.guidance) {
                // Chama maxHeapify na heap reduzida (i-1)
                MaxHeapify(A, b, i - 1, cmp);
            }else // Ordem decrescente
                // Chama minHeapify na heap reduzida (i-1)
                MinHeapify(A, b, i - 1, cmp);
            comparisons++;
        }
    }

    // function that implements insertion sort
    public void insertionSort(T[] A, Comparator<? super T> cmp) {
        int i, j;
        T key;

        for (j = 1; j < A.length; j++) {

            key = A[j];
            movimentations++;

            i = j - 1;
            // Move os elementos do vetor[0..i-1], que sao
            // maiores que a chave, para a posicao seguinte
            // as suas respectivas posicoes
            if (this.guidance) { // Ascending order
                while (i >= 0 && cmp.compare(A[i],key) > 0 ) {
                    comparisons+=2;
                    A[i + 1] = A[i];
                    movimentations++;
                    i--;
                }
            } else { // Ordem decrescente
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
    }

    // Funcao para achar a mediana de tres elementos e escolhe-lo como pivo
    private int findPivot(T[] A, int a1, int b1, int c1, Comparator<? super T> cmp) {
        if ((cmp.compare(A[a1],A[b1]) >= 0 && cmp.compare(A[a1],A[c1]) <= 0) ||
                (cmp.compare(A[a1],A[c1]) >= 0 && cmp.compare(A[a1],A[b1]) <= 0)) {
            comparisons+=4;
            return a1;
        }else if ((cmp.compare(A[b1],A[a1]) >= 0 && cmp.compare(A[b1],A[c1]) <= 0) ||
                (cmp.compare(A[b1],A[c1]) >= 0 && cmp.compare(A[b1],A[a1]) <= 0)) {
            comparisons+=8;
            return b1;
        }
        comparisons+=8;
        return c1;
    }

    // Escolhe o último elemento como pivo e
    // to coloca na posicao correta, além de
    // posicionar os elementos menores que o pivo a
    // esquerda e os maiores a direita (na ord. ascendente
    // e o inverso na decrescente)
    private int partition(T[] A, int begin, int end,int pivotPos, Comparator<? super T> cmp){
        T pivot = A[pivotPos];
        movimentations++;
        int b = begin + 1;
        int e = end;

        if(this.guidance){
            while(b <= e) {
                if (cmp.compare(A[b],pivot) <= 0) {
                    b++;
                }else if (cmp.compare(pivot,A[e]) < 0) {
                    comparisons++;
                    e--;
                }else {
                    comparisons++;
                    swap(A, b, e);
                    b++;
                    e--;
                }comparisons++;
            }
        } else{ // Ordem decrescente
            while(b <= e){
                if(cmp.compare(A[b],pivot) >= 0) {
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
        }
        A[begin] = A[e];
        A[e] = pivot;
        movimentations+=2;
        comparisons++;
        return e;
    }

    // The main function that implements Introsort
    // low  --> Starting index,
    // high  --> Ending index,
    // depthLimit  --> level de recursao
    private void sortDataUtil(T[] A, int begin, int N, int depthLimit, Comparator<? super T> cmp) {
        while(N - begin > 16) {
            if (depthLimit == 0) {
                this.heapSort(A, begin, N, cmp);
                return;
            }comparisons++;
            depthLimit -=1;
            int pivotPos = findPivot(A, begin, begin + ((N - begin) / 2) + 1, N, cmp);

            // p e o indice de particao,
            int p = partition(A, begin, N, pivotPos, cmp);

            // separa os elementos ordenados antes e apos particao
            sortDataUtil(A, p, N, depthLimit, cmp);
            N = p;

        }
    }

    public void sort(T[] A, int n, Comparator<? super T> cmp) {

        // Inicializa o depthLimit
        // como 2*log(length(data))
        int depthLimit = (int)(2 * Math.floor(Math.log(n)/Math.log(2)));
        this.sortDataUtil(A, 0, n - 1, depthLimit, cmp);
        this.insertionSort(A, cmp);
    }
    public long getMovimentations(){
        return this.movimentations;
    }

    public long getComparisons(){
        return this.comparisons;
    }
}
