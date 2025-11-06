package entidades;

public abstract class Participante {
    public Participante(long cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    private long cod;
	private String nome;

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public abstract String geraDescricao();

}
