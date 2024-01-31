import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class City {
    private String name;
    private String country;
    private ZoneId timeZone;

    public City(String name, String country, ZoneId timeZone) {
        this.name = name;
        this.country = country;
        this.timeZone = timeZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public ZoneId getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(ZoneId timeZone) {
        this.timeZone = timeZone;
    }
    public boolean isTheSameCountry(City city2)
    {
        return country.equals(city2.country);
    }
    public boolean isTheSameTime(City city2)
    {
        ZonedDateTime time =ZonedDateTime.of( LocalDateTime.of(2012,12,12,12,12),timeZone);
        ZonedDateTime timeCity2=time.withZoneSameInstant(city2.getTimeZone());
        return time.toLocalDateTime().equals(timeCity2.toLocalDateTime());
    }
}
