package booking.service;

import DAO.BookingDAO;
import jsonWorker.JsonWorker;
import models.Booking;
import models.Human;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookingService {
    private final String filePath = "booking/dataBookings/data.json";
    private final List<Booking> bookingsData = new ArrayList<>();
    private BookingDAO bookingDAO;
    public BookingService(BookingDAO bookingDAO) {
        this.bookingDAO = bookingDAO;
    }
    public List<Booking> getAllBookings() {
        return JsonWorker.getDataFromFile(Booking.class, filePath);
    }
    public List<Booking> getAllUserBookings(String name, String surname) {
        if(name.isEmpty() || surname.isEmpty()){
            System.out.println("Exeption name or surname");
            return null;
        } else {
            return getAllBookings().stream().filter(booking
                    -> booking.getHumans().stream().anyMatch(human
                    -> human.getName().equals(name)
                    && human.getSurname().equals(surname)))
                    .collect(Collectors.toList());
        }
    }
    public int findByIdBooking(int bookingId) {
        return bookingDAO.findByIdBooking(bookingId);
    }
    public int saveBooking( List<Human> humans, String destination, int idFlight) {
        if (humans.size() > 0 && idFlight != 0) {
            int id = bookingDAO.getAllBookings().size();
            Booking newBooking = new Booking(humans, id, destination, idFlight);
            // Логіка для створення бронювання
            bookingDAO.saveBooking(newBooking);
            return id;
        }
        return -1; // Повернення значення за умови, що умова не виконана
    }
    public void cancelBooking(int bookingId) {
        // Логіка для скасування бронювання
        List<Booking> bookings = bookingDAO.getAllBookings();
        bookings.stream().filter(booking -> booking.getId() == bookingId)
                .findFirst()
                .ifPresent(booking -> bookingDAO.cancelBooking(bookingId));
    }
    public void loadDataBooking() {
        File file = new File(filePath);
        if (!file.exists()) {
            JsonWorker.loadDataToFile(bookingsData, filePath);
        }
    }
}
