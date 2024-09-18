package lab12.Ex3_State;

public interface EstadoLivro {
    void regista(Livro livro);
    void requisita(Livro livro);
    void reserva(Livro livro);
    void cancelaReserva(Livro livro);
    void devolve(Livro livro);
}