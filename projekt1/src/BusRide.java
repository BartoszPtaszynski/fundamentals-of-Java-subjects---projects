import exceptions.NoFreeSeatsException;
import interfaces.Reservable;

import java.time.LocalDateTime;

public class BusRide extends RoadTravel implements Reservable {
    public BusRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String registrationNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, registrationNumber);
    }

    @Override
    public String toString() {
        return "Bus ride:\n"+super.toString();
    }
    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats + occupiedSeats > seats) {
            throw new NoFreeSeatsException("No available seats to reserve.");
        }
        occupiedSeats += numberOfSeats;
    }
}
