package lab03.Voos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VoosMain {

    Gestor manager = new Gestor();

    public static void main(String[] args) throws FileNotFoundException {
        VoosMain menu = new VoosMain();
        if (args.length == 0) {            
            menu.opcoes("");
        }
        else if (args.length == 1 && args[0].contains(".txt")) {
            readFile(args[0]);
        }
        else {
            System.out.println("Erro! Tem de ser um ficheiro .txt.");
        }
    }

    public boolean opcoes(String line) {
        Scanner sc = new Scanner(System.in);
        boolean ret = true;
        String[] input = line.split(" ");

        if (line.equals("")) {
            System.out.println("Escolha uma opção: (H para ajuda)");
            input = sc.nextLine().split(" ");
        }

        switch(input[0]){
        
            case "H":
                printHelp();
                break;
                
            case "I":
                if(input.length == 2){  // verificar se há input depois do I   
                    if (!input[1].contains(".txt")){
                        System.err.println(" Tem de ser um ficheiro .txt");
                    }

                    String filename = input[1];
                    printFlightInfo(filename);

                } else { System.out.println("[ERRO] I <filename> (exemplo: 'I flight1.txt')");}
                break;

            case "M":
                if(input.length == 2){  // verificar se há input depois do M   
                    if (!validFlightCode(input[1])){
                        System.err.println("O Codigo de voo tem de ser no formato: AA0000");
                    }

                    String flight_code = input[1];
                    manager.printReservation(flight_code);

                } else { System.out.println("[ERRO] M <flight_code> (exemplo: 'M TP1920')");}
                break;

            case "F":

                String[] num_lugares_tourist = input[2].split("x"); 
                int t_linhas = 0; int t_colunas = 0; int e_linhas = 0; int e_colunas = 0;

                String f_error = "[ERRO] F <flight_code> <num_lugares_executive> <num_lugares_tourist> (exemplo: 'F TP1930 5x3 12x4') (<num_lugares_executive> e opcional)";
                
                if (input.length == 3){
                    if (validFlightCode(input[1]) && input[2].matches("[0-9]+x[0-9]+")){
                        
                        String flight_code = input[1];
                        t_linhas = Integer.parseInt(num_lugares_tourist[0]); 
                        t_colunas = Integer.parseInt(num_lugares_tourist[1]);
                        manager.addFlight(flight_code, t_linhas, t_colunas);

                    } else { System.out.println(f_error);}

                } else if (input.length == 4){
                    if (validFlightCode(input[1]) && input[2].matches("[0-9]+x[0-9]+") && input[3].matches("[0-9]+x[0-9]+")){
                        String flight_code = input[1];

                        String[] num_lugares_executive = input[2].split("x"); 
                        e_linhas = Integer.parseInt(num_lugares_executive[0]); 
                        e_colunas = Integer.parseInt(num_lugares_executive[1]);
                        
                        num_lugares_tourist = input[3].split("x"); 
                        t_linhas = Integer.parseInt(num_lugares_tourist[0]); 
                        t_colunas = Integer.parseInt(num_lugares_tourist[1]);
                        
            
                        manager.addFlight(flight_code, e_linhas, e_colunas, t_linhas, t_colunas);
                        
                    } else { System.out.println(f_error);}

                } else { System.out.println(f_error);}
                break;

            case "R":

                String r_error = "[ERRO] R <flight_code> <class> <numero_lugares> (exemplo: 'R TP1930 T 3')";
                if(input.length  == 4){
                    if (!validFlightCode(input[1]) || !input[2].matches("T|E") || !isInt(input[3])){
                        System.out.println(r_error); 
                    }

                    String flight_code = input[1];
                    char cl = input[2].charAt(0);
                    int numero_lugares = Integer.parseInt(input[3]);
                    manager.reserveLugares(flight_code, cl, numero_lugares);

                } else { System.out.println(r_error);}
                break;

            case "C":

                String c_error = "C <reservation_code> (flight_code:sequential_reservation_numero) (exemplo: 'C TP1920:2')";
                if (input.length == 2){
        
                    String[] reservation_code = input[1].split(":");

                    if (!validFlightCode(reservation_code[0]) || !isInt(reservation_code[1])){
                        System.out.println(c_error);
                    }

                    String flight_code = reservation_code[0];
                    int reservation_numero = Integer.parseInt(reservation_code[1]);

                    manager.cancelReservation(flight_code, reservation_numero);

                } else {System.out.println(c_error);}
                break;
            case "Q":
                System.out.println("Bye!");
                ret = false;
                break;
            default:
                System.out.println("Opção invalida!");
        }
        if (ret) {
            System.out.println("Escolha uma opção: (H para ajuda)");
            opcoes(sc.nextLine());
        }

        sc.close();
        return ret;
    }


    private static void printHelp(){
        System.out.println("I filename -> Ler ficheiro e apresentar informação sobre o voo");
        System.out.println("M fligthcode -> Exibir mapa das reservas do voo");
        System.out.println(
                "F flight_code num_lugares_executive num_lugares_tourist -> Acrescentar um novo voo com código, lugares em executiva e lugares em turística");
        System.out.println(
                "R fligthcode class num_lugares -> Acrescentar uma nova reserva a um voo com indicação do código de voo, da classe e do número de lugares");
        System.out.println("C reservation_code -> Cancelar uma reserva");
        System.out.println("Q-> Terminar programa");
    }

    private static boolean validFlightCode(String code){
        boolean ret = false;
    
        String pattern = "[A-Z]{2}[0-9]{4}";
        if (code.matches(pattern)){
            ret = true;
        }

        return ret;
    }

    // verifica se o argumento é inteiro
    private static boolean isInt(String str) {
        boolean ret = false;
        
        try {
            int x = Integer.parseInt(str);
            return true; 

        } catch (NumberFormatException e) { ret = false; }

      return ret;
        
    }

    public static void readFile(String fname) throws FileNotFoundException {

        VoosMain menu = new VoosMain();

        File f = new File(fname);
        Scanner sc = new Scanner(f);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            menu.opcoes(line);
        }

        sc.close();
    }
      
    // print da opção I <filename>
    private static void printFlightInfo(String fname){

        String str = "";
        String[] word = {};
    
        try {
            File file = new File(fname);
            Scanner sc = new Scanner(file);
    
            int numero_e_lugares = 0;
            int numero_t_lugares = 0;
    
            while (sc.hasNextLine()) {
                word = sc.nextLine().split(" ");
    
                String flight_code = word[0].replace(">","");
    
                if (validFlightCode(flight_code) && word.length == 3){
                    
                    str+="Código de voo " + flight_code + ". Lugares disponíveis: ";
                
                    String[] e_lugares = word[1].split("x");
                    String[] t_lugares = word[2].split("x");
                
                    if (isInt(e_lugares[0]) && isInt(e_lugares[1]) && isInt(t_lugares[0]) && isInt(t_lugares[1])){
                        numero_e_lugares = Integer.parseInt(e_lugares[0]) * Integer.parseInt(e_lugares[1]);
                        str += numero_e_lugares + " lugares em classe Executiva; ";
                        numero_t_lugares = Integer.parseInt(t_lugares[0]) * Integer.parseInt(t_lugares[1]);
                        str += numero_t_lugares + " lugares em classe Turística.\n";
                    }
    
    
                } else if (validFlightCode(flight_code) && word.length == 2){
                    
                    str +="Código de voo " + flight_code + ". Lugares disponíveis: ";
                    
                    String[] t_lugares = word[1].split("x");
    
                    if (isInt(t_lugares[0]) && isInt(t_lugares[1])){
                        numero_t_lugares = Integer.parseInt(t_lugares[0]) * Integer.parseInt(t_lugares[1]);
                        str += numero_t_lugares + " lugares em classe Turística.\nClasse executiva não disponível neste voo.\n";
                    }
                
                } else if (word.length == 2 && (word[0].charAt(0)  == 'T') || (word[0].charAt(0)  == 'E')){
                    if (word[0].charAt(0)  == 'T'){
    
                        if (isInt(word[1])){
                            int seat_taken_t = Integer.parseInt(word[1]);
                            if (numero_t_lugares >= seat_taken_t){
                                numero_t_lugares -= seat_taken_t;
                            } else { str += "Não foi possível obter lugares para a reserva: " + word[0] + " " + word[1]; }
                        }
    
                    } else if (word[0].charAt(0) == 'E'){
                        if (isInt(word[1])){
                            int seat_taken_e = Integer.parseInt(word[1]);
                            if (numero_e_lugares >= seat_taken_e){
                                numero_e_lugares -= seat_taken_e;
                            } else { str += "Não foi possível obter lugares para a reserva: " + word[0] + " " + word[1]; }
                        }
                    }
     
                } else {; System.exit(0); }
            }
    
            System.out.println(str + "\n");
            sc.close();
            
        } catch (FileNotFoundException e) {
            System.err.println("[ERRO] O Ficheiro nao existe!");
            System.exit(0);
        }
    }
}         