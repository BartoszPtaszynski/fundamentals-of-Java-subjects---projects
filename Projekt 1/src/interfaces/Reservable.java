package interfaces;

import exceptions.NoFreeSeatsException;
public interface Reservable {
    void reserve(int numberOfSeats)  throws NoFreeSeatsException;
}
