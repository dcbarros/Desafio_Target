import java.util.Random;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Double> faturamentoDiario = Arrays.asList(carregarVetor());
        Double faturamentoMaximo = Collections.max(faturamentoDiario);
        Double faturamentoMinimo = Collections.min(faturamentoDiario);
        Integer diasSuperiorAMedia = diasAcimaFaturamentoMedio(faturamentoDiario);


        System.out.printf("O maior faturamento do ano foi: R$ %.2f\nO menor faturamento do ano foi: R$ %.2f\nO número de dias que o faturamento superou a média anual foi: %d",
        faturamentoMaximo,faturamentoMinimo,diasSuperiorAMedia); 
    }

    private static Double[] carregarVetor(){
        Random rand = new Random();
        Double[] faturamentoDiario = new Double[365];
        for (int i = 0; i < faturamentoDiario.length; i++) {
            faturamentoDiario[i] = rand.nextBoolean() ? rand.nextDouble(0, 100000) : 0.0;
        }
        return faturamentoDiario;
    }

    public static Double mediaFaturamento(List<Double> faturamento){
        Double soma = 0.0;
        Integer cont = 0;
        for (Double valor : faturamento) {
            if(!valor.equals(0.0)){
                soma += valor;
                cont++;
            }
        }
        return cont > 0 ? soma / cont : 0.0;
    }

    public static Integer diasAcimaFaturamentoMedio(List<Double> faturamento){
        Integer cont = 0;
        Double media = mediaFaturamento(faturamento);
        for (Double valor : faturamento) {
            if(valor > media){
                cont++;
            }
        }
        return cont;
    }
    
}
