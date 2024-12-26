import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            Menu menu = new Menu();
            menu.opcoesDeMoedas();

            Referencias referencias = new Referencias();


            boolean opcaoValida = false;
            while (!opcaoValida) {
                System.out.print("Escolha a moeda de origem: ");
                int opcao1 = leitura.nextInt();

                if (opcao1 >= 1 && opcao1 <= 7) {
                    setReferencia(opcao1, referencias::setConverterDe);
                    opcaoValida = true;
                } else {
                    System.out.println("Digite um número válido entre 1 e 7.");
                }
            }

            System.out.println("MOEDA ORIGEM <<<<<< " + referencias.getConverterDe());



            opcaoValida = false;
            while (!opcaoValida) {
                System.out.print("Escolha a moeda de destino: ");
                int opcao2 = leitura.nextInt();
                if (opcao2 >= 1 && opcao2 <= 7) {
                    setReferencia(opcao2, referencias::setConverterPara);
                    opcaoValida = true;
                    System.out.println("MOEDA DESTINO >>>>> " + referencias.getConverterPara());

                } else {
                    System.out.println("Digite um número válido entre 1 e 7.");
                }
            }

            boolean valorValido = false;
            while (!valorValido) {
                System.out.print("Digite o valor em " + referencias.getConverterDe() + " para converter em "
                        + referencias.getConverterPara() + ": ");
                try {
                    String valor = leitura.next().replace(',', '.');
                    referencias.setQuantia(Double.parseDouble(valor));
                    valorValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Digite um valor válido.");
                }
            }

            ApiConversao.Moeda(referencias);

            System.out.print("Deseja realizar outra conversão? (s): ");
            String resposta = leitura.next();
            continuar = resposta.equalsIgnoreCase("s");
        }

        System.out.println("Obrigado por usar o conversor de moedas!");
    }

    private static void setReferencia(int opcao, java.util.function.Consumer<String> setter) {
        switch (opcao) {
            case 1 -> setter.accept("USD");
            case 2 -> setter.accept("EUR");
            case 3 -> setter.accept("BRL");
            case 4 -> setter.accept("GBP");
            case 5 -> setter.accept("JPY");
            case 6 -> setter.accept("ARS");
            case 7 -> setter.accept("CLP");
        }
    }
}
