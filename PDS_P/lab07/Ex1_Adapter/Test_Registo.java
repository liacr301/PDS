package lab07.Ex1_Adapter;

import java.util.List;

public class Test_Registo {
    public static void main(String[] args) {
        Registos registos = new Registos();
        List<Empregado> todosEmpregados;
        
        Empregado emp1 = new Empregado("João", "Sousa", 1, 2000);
        Empregado emp2 = new Empregado("Lia", "Cardoso", 2, 5450);
        Empregado emp3 = new Empregado("Joana", "Amaral", 3, 1000); 

        registos.insere(emp1);
        registos.insere(emp2);
        registos.insere(emp3);

        if(registos.isEmpregado(3)){
            System.out.println("O codigo nº3 corresponde a um empregado");
        } else {
            System.out.println("Não existe um empregado com o codigo nº3");
        }

        todosEmpregados = registos.listaDeEmpregados();
        if (todosEmpregados.size() == 3) {
            System.out.println("Existem 3 empregados! A função funciona corretamente");
        } else {
            System.out.println("Erro: o número de empregados é diferente de 3");
        }

        registos.remove(2);

        if(registos.isEmpregado(2)){
            System.out.println("O código nº2 corresponde a um empregado");
        } else {
            System.out.println("Não existe um empregado com o código nº2");
        }
    }
}
