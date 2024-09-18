package lab12.Ex3_State;

public class Emprestado implements EstadoLivro {
    public void regista(Livro livro) {
        // Não é possível registrar um livro emprestado
    }

    public void requisita(Livro livro) {
        // Não é possível requisitar um livro emprestado
    }

    public void reserva(Livro livro) {
        // Não é possível reservar um livro emprestado
    }

    public void cancelaReserva(Livro livro) {
        // Não é possível cancelar a reserva de um livro emprestado
    }

    public void devolve(Livro livro) {
        livro.setEstado(new Disponível());
    }
}