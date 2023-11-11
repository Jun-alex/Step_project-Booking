package org.example.booking.test;

import org.example.booking.controller.BookingController;
import org.example.booking.service.BookingService;

public class BookingControllerTest {
    BookingService bookingService = new BookingService();
    BookingController bookingController = new BookingController(bookingService);
}
