package br.com.sosvoice.bean;

public class Ocorrencia {

    private String tipo;
    private String local;
    private String nivelUrgencia;

    public Ocorrencia() {
    }

    public Ocorrencia(String tipo, String local, String nivelUrgencia) {
        this.tipo = tipo;
        this.local = local;
        this.nivelUrgencia = nivelUrgencia;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getNivelUrgencia() {
        return nivelUrgencia;
    }

    public void setNivelUrgencia(String nivelUrgencia) {
        this.nivelUrgencia = nivelUrgencia;
    }

    public void exibirResumo() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Ocorrência: " + tipo + " em " + local + " [Urgência: " + nivelUrgencia + "]";
    }
}
