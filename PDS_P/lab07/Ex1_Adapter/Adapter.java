package lab07.Ex1_Adapter;

public class Adapter extends Database {
    private Registos registos;
    
    public Adapter(Registos registos) {
        super();
        this.registos = registos;
    }

    public void addEmployee(Empregado empregado) {
        registos.insere(empregado);
    }

    public void deleteEmployee(int codigo) {
        registos.remove(codigo);
    }

    public boolean isEmployee(int codigo) {
        for (Empregado empregado : registos.listaDeEmpregados()) {
            if (empregado.codigo() == codigo)
                return true;
        }
        return false;
    }

    public void ListAllEmployees() {
        for (Empregado empregado : registos.listaDeEmpregados()) {
            System.out.printf("Nome: %s ; Apelido: %s ; Código: %d ; Salário: %f\n", empregado.nome(), empregado.apelido(), empregado.codigo(), empregado.salario());
        }
    }

}
