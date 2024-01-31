import java.time.LocalDateTime;

public class RailwayTravel extends Travel {
    private String trainNumber;

    public RailwayTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String trainNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.trainNumber = trainNumber;
    }

    @Override
    public String toString() {
        return "TRAIN NUMBER: "+trainNumber+"\n"+super.toString();
    }
}
