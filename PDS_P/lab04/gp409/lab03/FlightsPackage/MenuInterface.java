package lab04.gp409.lab03.FlightsPackage;

interface MenuInterface{
    void fileReader(String fileName);
    boolean addFlight(String flightCode, String numSeatsExecutive, String numSeatsTourist);
    boolean makeReservation(String flightCode,ClassType typeOfReservation, int numberPassengers);
    void cancelReservation(String flightCode, String reservationCode);
    void checkReservations(String flightCode);
}