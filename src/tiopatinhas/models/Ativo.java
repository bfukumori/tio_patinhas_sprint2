public class Ativo {
    int idAtivo;
    String nome;
    float valor;

    public Ativo(int idAtivo, String nome, float valor){
        this.idAtivo = idAtivo;
        this.nome = nome;
        this.valor = valor;
    }

    public int getIdAtivo(){
        return idAtivo;
    }

    public String getNome(){
        return nome;
    }

    public float getValor(){
        return valor;
    }

    public void setIdAtivo(int idAtivo){
        this.idAtivo = idAtivo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

}
