package booking.controller;

import booking.models.Booking;
import booking.models.Human;
import booking.service.BookingService;

import java.util.ArrayList;
import java.util.List;

public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public List<Booking> getAllBookings() {return bookingService.getAllBookings();}
    public List<Booking> getAllUserBookings(String name, String surname) {return bookingService.getAllUserBookings(name, surname);}
    public Booking findByIdBooking(int bookingId) {return bookingService.findByIdBooking(bookingId);}
    public int saveBooking(List<Human> humans, String destination, int idFlight) { return bookingService.saveBooking( humans, destination, idFlight);}
    public void cancelBooking(int bookingId) {bookingService.cancelBooking(bookingId);}
    public void loadDataBooking() {bookingService.loadDataBooking();}
}