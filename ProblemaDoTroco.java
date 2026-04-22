import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemaDoTroco {

    public static void main(String[] args) {
        int[] moedasDisponiveis = {100, 25, 10, 5, 1};
        int valorTroco = 289;

        System.out.println("Calculando troco para: " + valorTroco + " centavos");
        List<Integer> resultado = encontrarTrocoGuloso(moedasDisponiveis, valorTroco);

        System.out.println("Moedas utilizadas: " + resultado);
        System.out.println("Total de moedas: " + resultado.size());
    }

    public static List<Integer> encontrarTrocoGuloso(int[] moedas, int valor) {
        List<Integer> trocoResultante = new ArrayList<>();
        int iteracoes = 0;
        Arrays.sort(moedas);
        int[] moedasOrdenadas = inverterArray(moedas);
        int valorRestante = valor;

        for (int moeda : moedasOrdenadas) {
            iteracoes++; 

            while (valorRestante >= moeda) {
                iteracoes++; 
                trocoResultante.add(moeda);
                valorRestante -= moeda;
            }
        }

        System.out.println("Número total de iterações: " + iteracoes);
        return trocoResultante;
    }

    private static int[] inverterArray(int[] array) {
        int[] novoArray = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            novoArray[i] = array[array.length - 1 - i];
        }
        return novoArray;
    }
}