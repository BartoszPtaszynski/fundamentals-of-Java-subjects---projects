import interfaces.Rentable;

import java.time.LocalDateTime;

public class GovernmentFlight extends AirTravel implements Rentable {
    private String hirerName=null;

    public GovernmentFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);

    }

    public GovernmentFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber, String hirerName) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
        this.hirerName = hirerName;
    }

    @Override
    public String toString() {
        return "Government Flight:\n"+super.toString()+"\nHIRER: "+(hirerName == null ?"null":hirerName);
    }
    @Override
    public void rent(String name) {
        hirerName=name;
    }
}
