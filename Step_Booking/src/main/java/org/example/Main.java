package org.example;

import org.example.flightDao.CollectionFlightDao;
import org.example.flightDao.FlightController;
import org.example.flightDao.FlightService;
import org.example.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
//        При створенні конструктора collectionFlightDao ми генеруємо 501 рейс
//        (з айді від 0 до 500 включно), завантажуємо їх у файл flights.json
//        та зберігаємо їх в List<Flight> flightsDatabase
        CollectionFlightDao collectionFlightDao = new CollectionFlightDao();
        FlightService flightService = new FlightService(collectionFlightDao);
        FlightController flightController = new FlightController(flightService);

        flightController.displayFlightsWithin24Hours();
        System.out.println(flightController.getFlightById(0));
        System.out.println(flightController.getFlightById(1));
        System.out.println(flightController.getFlightByUserInfo("Madrid", "11.11.2023", 10));
//        flightController.getFlightsDatabase().forEach(System.out::println);
    }
}