package lab03.Voos;

public class Reserva {
    private char class_code;
    private int res_number;
    private int n_lugares;
    private String[] lugares;

    public Reserva(char class_code, int res_number, int n_lugares, String[] lugares) {
        this.class_code = class_code;
        this.res_number = res_number;
        this.n_lugares = n_lugares;
        this.lugares = lugares;
    }

    public Reserva(char class_code) {
        this.class_code = class_code;
    }

    public int getNumber() {
        return this.res_number;
    }

    public String lugaresToString() {
        String ret = "";
        for (int i = 0; i < this.n_lugares; i++) {
            ret += this.lugares[i];

            if (i + 1 < this.n_lugares) {
                ret += " | ";
            }
        }
        return ret;
    }

    /**
     * @return char return the class_code
     */
    public char getClass_code() {
        return class_code;
    }

    /**
     * @return int return the res_number
     */
    public int getRes_number() {
        return res_number;
    }

    /**
     * @return int return the n_lugares
     */
    public int getN_Lugares() {
        return n_lugares;
    }

    public String[] getLugares() {
        return this.lugares;
    }

}
