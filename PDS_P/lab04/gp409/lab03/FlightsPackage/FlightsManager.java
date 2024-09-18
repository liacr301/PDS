package lab04.gp409.lab03.FlightsPackage;


import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class FlightsManager implements MenuInterface {
    private static ArrayList<Flight> flights;
    private static ArrayList<Reservation> reservations;
    private Flight currentFlight;

    public FlightsManager() {
        flights = new ArrayList<Flight>();
        reservations = new ArrayList<Reservation>();
    }

    @Override
    public void fileReader(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Flight flight = null;
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                if (line.charAt(0) == '>') {
                    String[] flightConfig = line.split("[>\s]");
                    String flightCode = flightConfig[1];
                    String executiveSeats = null;
                    String touristSeats = null;

                    //check if the flight has executive seats
                    if (flightConfig.length == 4) {
                        executiveSeats = flightConfig[2];
                        touristSeats = flightConfig[3];
                    } else if (flightConfig.length == 3) {
                        executiveSeats = "0x0";
                        touristSeats = flightConfig[2];
                    }

                    sb.append("Codigo de voo:"+ flightCode+ ".\n");
                    //create the flight and set the current flight to the one created to make reservations
                    if(this.addFlight(flightCode, executiveSeats, touristSeats)){
                        int availableSeatsE = this.currentFlight.getPlane().getFreeSeatsE();
                        int availableSeatsT= this.currentFlight.getPlane().getFreeSeatsT();
                        //executive class can be 0x0
                        if (availableSeatsE > 0) {
                            sb.append("Lugares executivos disponiveis: " + availableSeatsE + ".\n");
                        }
                        else {
                            sb.append("Classe executiva nao disponivel neste voo.\n");
                        }
                        sb.append("Lugares turisticos disponiveis: " + availableSeatsT + ".\n");
                    }
                    else
                    {
                        sb.append("Erro ao criar voo!\n");
                        break;
                    }
                } else if (this.currentFlight != null) {
                    // make the reservations that were already set
                    String[] lineParts = line.split("\s");
                    ClassType t = convertStringToType(lineParts[0].charAt(0));
                    int numSeats = Integer.parseInt(lineParts[1]);
                    String flightNumber = this.currentFlight.getFlightNumber();
                    //try to make the reservation
                    boolean reservationDone = this.makeReservation(flightNumber, t, numSeats);
                    if(!reservationDone)
                    {
                        sb.append("Nao foi possivel obter lugares para a reserva:"+t.toString()+" "+numSeats+"\n");
                    }
                }
            }
            System.out.println(sb);
        } catch (FileNotFoundException e) {
            System.out.println("Ficheiro nao existe!");
        } catch (NumberFormatException e) {
            System.out.println("Formato dos assentos invalido!");
        }
    }

    @Override
    public boolean addFlight(String flightCode, String numSeatsExecutive, String numSeatsTourist) {
        try {
            if(!FlightExists(flightCode)){
                this.currentFlight = new Flight(flightCode, new Plane(numSeatsTourist,numSeatsExecutive));
                return FlightsManager.flights.add(currentFlight);
            }
            else
            {
                System.out.println("Voo ja existe!");
            }
        } catch (ParseException e) {
            System.out.println("Formato dos lugares invalido!");
        }
        return false;
    }

    public Flight getFlight(String FlightCode) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(FlightCode))
                return f;
        }
        return null;
    }

    public Reservation getReservation(String reservationCode) {
        for (Reservation r : reservations) {
            if (r.getReservationId() == Integer.parseInt(reservationCode))
                return r;
        }
        return null;
    }

    @Override
    public void cancelReservation(String flightCode, String reservationCode) {
        Reservation rsv = getReservation(reservationCode);
        if(rsv!=null)
        {
            Flight flight = getFlight(flightCode);
            if(flight!=null && isReservationOnFlight(flight, rsv))
            {
                Map<Character,ArrayList<Integer>> seats = rsv.getSeats();
                for (Map.Entry<Character,ArrayList<Integer>> entry : seats.entrySet()) {
                    Character col = entry.getKey();
                    ArrayList<Integer> seat = entry.getValue();
                    for (Integer row : seat) {
                        if (flight.getPlane().removeReservationSeats(row, col, rsv.typeOfReservation())) {
                            System.out.println("Assento removido com sucesso!");
                        } else {
                            System.out.println("Assento nao encontrado!");
                        }
                    }
                }
                reservations.remove(rsv);
                System.out.println("Reserva cancelada com sucesso!");
                return;
            }
            System.out.println("Codigo de voo nao encontrado!");
        }
        System.out.println("Reserva nao encontrada!");

    }

    //check if the reservation is on the flight
    public boolean isReservationOnFlight(Flight flight, Reservation rsv) {
       for (Reservation r : reservations) {
            if (r.getFlight().equals(flight))
                return true;
        }
       return false;
    }

    //gets the flight and prints the reservation map
    @Override
    public void checkReservations(String flightCode) {
        Flight flight = getFlight(flightCode);
        if(flight!=null)
        {
            String map = flight.getPlane().getReservationMap();
            System.out.println(map);
        }
        else
        {
            System.out.println("Voo nao encontrado!");
        }
    }

    public boolean FlightExists(String flightCode) {
        for (Flight f : flights) {
            if (f.getFlightNumber().equals(flightCode))
                return true;
        }
        return false;
    }

    @Override
    public boolean makeReservation(String flightCode, ClassType typeOfReservation, int numberPassengers) {
        Flight flight = getFlight(flightCode);
        Reservation rsv = new Reservation(flight, numberPassengers, typeOfReservation);
        //try to set the seats for the reservation on the plane
        boolean validReservation = flight.getPlane().setReservationSeats(typeOfReservation, numberPassengers, rsv);
        if(validReservation)
        {
            rsv.printSeats();
           return FlightsManager.reservations.add(rsv);
        }
        return false;
    }

    private ClassType convertStringToType(Character type){
        return switch(type){
            case 'T'-> ClassType.T;
            case 'E'-> ClassType.E;
            default -> null;
        };
    }

}
