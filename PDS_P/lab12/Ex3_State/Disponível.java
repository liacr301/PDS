package lab12.Ex3_State;

public class Disponível implements EstadoLivro {
    public void regista(Livro livro) {
        // Não é possível registrar um livro disponível
    }

    public void requisita(Livro livro) {
        livro.setEstado(new Emprestado());
    }

    public void reserva(Livro livro) {
        livro.setEstado(new Reservado());
    }

    public void cancelaReserva(Livro livro) {
        // Não é possível cancelar a reserva de um livro disponível
    }

    public void devolve(Livro livro) {
        // Não é possível devolver um livro disponível
    }
}