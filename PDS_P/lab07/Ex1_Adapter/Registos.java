package lab07.Ex1_Adapter;

import java.util.ArrayList;
import java.util.List;

public class Registos {
    // Data elements
    private ArrayList<Empregado> empregados; // Stores the employees

    public Registos() {
        empregados = new ArrayList<>();
    }
    public void insere(Empregado emp) {
        // Code to insert employee
        empregados.add(emp);

    }
    public void remove(int codigo) {
        // Code to remove employee
        for (int n = 0; n < empregados.size(); n++){
            if (empregados.get(n).codigo() == codigo){
                empregados.remove(n);
            }
        }
    }

    public boolean isEmpregado(int codigo) {
        // Code to find employee
        for (int n = 0; n < empregados.size(); n++){
            if (empregados.get(n).codigo() == codigo){
                return true;
            }
        }

        return false;
    }

    public List<Empregado> listaDeEmpregados() {
        // Code to retrieve collection
        List<Empregado> todosEmpregados = new ArrayList<Empregado>();

        for(int n = 0; n < empregados.size(); n++){
            todosEmpregados.add(empregados.get(n));
        }

        return todosEmpregados;
    }
}