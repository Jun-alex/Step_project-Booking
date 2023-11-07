package DAO;

import models.Booking;

import java.util.List;

public interface BookingDAO {
    public void saveBooking(Booking booking);
    public boolean cancelBooking(int id);
    public boolean editBooking();
    public List<Booking> getAllUserBookings(String name, String surname);
    public List<Booking> getAllBookings();
    public int findByIdBooking(int id);
    public void loadDataBooking();
}
