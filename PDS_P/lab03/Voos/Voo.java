package lab03.Voos;

import java.util.HashMap;

public class Voo {
    private String flight_code;
    private Aviao aviao;
    private int [][] mapa_executiva;
    private int [][] mapa_turistica;
    private HashMap<Integer, Reserva> reservations = new HashMap<Integer, Reserva>();
    private int reservation_number;
    private int lugares_turistica;
    private int lugares_executiva;

    public Voo(String code, Aviao aviao) {
        this.flight_code = code;
        this.aviao = aviao;
        this.reservation_number = 1;

        this.lugares_executiva = this.aviao.getLugaresExecutiva();
        this.lugares_turistica = this.aviao.getLugaresTuristica();

        this.mapa_executiva = new int[this.aviao.getExLinhas()][this.aviao.getExColunas()];
        this.mapa_turistica = new int[this.aviao.getTuLinhas()][this.aviao.getTuColunas()];
    }

    public Aviao getPlane() {
        return this.aviao;
    }

    public int getTouristicDispLugares() {
        return this.lugares_turistica;
    }

    public int getExecutiveDispLugares() {
        return this.lugares_executiva;
    }

    public Reserva reserveT(int n_lugares) {
        int total_lugares = n_lugares;
        String[] lugares = new String[n_lugares];
    
        int n_linhas = this.aviao.getTuLinhas();
        int n_colunas = this.aviao.getTuColunas();
    
        for (int row = 0; row < n_linhas; row++) { 
            int col;
            for (col = 0; col < n_colunas && this.mapa_turistica[row][col] == 0; col++);
    
            if (col == n_colunas) {
                if (col >= n_lugares) {
                    for (int j = 0; j < n_lugares; j++) {
                        lugares[total_lugares-n_lugares+j] = (row+1+this.aviao.getExLinhas()) + " " + String.valueOf((char)(65 + j));                        
                        this.mapa_turistica[row][j] = this.reservation_number;
                    }
    
                    this.reservation_number++;
                    this.lugares_turistica -= total_lugares;
    
                    Reserva r = new Reserva('T', this.reservation_number - 1, total_lugares, lugares);
                    this.reservations.put(this.reservation_number-1, r);
                    return r;
                }
                else {
                    int c = 0;
                    for (int j = total_lugares - n_lugares; j < total_lugares && c < n_colunas; j++, c++) {
                        lugares[total_lugares-n_lugares+c] = (row+1+this.aviao.getExLinhas()) + " " + String.valueOf((char)(65 + c));
                        this.mapa_turistica[row][c] = this.reservation_number;
                    }
    
                    n_lugares = n_lugares - c;
    
                    if (n_lugares == 0) {
                        this.reservation_number++;
                        this.lugares_turistica -= total_lugares;
    
                        Reserva r = new Reserva('T', this.reservation_number - 1, total_lugares, lugares);
                        this.reservations.put(this.reservation_number-1, r);
                        return r;
                    }
                }
            }
        }
    
        for (int row = 0; row < n_linhas; row++) {
            int c = 0;
            for (int col = 0; col < n_colunas; col++) {
                if (this.mapa_turistica[row][col] == 0) {
                    c++;
                }
            }
    
            if (c >= n_lugares) {
                int x = 0;
                for (int j = 0; j < n_colunas && x < n_lugares; j++) {
                    if (this.mapa_turistica[row][j] == 0) {
                        lugares[(total_lugares + x) - n_lugares] = (row+1+this.aviao.getExLinhas()) + " " + String.valueOf((char)(65 + j));
                        this.mapa_turistica[row][j] = this.reservation_number;
                        x++;
                    }
                }
    
                this.reservation_number++;
                this.lugares_turistica -= total_lugares;
    
                Reserva r = new Reserva('T', this.reservation_number - 1, total_lugares, lugares);
                this.reservations.put(this.reservation_number-1, r);
                return r;
            }
            else {
                int x = 0;
                for (int j = total_lugares - n_lugares, k = 0; j < n_colunas && k < n_lugares; j++, k++) {
                    if (this.mapa_turistica[row][k] == 0) {
                        lugares[(total_lugares + x) - n_lugares] = (row+1+this.aviao.getExLinhas()) + " " + String.valueOf((char)(65 + j));
                        this.mapa_turistica[row][k] = this.reservation_number;
                        x++;
                    }
                }
    
                n_lugares = n_lugares - x;
                if (n_lugares == 0) {
                    this.reservation_number++;
                    this.lugares_turistica -= total_lugares;
    
                    Reserva r = new Reserva('T', this.reservation_number - 1, total_lugares, lugares);
                    this.reservations.put(this.reservation_number-1, r);
                    return r;
                }
            }
        }
        
        return null;
    }

