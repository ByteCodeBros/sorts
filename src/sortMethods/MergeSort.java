package sortMethods;

import entities.GenericArray;

import java.util.Comparator;

public class MergeSort <T extends Comparable<T>>{
    boolean guidance;
    long comparisons = 0L;
    long movimentations = 0L;

    public MergeSort(boolean guidance) {
        this.guidance = guidance;
    }

    public T[] sort(T[] A, Comparator<? super T> cmp) {
        GenericArray<T> temp = new GenericArray<>( A.length);
        return MergeMain(A, temp, 0, A.length-1,cmp);
    }

    private T[] MergeMain(T[] A, GenericArray<T> Temp, int left, int right, Comparator<? super T> cmp) {
        int middle;

        if(left < right){
            middle = (left + right)/2;
            MergeMain(A, Temp, left, middle, cmp);
            MergeMain(A, Temp, middle+1, right, cmp);
            Merge(A, Temp, left, middle+1, right, cmp);
        } comparisons++;
        return A;
    }

    private void Merge(T[] A, GenericArray<T> Temp, int leftPos, int rightPos, int rightEnd, Comparator<? super T> cmp){
        int leftEnd = rightPos - 1;
        int tempPos = leftPos;
        int numElem = rightEnd - leftPos + 1;

        if (this.guidance) {
            while(leftPos <= leftEnd && rightPos <= rightEnd){
                if(cmp.compare(A[leftPos],A[rightPos]) <= 0)
                    Temp.set(tempPos++,A[leftPos++]);
                else
                    Temp.set(tempPos++,A[rightPos++]);
                movimentations++;
                comparisons++;
            }
        } else{
            while(leftPos <= leftEnd && rightPos <= rightEnd){
                if(cmp.compare(A[leftPos],A[rightPos]) >= 0)
                    Temp.set(tempPos++,A[leftPos++]);
                else
                    Temp.set(tempPos++,A[rightPos++]);
                movimentations++;
                comparisons++;
            }
        } comparisons++;

        //Copia o resto da primeira parte
        while(leftPos <= leftEnd) {
            Temp.set(tempPos++, A[leftPos++]);
            movimentations++;
        }

        //Copia o resto da primeira parte
        while(rightPos <= rightEnd) {
            Temp.set(tempPos++, A[rightPos++]);
            movimentations++;
        }

        //Copia o vetor
        for(int i = 0; i < numElem; i++, rightEnd--) {
            A[rightEnd] = Temp.get(rightEnd);
            movimentations++;
        }
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getMovimentations() {
        return movimentations;
    }
}