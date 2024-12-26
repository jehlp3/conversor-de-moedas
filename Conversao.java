import com.google.gson.annotations.SerializedName;

public class Conversao {
    @SerializedName("base_code")
    private String moedaDeReferencia;
    @SerializedName("conversion_result")
    private Double resultadoConversao;
    @SerializedName("target_code")
    private String moedaParaConversao;
    @SerializedName("conversion_rate")
    private Double taxaDeConversao;

    public Double getResultadoConversao() {
        return resultadoConversao;
    }
    public Double getTaxaDeConversao() {
        return taxaDeConversao;
    }
    public Double valorOriginal(){
        return resultadoConversao / taxaDeConversao;
    }
    public Conversao(String moedaDeReferencia, Double resultadoConversao) {
        this.moedaDeReferencia = moedaDeReferencia;
        this.resultadoConversao = resultadoConversao;
    }

    @Override
    public String toString() {
        return "O valor de " + String.format("%.2f", valorOriginal())+" "+moedaDeReferencia +
                " equivale a " + String.format("%.2f", resultadoConversao) + " " + moedaParaConversao +"." +
                "\n***********************************************************************";
    }
}