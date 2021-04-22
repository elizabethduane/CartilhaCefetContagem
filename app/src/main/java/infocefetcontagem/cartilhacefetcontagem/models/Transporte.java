package infocefetcontagem.cartilhacefetcontagem.models;

public class Transporte {

    private String linha;
    private String descricao;
    private String tarifa;
    private String linkHorario;

    public Transporte(String linha, String descricao, String tarifa, String linkHorario){

        this.linha = linha;
        this.descricao = descricao;
        this.tarifa = tarifa;
        this.linkHorario = linkHorario;
    }

    public String getLinha() {
        return linha;
    }


    public String getDescricao() {
        return descricao;
    }

    public String getTarifa() {
        return tarifa;
    }

    public String getLinkHorario() {
        return linkHorario;
    }


    @Override
    public String toString() {
        return linha +" " +descricao+" " +tarifa + ""+ linkHorario+"\n";
    }
}
