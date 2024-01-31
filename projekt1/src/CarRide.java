import exceptions.NoFreeSeatsException;
import interfaces.Rentable;
import interfaces.Reservable;

import java.time.LocalDateTime;

public class CarRide extends RoadTravel  implements Reservable, Rentable {
    private String hirerName=null;

    public CarRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber, String hirerName) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
        this.hirerName = hirerName;

    }

    public CarRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
    }

    @Override
    public String toString() {
        return "car ride: \n"+super.toString()+"\nHIRER:"+hirerName;
    }

    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats + occupiedSeats > seats) {
            throw new NoFreeSeatsException("No available seats to reserve.");
        }

        occupiedSeats+=numberOfSeats;
    }

    @Override
    public void rent(String name) {
        hirerName=name;
    }
}
