package controller;

import models.Booking;
import service.BookingService;

import java.util.List;

public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public List<Booking> getAllBookings() {return bookingService.getAllBookings();}
    public List<Booking> getAllUserBookings(String name, String surname) {return bookingService.getAllUserBookings(name, surname);}
    public int findByIdBooking(int bookingId) {return bookingService.findByIdBooking(bookingId);}
    public void saveBooking(Booking newBooking) {bookingService.saveBooking(newBooking);}
    public void cancelBooking(int bookingId) {bookingService.cancelBooking(bookingId);}
    public void loadDataBooking() {bookingService.loadDataBooking();}
}
