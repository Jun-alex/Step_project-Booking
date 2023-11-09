package org.example.booking.DAO;

import org.example.booking.jsonWorker.JsonWorker;
import org.example.booking.models.Booking;
import org.example.booking.models.Human;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionBooking implements BookingDAO {
    private final String filePath = "Step_project-Booking/Step_Booking/src/main/java/org/example/booking/dataBookings/data.json";
    private List<Booking> bookings = new ArrayList<>();

    public CollectionBooking() {
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Dats");
            bookings = new ArrayList<>();
        } else {
            System.out.println("Data");
            bookings = JsonWorker.getDataFromFile(Booking.class, filePath);
        }
    }

    @Override
    public int saveBooking(List<Human> humans, String destination, int idFlight) {
        int id = bookings.size();
        Booking newBooking = new Booking(humans, id, destination, idFlight);
        bookings.add(newBooking);
        return id;
    }

    @Override
    public boolean cancelBooking(int bookingId) {
        if (bookingId >= 0 && bookingId < bookings.size()) {
            // Логіка для скасування бронювання
            bookings.stream().filter(booking -> booking.getId() == bookingId)
                    .findFirst()
                    .ifPresent(booking -> bookings.remove(bookingId));
            return true;
        }
        return false;
    }

    @Override
    public boolean editBooking() {
        return false;
    }

    @Override
    public List<Booking> getAllUserBookings(String name, String surname) {
        return getAllBookings().stream()
                .filter(booking -> booking.getHumans().stream().anyMatch(human -> human.getName().equals(name)
                        && human.getSurname().equals(surname)))
                .collect(Collectors.toList());
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }

    @Override
    public Booking findByIdBooking(int bookingId) {
        if (bookingId >= 0 && bookingId < bookings.size()) {
            return bookings.get(bookingId);
        }
        return null;
    }
}
