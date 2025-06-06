package br.com.sosvoice.bean;

public class LocalRisco {

    private String nomeLocal;
    private boolean riscoAlto;

    public LocalRisco(String nomeLocal, boolean riscoAlto) {
        this.nomeLocal = nomeLocal;
        this.riscoAlto = riscoAlto;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public boolean isRiscoAlto() {
        return riscoAlto;
    }

    public void setRiscoAlto(boolean riscoAlto) {
        this.riscoAlto = riscoAlto;
    }

    public void mostrarStatus() {
        System.out.println(toString());
    }

    public void mostrarStatus(String prefixo) {
        System.out.println(prefixo + ": " + toString());
    }

    @Override
    public String toString() {
        return "Local: " + nomeLocal + " [Risco Alto: " + riscoAlto + "]";
    }
}
