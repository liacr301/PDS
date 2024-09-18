package lab12.Ex3_State;

public class Livro {
    private EstadoLivro estado;
    private String titulo;
    private String ISBN;
    private int ano;
    private String autor;

    public Livro(String titulo, String ISBN, int ano, String autor) {
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.ano = ano;
        this.autor = autor;
        this.estado = new Inventário();
    }

    public EstadoLivro getEstado() {
        return estado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String iSBN) {
        ISBN = iSBN;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public void regista() {
        estado.regista(this);
    }

    public void requisita() {
        estado.requisita(this);
    }

    public void reserva() {
        estado.reserva(this);
    }

    public void cancelaReserva() {
        estado.cancelaReserva(this);
    }

    public void devolve() {
        estado.devolve(this);
    }
}