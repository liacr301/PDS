package lab12.Ex3_State;

public class Inventário implements EstadoLivro{

    public void regista(Livro livro) {
        livro.setEstado(new Disponível());
    }

    public void requisita(Livro livro) {
        // Não é possível requisitar um livro no inventário
    }

    public void reserva(Livro livro) {
        // Não é possível reservar um livro no inventário
    }

    public void cancelaReserva(Livro livro) {
        // Não é possível cancelar a reserva de um livro no inventário
    }

    public void devolve(Livro livro) {
        // Não é possível devolver um livro no inventário
    }
}
