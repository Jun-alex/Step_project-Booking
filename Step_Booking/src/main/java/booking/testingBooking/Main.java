package booking.testingBooking;

import booking.controller.BookingController;
import booking.models.Booking;
import booking.models.Human;
import booking.service.BookingService;

import java.util.ArrayList;
import java.util.List;

public class Main {
//    public static void main(String[] args) {
//        // Створення об'єктів
//        BookingService bookingService = new BookingService();
//        BookingController bookingController = new BookingController(bookingService);
//
//        // Завантаження даних
//        bookingService.loadDataBooking();
//
//        // Отримання всіх бронювань
//        List<Booking> allBookings = bookingController.getAllBookings();
//        System.out.println("Усі бронювання:");
//        for (Booking booking : allBookings) {
//            System.out.println(booking);
//        }
//
//        // Отримання бронювань для певного користувача (приклад ім'я і прізвище)
//        List<Booking> userBookings = bookingController.getAllUserBookings("Ім'я", "Прізвище");
//        System.out.println("\nБронювання для користувача:");
//        for (Booking booking : userBookings) {
//            System.out.println(booking);
//        }
//
//        // Створення нового бронювання
//        Human man = new Human("Kris", "Soul");
//        List<Human> humans = new ArrayList<>(); // Додайте об'єкти Human до списку
//        humans.add(man);
//        int idFlight = 123; // Приклад ID рейсу
//        int newBookingId = bookingController.saveBooking(humans, "Пункт Призначення", idFlight);
//        System.out.println("\nСтворено нове бронювання з ID: " + newBookingId);
//        bookingService.loadDataBooking();
//        // Скасування бронювання
//        int bookingIdToCancel = 5; // Приклад ID бронювання, яке треба скасувати
//        bookingController.cancelBooking(bookingIdToCancel);
//        System.out.println("\nБронювання з ID " + bookingIdToCancel + " було скасовано.");
//
//        System.out.println("Усі бронювання:");
//        for (Booking booking : allBookings) {
//            System.out.println(booking);
//        }
//
//        // Отримання бронювань для певного користувача (приклад ім'я і прізвище)
//        List<Booking> userBookins = bookingController.getAllUserBookings("Kris", "Soul");
//        System.out.println("\nБронювання для користувача:");
//        for (Booking booking : userBookins) {
//            System.out.println(booking);
//        }
//
//        humans.add(man);
//        idFlight = 13; // Приклад ID рейсу
//        newBookingId = bookingController.saveBooking(humans, "Пункт Призначення", idFlight);
//        System.out.println("\nСтворено нове бронювання з ID: " + newBookingId);
//        bookingService.loadDataBooking();
//
//        bookingIdToCancel = 0; // Приклад ID бронювання, яке треба скасувати
//        bookingController.cancelBooking(bookingIdToCancel);
//        System.out.println("\nБронювання з ID " + bookingIdToCancel + " було скасовано.");
//        bookingService.loadDataBooking();
//        allBookings = bookingController.getAllBookings();
//        System.out.println("Усі бронювання:");
//        for (Booking booking : allBookings) {
//            System.out.println(booking);
//        }
//    }
}
