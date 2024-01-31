import exceptions.NoFreeSeatsException;
import interfaces.Reservable;

import java.time.LocalDateTime;

public class TrainRide extends RailwayTravel implements Reservable {
    public TrainRide(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats, trainNumber);
    }

    @Override
    public String toString() {
        return "Train ride:\n"+super.toString();
    }
    @Override
    public void reserve(int numberOfSeats)throws NoFreeSeatsException {
        if (numberOfSeats + occupiedSeats > seats) {
            throw new NoFreeSeatsException("No available seats to reserve.");
        }
        occupiedSeats+=numberOfSeats;
    }
}
