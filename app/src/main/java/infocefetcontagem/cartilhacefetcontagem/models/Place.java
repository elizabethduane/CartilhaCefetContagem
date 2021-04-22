package infocefetcontagem.cartilhacefetcontagem.models;

public class Place {

    private String numeroSala;
    private String descricao;

    public Place(String numeroSala, String descricao) {
        this.numeroSala = numeroSala;
        this.descricao = descricao;
    }


    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
