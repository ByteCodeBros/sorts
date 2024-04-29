package service;

import entities.*;
import java.util.*;
import sortMethods.*;
import java.util.Arrays;


public class Gerenciador {
    Scanner input = new Scanner(System.in);
    Random random = new Random();

    private boolean guidanceChoice() {

        boolean guidance = true;
        boolean guidanceLoop = true;

        while (guidanceLoop) {
            System.out.println("Selecione o tipo de ordenação:\n" +
                    " 1-Crescente\n" +
                    " 2-Decrescente\n");

            int userInput = input.nextInt();

            switch (userInput) {
                case 1 -> guidanceLoop = false;
                case 2 -> {
                    guidance = false;
                    guidanceLoop = false;
                }
                default -> System.out.println("Insira um valor válido\n");
            }
        }
        return guidance;
    }

    private Comparator<Student> sortByChoice() {
        //Inicializando o comparador com função lambda
        Comparator<Student> cmp = (o1, o2) -> 0;

        while (true) {
            System.out.println("Selecione o tipo de ordenação:\n" +
                    " 1-Ordenar pelo ID\n" +
                    " 2-Ordenar pelo CR\n" +
                    " 3-Ordenar pelo Nome\n");

            int userInput = input.nextInt();

            switch (userInput) {
                case 1 -> {
                    cmp = new SortByID();
                    return cmp;}
                case 2 -> {
                    cmp = new SortByRC();
                    return cmp;
                }
                case 3 -> {
                    cmp = new SortByName();
                    return cmp;
                }
                default -> System.out.println("Insira um valor válido\n");
            }
        }
    }

    static String getRandomString() {
        String theAlphaNumericS;
        StringBuilder builder;

        theAlphaNumericS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        //create the StringBuffer
        builder = new StringBuilder(10);

        for (int m = 0; m < 10; m++) {

            // generate numeric
            int myindex
                    = (int) (theAlphaNumericS.length()
                    * Math.random());

            // add the characters
            builder.append(theAlphaNumericS
                    .charAt(myindex));
        }

        return builder.toString();
    }

    private Student[] arrayStudentGenerator(int size){
        Student[] A = new Student[size];
        for(int i = 0; i < size;i++){
            A[i] = new Student(random.nextInt(0,99999), random.nextDouble(0,10), getRandomString());
        }
        return A;
    }

    public void selectSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        SelectSort selectSort = new SelectSort(guidance);

        for(int i = 1000; i <= 1000000;){
            Student[] studentArray = arrayStudentGenerator(i);

            //System.out.printf(Arrays.toString(studentArray));
            long startTime = System.currentTimeMillis();
            selectSort.sort(studentArray,cmp);
            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println("Total de Movimentações: " + selectSort.getMovimentations() + " | Total de Comparações: "+ selectSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void insertSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            InsertSort insertSort = new InsertSort(guidance);
            Student[] studentArray = arrayStudentGenerator(i);

            //System.out.printf(Arrays.toString(studentArray));
            long startTime = System.currentTimeMillis();
            insertSort.sort(studentArray,cmp);
            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println("Total de Movimentações: " + insertSort.getMovimentations() + " | Total de Comparações: "+ insertSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void quickSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            QuickSort quickSort = new QuickSort(guidance);
            Student[] studentArray = arrayStudentGenerator(i);

            //System.out.printf(Arrays.toString(studentArray));
            long startTime = System.currentTimeMillis();
            quickSort.sort(studentArray, 0, studentArray.length-1, cmp);
            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println("Total de Movimentações: " + quickSort.getMovimentations() + " | Total de Comparações: "+ quickSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");

            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void heapSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            HeapSort heapSort = new HeapSort(guidance);
            Student[] studentArray = arrayStudentGenerator(i);

            //System.out.printf(Arrays.toString(studentArray));
            long startTime = System.currentTimeMillis();
            heapSort.sort(studentArray, studentArray.length-1, cmp);
            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println("Total de Movimentações: " + heapSort.getMovimentations() + " | Total de Comparações: "+ heapSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void mergeSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            MergeSort mergeSort = new MergeSort(guidance);
            Student[] studentArray = arrayStudentGenerator(i);

            //System.out.printf(Arrays.toString(studentArray));
            long startTime = System.currentTimeMillis();
            mergeSort.sort(studentArray,cmp);
            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println("Total de Movimentações: " + mergeSort.getMovimentations() + " | Total de Comparações: "+ mergeSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void introSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            IntroSort introSort = new IntroSort(guidance);
            Student[] studentArray = arrayStudentGenerator(i);

            long startTime = System.currentTimeMillis();
            introSort.sort(studentArray, studentArray.length-1, cmp);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Total de Movimentações: " + introSort.getMovimentations() + " | Total de Comparações: "+ introSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void treeSortMain() {
        boolean guidance = guidanceChoice();
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            TreeSort treeSort = new TreeSort(guidance);
            Student[] studentArray = arrayStudentGenerator(i);

            //treeSort.inorderRec(treeSort.getRoot());
            long startTime = System.currentTimeMillis();
            treeSort.treeIns(studentArray,cmp);
            long totalTime = System.currentTimeMillis() - startTime;

            System.out.println("Total de Movimentações: " + treeSort.getMovimentations() + " | Total de Comparações: "+ treeSort.getComparisons());
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void arraysSortMain(){
        Comparator<Student> cmp = sortByChoice();
        for(int i = 1000; i <= 1000000;){
            Student[] studentArray = arrayStudentGenerator(i);

            long startTime = System.currentTimeMillis();
            Arrays.sort(studentArray, cmp);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println(" Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }

    public void collectionsSortMain(){
        Comparator<Student> cmp = sortByChoice();

        for(int i = 1000; i <= 1000000;){
            Student[] studentArray = arrayStudentGenerator(i);

            long startTime = System.currentTimeMillis();
            Collections.sort(Arrays.asList(studentArray), cmp);
            long totalTime = System.currentTimeMillis() - startTime;
            System.out.println("Tipo de chave: " + cmp.toString() + " | Tamanho do vetor: "+i + " | Tempo decorrido: " + totalTime +"ms\n");
            if(i!= 2000 && i < 20000){
                i*=2;
            } else if (i == 2000) {
                i += 3000;
            } else if (i == 20000) {
                i += 30000;
            } else if (i == 200000){
                i+= 300000;
            } else {
                i*=2;
            }
        }
    }
}
