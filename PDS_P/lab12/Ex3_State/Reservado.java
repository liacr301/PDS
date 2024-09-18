package lab12.Ex3_State;

public class Reservado implements EstadoLivro {
    public void regista(Livro livro) {
        // Não é possível registrar um livro reservado
    }

    public void requisita(Livro livro) {
        // Não é possível requisitar um livro reservado
    }

    public void reserva(Livro livro) {
        // Não é possível reservar um livro já reservado
    }

    public void cancelaReserva(Livro livro) {
        livro.setEstado(new Disponível());
    }

    public void devolve(Livro livro) {
        // Não é possível devolver um livro reservado
    }
}
