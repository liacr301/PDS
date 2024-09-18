package lab04.gp409.lab03.FlightsPackage;

import java.io.File;
import java.util.Scanner;


public class VMain {
    public static void main(String args[]) {
		File Commands=checkEntranceArgs(args);
        boolean Stop=false;
        Scanner sc = new Scanner(System.in);
        FlightsManager manager = new FlightsManager();

        if(Commands!=null){
            try {
                Scanner file = new Scanner(Commands);
                while (file.hasNextLine() && !Stop) {
                    String input = file.nextLine();
                    Stop=menu(input, manager);
                }
                file.close();
            } catch (Exception e) {
                System.err.println("Erro na leitura do ficheiro!");
                System.exit(1);
            }

        }
        else{
            while (!Stop) {
                System.out.println("Escolha uma opcao: (H para ajuda)");
                String input = sc.nextLine();
                Stop=menu(input, manager);
            }
            
        }
        sc.close();
	}


    
    public static void checkArgsNum(int numArgs, String[] args){
        if (args.length != numArgs+1) {
                System.err.println("Numero invalido de argumentos!");
                System.exit(1);     
        }
    }



    public static void printHelp(){
        System.out.println("Comandos disponiveis:");
        System.out.println("I <Ficheiro>: Inicializa um voo com os dados do ficheiro");
        System.out.println("M <Codigo_Voo>: Mostra a informacao sobre as reservas de um voo");
        System.out.println("F <Codigo_Voo> <LugaresExecutivos(opcional)> <LugaresTuristas>: Adiciona um voo");
        System.out.println("R <Codigo_Voo> <Classe(T/E)> <Lugares>: Faz uma reserva num voo");
        System.out.println("C <Codigo_Reserva>: Cancela uma reserva");
        System.out.println("H: Mostra esta ajuda");
        System.out.println("Q: Termina o programa\n");
    }

    public static boolean menu(String command, FlightsManager manager){
        String[] op = command.split(" ");
        switch (op[0].trim().toUpperCase()) {
            case "I" -> {
                checkArgsNum(1, op);
                manager.fileReader(op[1]);
            }
            case "M" -> {
                checkArgsNum(1, op);
                manager.checkReservations(op[1]);
            }
            case "F" -> {
                String executiveSeats = null,touristSeats = null;

                if (op.length == 3) {
                    //flight without executive seats
                    executiveSeats = "0x0";
                    touristSeats = op[2];

                } else {
                    checkArgsNum(3, op);
                    executiveSeats = op[2];
                    touristSeats = op[3];
                }
                manager.addFlight(op[1], executiveSeats, touristSeats);
            }
            case "R" -> {
                checkArgsNum(3, op);
                try {
                    ClassType type = null;
                    switch (op[2]) {
                        case "T" -> {
                            type = ClassType.T;
                        }
                        case "E" -> {
                            type = ClassType.E;
                        }
                        default -> {
                            System.out.println("Classe invalida!");
                            break;
                        }
                    }
                    if (type != null) {
                        boolean result = manager.makeReservation(op[1], type, Integer.parseInt(op[3]));
                        if (!result) {
                            System.out.println("Nao foi possivel fazer a reserva!");
                        }
                    }

                } catch (Exception e) {
                    System.out.println("Numero de lugares invalido!");
                }
            }
            case "C" -> {
                checkArgsNum(1, op);
                String[] partsop = op[1].split(":");
                if (partsop.length != 2) {
                    System.out.println("Codigo de reserva invalido!");
                    break;
                }
                String flightCode = partsop[0];
                String reservationCode = partsop[1];

                manager.cancelReservation(flightCode, reservationCode);
            }
            case "H" -> printHelp();
            case "Q" -> {
                return true;
            }
            default -> System.out.println("Comando invalido!");
        }
                return false;
    }


    public static File checkEntranceArgs(String[] args){
        if(args.length > 1){
            System.err.println("Usage: java VMain <CommandFile(Optional)>");
            System.exit(1);
        }
        if(args.length == 1){
            try{
                File file = new File(args[0]);
                if(!file.exists()){
                    System.err.println("Ficheiro não encontrado!");
                    System.exit(1);
                }
                return file;
            }catch(Exception e){
                System.err.println("Erro na leitura do ficheiro!");
                System.exit(1);
            }
        }
        return null;
    }

}
