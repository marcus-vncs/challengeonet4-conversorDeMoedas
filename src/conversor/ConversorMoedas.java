package conversor;
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class ConversorMoedas {
    public static void main(String[] args) {
        // Exibe o menu de opções
        Moeda[] opcoes = {
                new Moeda("Dólar", "USD $", 4.89),
                new Moeda("Euro", "EUR €", 5.39),
                new Moeda("Libra esterlina", "GPB £", 6.30),
                new Moeda("Iene", "JPY ¥", 0.034),
                new Moeda("Won sul-coreano", "KRW ₩", 0.0037),
                new Moeda("Peso argentino", "ARS $", 0.0186),
                new Moeda("Peso chileno", "CLP $", 0.0060)
        };
        Moeda escolha;

        do {
            escolha = (Moeda) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Conversor de Moedas", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

            if (escolha != null) {
                converterMoeda(escolha);
            }
        } while (escolha != null && continuarPrograma()); 
    }

    public static void converterMoeda(Moeda moeda) {
        String[] opcoes = {"Reais para " + moeda.getNome(), moeda.getNome() + " para Reais"};
        String escolha = (String) JOptionPane.showInputDialog(null, "Escolha uma opção:", "Conversor de Moedas", JOptionPane.PLAIN_MESSAGE, null, opcoes, opcoes[0]);

        if (escolha != null) {
            if (escolha.equals("Reais para " + moeda.getNome())) {
                double valorReal = obterValorNumerico("Digite o valor em Reais:");
                double valorMoeda = valorReal / moeda.getTaxaCambio();
                String valorMoedaFormatado = formatarNumero(valorMoeda);
                JOptionPane.showMessageDialog(null, "O valor em " + moeda.getNome() + " é: " + moeda.getSimbolo() + valorMoedaFormatado);
            } else if (escolha.equals(moeda.getNome() + " para Reais")) {
                double valorMoedaInverso = obterValorNumerico("Digite o valor em " + moeda.getNome() + ":");
                double valorRealInverso = valorMoedaInverso * moeda.getTaxaCambio();
                String valorMoedaFormatado = formatarNumero(valorRealInverso);
                JOptionPane.showMessageDialog(null, "O valor em Reais é: " + "BRL R$" + valorMoedaFormatado);
            }
        }
    }

    public static double obterValorNumerico(String mensagem) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensagem);
            if (input == null) {
                // Caso o usuário cancele a entrada, retorna 0
                return 0.0;
            }
            try {
                double valor = Double.parseDouble(input);
                return valor;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Valor inválido! Aceita apenas valores númericos e/ou apenas '. (ponto)' para separar casas decimais"
                		+ " por exemplo: '0.00' "
                		, "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    public static String formatarNumero(double numero) {
        DecimalFormat df = new DecimalFormat("#.##"); // Define a formatação para duas casas decimais
        return df.format(numero);
    }
    
    public static boolean continuarPrograma() {
        int resposta = JOptionPane.showConfirmDialog(null, "Deseja continuar no programa?", "Continuar", JOptionPane.YES_NO_CANCEL_OPTION);
        if (resposta == JOptionPane.YES_OPTION) {
            return true;
        } else if (resposta == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Programa finalizado");
            return false;
        } else {
            JOptionPane.showMessageDialog(null, "Programa concluído");
            System.exit(0);
            return false;
        }
    }
    
}