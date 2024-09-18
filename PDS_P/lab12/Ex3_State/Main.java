package lab12.Ex3_State;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Livro> livros = new ArrayList<>();
        livros.add(new Livro("Java Anti-Stress", "1234567890", 2024, "Omodionah"));
        livros.add(new Livro("A Guerra dos Padrões", "0987654321", 2024, "Jorge Omel"));
        livros.add(new Livro("A Procura da Luz", "1029384756", 2024, "Khumatkli"));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("*** Biblioteca ***");
            for (int i = 0; i < livros.size(); i++) {
                Livro livro = livros.get(i);
                System.out.println((i + 1) + " " + livro.getTitulo() + " " + livro.getAutor() + " [" + livro.getEstado().getClass().getSimpleName() + "]");
            }
            System.out.println(">> <livro>, <operação: (1)regista; (2)requisita; (3)devolve; (4)reserva; (5)cancela");
            String[] input = scanner.nextLine().split(",");
            int livroIndex = Integer.parseInt(input[0].trim()) - 1;
            int operacao = Integer.parseInt(input[1].trim());

            Livro livro = livros.get(livroIndex);
            switch (operacao) {
                case 1:
                    livro.regista();
                    break;
                case 2:
                    livro.requisita();
                    break;
                case 3:
                    livro.devolve();
                    break;
                case 4:
                    livro.reserva();
                    break;
                case 5:
                    livro.cancelaReserva();
                    break;
                default:
                    System.out.println("Operação não disponível.");
            }
        }
    }
}
