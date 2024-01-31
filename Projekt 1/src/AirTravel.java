import java.time.LocalDateTime;

public class AirTravel extends Travel {
    private String planeNumber;

    public AirTravel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats, String planeNumber) {
        super(startTime, duration, startCity, endCity, seats, occupiedSeats);
        this.planeNumber = planeNumber;
    }

    @Override
    public String toString() {
        return "PLANE NUMBER: "+planeNumber+"\n"+
         super.toString();
    }
}
