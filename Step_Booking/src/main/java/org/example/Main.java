package org.example;

import org.example.flightDao.CollectionFlightDao;
import org.example.model.Flight;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        CollectionFlightDao collectionFlightDao = new CollectionFlightDao();
        collectionFlightDao.getFlightsDatabase().forEach(System.out::println);

        Flight flightById = collectionFlightDao.getFlightById(1);
        System.out.println(flightById);
        Flight flightById2 = collectionFlightDao.getFlightById(0);
        System.out.println(flightById2);
        Flight flightById3 = collectionFlightDao.getFlightById(50);
        System.out.println(flightById3);

        List<Flight> vienna = collectionFlightDao.getFlightByUserInfo("Vienna", "10.11.2023", 10);
        System.out.println(vienna);
    }
}