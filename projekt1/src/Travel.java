import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Travel {
    private LocalDateTime startTime;
    private int duration;
    private City startCity;
    private City endCity;
    protected int seats;
    protected int occupiedSeats;

    public Travel(LocalDateTime startTime, int duration, City startCity, City endCity, int seats, int occupiedSeats) {
        this.startTime = startTime;
        this.duration = duration;
        this.startCity = startCity;
        this.endCity = endCity;
        this.seats = seats;
        this.occupiedSeats = occupiedSeats;
    }

    @Override
    public String toString() {

        ZonedDateTime endTimeStartCity =ZonedDateTime.of( startTime.plusMinutes(duration),startCity.getTimeZone());
        ZonedDateTime endTimeEndCity=endTimeStartCity.withZoneSameInstant(endCity.getTimeZone());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return String.format("""
                START CITY:\t%s\tDATE AND TIME: %s
                END CITY:\t%s\t DATE AND TIME: %s %s
                SEATS: %d/%d""",
                startCity.getName(), startTime.format(formatter), endCity.getName(), endTimeEndCity.format(formatter),
                startCity.isTheSameTime(endCity) ? "" : "(" + startCity.getName() + " " + endTimeStartCity.format(formatter) + ")", occupiedSeats, seats);
    }

    public boolean isNational()
    {
        return startCity.isTheSameCountry(endCity);
    }
    public boolean doesChangeDate()
    {
        ZonedDateTime startTimeStartCity =ZonedDateTime.of( startTime,startCity.getTimeZone());
        ZonedDateTime endTimeEndCity=startTimeStartCity.plusMinutes(duration).withZoneSameInstant(endCity.getTimeZone());
        return !startTimeStartCity.toLocalDate().equals(endTimeEndCity.toLocalDate());
    }
    public String getTravelStatus()
    {
        LocalDateTime endTime=startTime.plusMinutes(duration);

        if(startTime.isBefore(LocalDateTime.now()) && endTime.isBefore(LocalDateTime.now()) )
        {
            return "*************"+TravelStatus.COMPLETED.getStatus()+"*************";
        }
        else if(startTime.isBefore(LocalDateTime.now()) && endTime.isAfter(LocalDateTime.now())){
            return "*************"+TravelStatus.IN_PROGRESS.getStatus()+"*************";
        }
        else
        {
             return "*************"+TravelStatus.NOT_STARTED.getStatus()+"*************";
        }
    }
}//do poprawy


