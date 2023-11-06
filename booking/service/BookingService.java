package service;

import DAO.BookingDAO;
import jsonWorker.JsonWorker;
import models.Booking;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class BookingService {
    private final String filePath = "booking/dataBookings/data.json";
    private final List<Booking> flightsDatabase = new ArrayList<>();
    private BookingDAO bookingDAO;
    public BookingService() {
//        this.bookingDAO = bookingDAO;
//        this.bookingDAO =
    }
    public List<Booking> getAllBookings() {

        return;
    }
    public List<Booking> getAllUserBookings(String name, String surname) {

        return;
    }
    public int findByIdBooking(int bookingId) {
        return bookingDAO.findByIdBooking(bookingId);
    }
    public void saveBooking(Booking newBooking) {
        // Логіка для створення бронювання
        bookingDAO.saveBooking(newBooking);
    }
    public void cancelBooking(int bookingId) {
        // Логіка для скасування бронювання
        bookingDAO.cancelBooking(bookingId);
    }
    public void loadDataBooking() {
        File file = new File(filePath);
        if (!file.exists()) {
            JsonWorker.loadDataToFile(flightsDatabase, filePath);
        }
    }
}
