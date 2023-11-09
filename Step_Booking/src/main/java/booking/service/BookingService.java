package booking.service;

import booking.DAO.BookingDAO;
import booking.DAO.CollectionBooking;
import booking.jsonWorker.JsonWorker;
import booking.models.Booking;
import booking.models.Human;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private final String filePath = "Step_Booking/src/main/java/booking/dataBookings/data.json";
    private final BookingDAO bookingDAO = new CollectionBooking();

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    public List<Booking> getAllUserBookings(String name, String surname) {
        if (name.isEmpty() || surname.isEmpty()) {
            throw new IllegalArgumentException("Exception name or surname");
        } else {
            return bookingDAO.getAllUserBookings(name, surname);
        }
    }

    public Booking findByIdBooking(int bookingId) {
        try {
            return bookingDAO.findByIdBooking(bookingId);
        } catch (Exception err) {
            throw new IllegalArgumentException("Exception id Booking");
        }
    }

    public int saveBooking(List<Human> humans, String destination, int idFlight) {
        if (humans.size() > 0 && idFlight >= 0) {
            return bookingDAO.saveBooking(humans, destination, idFlight);
        }
        return -1; // Повернення значення за умови, що умова не виконана
    }

    public void cancelBooking(int bookingId) {
        bookingDAO.cancelBooking(bookingId);
    }

    public void loadDataBooking() {
        File file = new File(filePath);
        if (file.exists()) {
            List<Booking> bookings = bookingDAO.getAllBookings();
            JsonWorker.loadDataToFile(bookings, filePath);
        }
    }
}
