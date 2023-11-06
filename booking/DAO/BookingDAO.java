package DAO;

import models.Booking;

public interface BookingDAO {
    public void saveBooking(Booking booking);
    public boolean cancelBooking(int id);
    public boolean editBooking();
    public Booking getAllUserBookings(String name, String surname);
    public int findByIdBooking(int id);
    public void loadDataBooking();
}
