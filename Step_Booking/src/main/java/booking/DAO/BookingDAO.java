package booking.DAO;

import booking.models.Booking;
import booking.models.Human;

import java.util.List;

public interface BookingDAO {
    public int saveBooking(List<Human> humans, String destination, int idFlight);
    public boolean cancelBooking(int id);
    public boolean editBooking();
    public List<Booking> getAllUserBookings(String name, String surname);
    public List<Booking> getAllBookings();
    public Booking findByIdBooking(int bookingId);
}
