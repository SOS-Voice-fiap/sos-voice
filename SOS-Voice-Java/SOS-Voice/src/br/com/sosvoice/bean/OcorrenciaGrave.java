package br.com.sosvoice.bean;

public class OcorrenciaGrave extends Ocorrencia {

    private String recomendacao;

    public OcorrenciaGrave(String tipo, String local, String nivelUrgencia, String recomendacao) {
        super(tipo, local, nivelUrgencia);
        this.recomendacao = recomendacao;
    }

    public String getRecomendacao() {
        return recomendacao;
    }

    public void setRecomendacao(String recomendacao) {
        this.recomendacao = recomendacao;
    }

    @Override
    public void exibirResumo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return super.toString() + "\nRecomendações: " + recomendacao;
    }
}
