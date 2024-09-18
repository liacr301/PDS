package lab04.gp409.lab03.FlightsPackage;

public class Flight {
    private String flightNumber;
    private Plane plane;
    
    Flight(String flightNumber, Plane plane) {
        this.flightNumber = flightNumber;
        this.plane = plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Plane getPlane() {
        return plane;
    }

}