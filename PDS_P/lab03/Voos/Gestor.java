package lab03.Voos;

import java.util.HashMap;

public class Gestor {
    private HashMap<String, Voo> flights = new HashMap<String, Voo>();

    public Gestor() {

    }

    public void addFlight(String f_code, int t_linhas, int t_colunas) {
        Aviao p = new Aviao(t_linhas, t_colunas);
        Voo f = new Voo(f_code, p);

        flights.put(f_code, f);
        if (flights.get(f_code)!= null) {
            System.out.println("Flight " + f_code + " added with success");
        }
        else {
            System.out.println("Error while creating flight");
        }
    }

    public void addFlight(String f_code, int ex_linhas, int ex_colunas, int t_linhas, int t_colunas) {
        Aviao p = new Aviao(ex_linhas, ex_colunas, t_linhas, t_colunas);
        Voo f = new Voo(f_code, p);

        flights.put(f_code, f);
        if (flights.get(f_code)!= null) {
            System.out.println("Flight " + f_code + " created successfully");
        }
        else {
            System.out.println("Error while creating flight");
        }
    }

    public Voo getFlight(String f_code) {
        if (flights.containsKey(f_code)) {
            return flights.get(f_code);
        }
        return null;
    }

    public boolean reserveLugares(String f_code, char class_code, int n_lugares) {
        
        Voo f = this.getFlight(f_code);
        int ex_lugares = f.getPlane().getLugaresExecutiva();

        if (f != null) {            

            if (class_code == 'T') {
                if (n_lugares <= f.getTouristicDispLugares()) {
                    Reserva res = f.reserveT(n_lugares);
                    if (res != null) {
                        System.out.println(f_code + ":" + res.getNumber() + " = " + res.lugaresToString());
                    }
                    else {
                        System.out.println("An error ocurred while trying to make your reservation");
                    }
                }
                else {
                    System.out.println("Touristic class does not have " + n_lugares + " available. " + f.getTouristicDispLugares() + " available.");
                    return false;
                }

            }
            else if (class_code == 'E') {

                if (ex_lugares != 0){
                    if (n_lugares <= f.getExecutiveDispLugares()) {
                        Reserva res = f.reserveE(n_lugares);
                        if (res != null) {
                            System.out.println(f_code + ":" + res.getNumber() + " = " + res.lugaresToString());
                        }
                        else {
                            System.out.println("An error ocurred while trying to make your reservation");
                        }
                    }
                    else {
                        System.out.println("Executive class does not have " + n_lugares + " available. " + f.getExecutiveDispLugares() + " available.");
                        return false;
                    }
                } else {
                    System.out.println("This is flight doesn't have an Executive class");
                    return false;
                }

            }
            else {
                System.out.println("The class character must be a E for executive or a T for touristic.");
                return false;
            }
        }        
        else {
            System.out.println("The flight code you entered does not exist.");
            return false;
        }

        return false;
    }

    public void cancelReservation(String f_code, int r_number) {

        Voo f = this.getFlight(f_code);

        if (f != null) {
            if (f.cancelRes(r_number)){
                System.out.println(f_code + ":" + r_number + " deleted with success.");
            }
            else {
                System.out.println("Error while canceling your reservation. Maybe reservation " + r_number + " does not exist.");
            }
        }
        else{
            System.out.println("The flight code you entered does not exist.");
        }
    }

    public void printReservation(String f_code) {
        Voo f = this.getFlight(f_code);

        if (f != null) {
            f.printRes();
        }
        else {
            System.out.println("The flight code you entered does not exist.");
        }
    }
}
