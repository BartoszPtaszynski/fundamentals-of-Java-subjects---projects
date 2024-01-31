import exceptions.NoFreeSeatsException;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProjectTest {
    private City c1=new City("Berlin","Germany", ZoneId.of("Europe/Berlin")) ;
    private City c2=new City("Lodz","Poland", ZoneId.of("Europe/Warsaw")) ;
    private BusRide travel=new BusRide(LocalDateTime.now(), 120,c1, c2, 60, 10, "EL99999");
    @Test
    public void isTheSameCountryCity()
    {
        assertFalse(c1.isTheSameCountry(c2));
    }
    @Test
    public void isTheSameTimeCity()
    {
        assertTrue(c1.isTheSameTime(c2));
    }

    @Test
    public void isNationalTravel()
    {
        assertFalse(travel.isNational());
    }

    @Test
    public void doesChangeDateTravel()
    {
        assertFalse(travel.doesChangeDate());
    }

    @Test(expected = NoFreeSeatsException.class)
    public void reserveTest() throws NoFreeSeatsException
    {
            travel.reserve(5000);
    }



}
