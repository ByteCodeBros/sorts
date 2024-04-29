package view;
import java.util.Scanner;
import service.Gerenciador;

public class Main {
    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        Scanner input = new Scanner(System.in);
        boolean loopMain = true;

        System.out.println("Bem-Vindo(a) ao Menu de Estrutura de Dados");
        while(loopMain) {
            System.out.println("Selecione uma opção a seguir:\n"+
                    " 1-SelectionSort\n" +
                    " 2-InsertionSort\n" +
                    " 3-QuickSort\n" +
                    " 4-HeapSort\n" +
                    " 5-MergeSort\n" +
                    " 6-IntrospectiveSort\n" +
                    " 7-TreeSort\n" +
                    " 8-java.util.Arrays.sort()\n" +
                    " 9-java.util.Collections.sort()\n" +
                    " 10-Sair");

            int userInput = input.nextInt();

            switch (userInput) {
                case 1 -> gerenciador.selectSortMain();
                case 2 -> gerenciador.insertSortMain();
                case 3 -> gerenciador.quickSortMain();
                case 4 -> gerenciador.heapSortMain();
                case 5 -> gerenciador.mergeSortMain();
                case 6 -> gerenciador.introSortMain();
                case 7 -> gerenciador.treeSortMain();
                case 8 -> gerenciador.arraysSortMain();
                case 9 -> gerenciador.collectionsSortMain();
                case 10 -> loopMain = false;

                default -> System.out.println("Insira um valor válido\n");
            }
        }
    }
}