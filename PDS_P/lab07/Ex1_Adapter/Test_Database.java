package lab07.Ex1_Adapter;

import java.util.List;

public class Test_Database {
    public static void main(String[] args) {
        Registos registos = new Registos();

        Adapter adapter = new Adapter(registos);

        Employee e1 = new Employee("Sousa", 1, 4500);
        Employee e2 = new Employee("Cardoso", 2, 350);
        Employee e3 = new Employee( "Amaral", 3, 465); 

        Empregado emp4 = new Empregado("João", "Sousa", 5, 2000);
        Empregado emp5 = new Empregado("Lia", "Cardoso", 6, 5450);
        Empregado emp6 = new Empregado("Joana", "Amaral", 7, 565);
        
        adapter.addEmployee(e1);
        adapter.addEmployee(e2);
        adapter.addEmployee(e3);
        adapter.addEmployee(emp4);
        adapter.addEmployee(emp5);
        adapter.addEmployee(emp6);

        if(adapter.isEmployee(3)){
            System.out.println("O codigo nº3 corresponde a um empregado");
        } else {
            System.out.println("Não existe um empregado com o codigo nº3");
        }

        Employee[] todosEmpregados = adapter.getAllEmployees();
        if (todosEmpregados.length == 6) {
            System.out.println("Existem 6 empregados! A função funciona corretamente");
        } else {
            System.out.println("Erro: o número de empregados é diferente de 6");
        }

        adapter.deleteEmployee(3);
        adapter.deleteEmployee(6);

        Employee[] todosEmpregados2 = adapter.getAllEmployees();
        if (todosEmpregados2.length == 4 && !adapter.isEmployee(3) && !adapter.isEmployee(6)){
            System.out.println("Existem 4 empregados! A função funciona corretamente");
        } else {
            System.out.println("Erro: o número de empregados é diferente de 4");
        }

    }
}
