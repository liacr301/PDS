package lab04.gp409.lab03.FlightsPackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reservation{
    public static int reservationNum=0;
    private int reservationId=0;
    private Flight flight;
    private int numberPassegers;
    private ClassType typeOfReservation;
    private Map<Character,ArrayList<Integer>> seats;
    
    public Reservation(Flight flight, int numberPassegers, ClassType typeOfReservation) {
        Reservation.reservationNum++;
        this.reservationId=reservationNum;
        this.flight = flight;
        this.numberPassegers = numberPassegers;
        this.typeOfReservation = typeOfReservation;
        this.seats = new HashMap<>();
    }
    public Flight getFlight() {
        return flight;
    }
    public int getReservationId() {
        return reservationId;
    }
    public void addSeat(Character row, int seat) {
        if (seats.containsKey(row)) {
            seats.get(row).add(seat);
        } else {
            ArrayList<Integer> newSeat = new ArrayList<Integer>();
            newSeat.add(seat);
            seats.put(row, newSeat);
        }
    }
    public ClassType typeOfReservation() {
        return typeOfReservation;
    }
    public Map<Character,ArrayList<Integer>> getSeats() {
        return seats;
    }

    public void printSeats() {
        StringBuilder sb = new StringBuilder();
        String fr = String.format("%s:%d", this.getFlight().getFlightNumber(), this.getReservationId());
        sb.append( fr + " = ");
        for (Map.Entry<Character,ArrayList<Integer>> entry : seats.entrySet()) {
            Character key = entry.getKey();
            ArrayList<Integer> value = entry.getValue();
            for (Integer i : value) {
                sb.append( String.format("%d%c | ",i+1,key));
            }
        }
        sb.append("\n");
        System.out.println(sb);
    }
}