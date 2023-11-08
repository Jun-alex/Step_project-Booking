package flightLogic.flightDao;

import flightLogic.model.Flight;

import java.util.List;

interface FlightDao {
    void loadFlightsToFile();
    void saveFlights();
    Flight getFlightById(int id);
    List<Flight> getFlightByUserInfo(String destination, String date, int ticketsQuantity);
}
