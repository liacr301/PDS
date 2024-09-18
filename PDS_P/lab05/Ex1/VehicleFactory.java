package lab05.Ex1;

public class VehicleFactory {

    public static Veiculo createMotociclo(String matricula, String marca, String modelo, int cilindrada, String tipoCarta) {
        return new Motociclo(matricula, marca, modelo, cilindrada, tipoCarta);
    }

    public static Veiculo createAutomovelLigeiro(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidade_bagageira) {
        return new AutomovelLigeiro(matricula, marca, modelo, potencia, numQuadro, capacidade_bagageira);
    }

    public static Veiculo createTaxi(String matricula, String marca, String modelo, int potencia, String numQuadro, int capacidade_bagageira, String licenca) {
        return new Taxi(matricula, marca, modelo, potencia, numQuadro, capacidade_bagageira, licenca);
    }

    public static Veiculo createPPEletrico(String matricula, String marca, String modelo, int potencia, int peso, String numQuadro, int max_passageiros, int autonomia_restante,int autonomia_max) {
        return new PesadoPassEletrico(matricula, marca, modelo, potencia, peso, numQuadro, max_passageiros, autonomia_restante,autonomia_max);
    }
    public static Veiculo createALEletrico(String matricula, String marca, String modelo, int cilindrada, String numQuadro, int capacidade_bagageira, int autonomia_restante,int autonomia_max) {
        return new AutomovelLigeiroEletrico(matricula, marca, modelo, cilindrada, numQuadro, capacidade_bagageira, autonomia_restante, autonomia_max);
    }

    public static Veiculo createPesadoMercadorias(String matricula, String marca, String modelo, int cilindrada, String numQuadro, int capCarga, int capMax) {
        return new PesadoMercadorias(matricula, marca, modelo, cilindrada, numQuadro, capCarga, capMax);
    }

    public static Veiculo createPesadoPassageiros(String matricula, String marca, String modelo, int cilindrada, int peso, String numQuadro, int passmax) {
        return new PesadoPassageiros(matricula, marca, modelo, cilindrada, peso, numQuadro, passmax);
    }
}
