import exceptions.NoFreeSeatsException;
import interfaces.Reservable;

import java.time.LocalDateTime;

public class NormalFlight extends AirTravel implements Reservable {
    public NormalFlight(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, planeNumber);
    }

    @Override
    public String toString() {
        return "Normal flight: \n" +
                super.toString();
    }
    @Override
    public void reserve(int numberOfSeats) throws NoFreeSeatsException {
        if (numberOfSeats + occupiedSeats > seats) {
            throw new NoFreeSeatsException("No available seats to reserve.");
        }
        occupiedSeats+=numberOfSeats;
    }
}