    public Reserva reserveE(int n_lugares) {
        int total_lugares = n_lugares;
        String[] lugares = new String[n_lugares];
    
        int n_linhas = this.aviao.getExLinhas();
        int n_colunas = this.aviao.getExColunas();
    
        for (int row = 0; row < n_linhas; row++) { 
            int col;
            for (col = 0; col < n_colunas && this.mapa_executiva[row][col] == 0; col++);
    
            if (col == n_colunas) {
                if (col >= n_lugares) {
                    for (int j = 0; j < n_lugares; j++) {
                        lugares[total_lugares-n_lugares+j] = (row+1) + " " + String.valueOf((char)(65 + j));                        
                        this.mapa_executiva[row][j] = this.reservation_number;
                    }
    
                    this.reservation_number++;
                    this.lugares_executiva -= total_lugares;
    
                    Reserva r = new Reserva('E', this.reservation_number - 1, total_lugares, lugares);
                    this.reservations.put(this.reservation_number-1, r);
                    return r;
                }
                else {
                    int c = 0;
                    for (int j = total_lugares - n_lugares; j < total_lugares && c < n_colunas; j++, c++) {
                        lugares[total_lugares-n_lugares+c] = (row+1) + " " + String.valueOf((char)(65 + c));
                        this.mapa_executiva[row][c] = this.reservation_number;
                    }
    
                    n_lugares = n_lugares - c;
    
                    if (n_lugares == 0) {
                        this.reservation_number++;
                        this.lugares_executiva -= total_lugares;
    
                        Reserva r = new Reserva('E', this.reservation_number - 1, total_lugares, lugares);
                        this.reservations.put(this.reservation_number-1, r);
                        return r;
                    }
                }
            }
        }
    
        for (int row = 0; row < n_linhas; row++) {
            int c = 0;
            for (int col = 0; col < n_colunas; col++) {
                if (this.mapa_executiva[row][col] == 0) {
                    c++;
                }
            }
    
            if (c >= n_lugares) {
                int x = 0;
                for (int j = 0; j < n_colunas && x < n_lugares; j++) {
                    if (this.mapa_executiva[row][j] == 0) {
                        lugares[(total_lugares + x) - n_lugares] = (row+1) + " " + String.valueOf((char)(65 + j));
                        this.mapa_executiva[row][j] = this.reservation_number;
                        x++;
                    }
                }
    
                this.reservation_number++;
                this.lugares_executiva -= total_lugares;
    
                Reserva r = new Reserva('E', this.reservation_number - 1, total_lugares, lugares);
                this.reservations.put(this.reservation_number-1, r);
                return r;
            }
            else {
                int x = 0;
                for (int j = total_lugares - n_lugares, k = 0; j < n_colunas && k < n_lugares; j++, k++) {
                    if (this.mapa_executiva[row][k] == 0) {
                        lugares[(total_lugares + x) - n_lugares] = (row+1) + " " + String.valueOf((char)(65 + j));
                        this.mapa_executiva[row][k] = this.reservation_number;
                        x++;
                    }
                }
    
                n_lugares = n_lugares - x;
    
                if (n_lugares == 0) {
                    this.reservation_number++;
                    this.lugares_executiva -= total_lugares;
    
                    Reserva r = new Reserva('E', this.reservation_number - 1, total_lugares, lugares);
                    this.reservations.put(this.reservation_number-1, r);
                    return r;
                }
            }
        }
        
        return null;
    }
    
    public boolean cancelRes(int r_number) {
        if (this.reservations.containsKey(r_number)) {
            Reserva r = this.reservations.get(r_number);
            String [] s = r.getLugares();
    
            if (r.getClass_code() == 'T') {
                this.lugares_turistica += r.getN_Lugares();
                for (int i = 0; i < s.length; i++) {
                    String [] seat = s[i].split(" ");
                    int row = Integer.parseInt(seat[0]) - this.aviao.getExLinhas() - 1;
                    int col = (int) seat[1].charAt(0) - 65;
    
                    this.mapa_turistica[row][col] = 0;
                }
            }
            else if (r.getClass_code() == 'E') {
                this.lugares_executiva += r.getN_Lugares();
                for (int i = 0; i < s.length; i++) {
                    String [] seat = s[i].split(" ");
                    int row = Integer.parseInt(seat[0]) - 1;
                    int col = (int) seat[1].charAt(0) - 65;
    
                    this.mapa_executiva[row][col] = 0;
                }
            }
            else {
                return false;
            }
    
            this.reservations.remove(r_number);
            return true;
        }
        return false;
    }

    public void printRes() {
        Aviao p = this.getPlane();
        int total_linhas = p.getExLinhas() + p.getTuLinhas();
        int total_colunas = (p.getExColunas() > p.getTuColunas()) ? p.getExColunas() : p.getTuColunas();

        String msg = String.format("%2s ", " ");
        for (int i = 1; i <= total_linhas; i++) {
            msg += String.format("%2d ", i);
        }

        msg += '\n';

        for (int col = 0; col < total_colunas; col++) {
            msg += String.format("%2s ", String.valueOf((char)(65 + col)));

            if (col < p.getExColunas()){
                for (int lin = 0; lin < p.getExLinhas(); lin++) {
                    msg += String.format("%2d ", this.mapa_executiva[lin][col]);
                }
            }
            else {
                for (int lin = 0; lin < p.getExLinhas(); lin++) {
                    msg += String.format("%2s ", " ");
                }
            }

            if (col < p.getTuColunas()) {
                for (int lin = 0; lin < p.getTuLinhas(); lin++) {
                    msg += String.format("%2d ", this.mapa_turistica[lin][col]);
                }
            }

            msg += '\n';
        }

        System.out.println(msg);
    }

    @Override
    public String toString() {
        return "Flight : {" +
            " flight_code='" + this.flight_code + "'" +
            " aviao='" + this.aviao.toString() + "'" +
            ", lugares_turistica='" + this.lugares_turistica + "'" +
            ", lugares_executiva='" + this.lugares_executiva + "'" +
            "}";
    }

}
