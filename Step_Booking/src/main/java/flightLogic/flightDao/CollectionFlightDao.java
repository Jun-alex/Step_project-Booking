package flightLogic.flightDao;

import flightLogic.jsonWorker.JsonWorker;
import flightLogic.model.Flight;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class CollectionFlightDao implements FlightDao {
    private final String filePath = "Step_Booking/src/main/java/flightLogic/flightsDatabase/flights.json";
    private final List<Flight> flightsDatabase = new ArrayList<>();
    private final List<Flight> generatedFlights = new ArrayList<>();
    private static final Set<String> destinations= new HashSet<>();
    public CollectionFlightDao() {
        initializeDestinationsMap();
        generateFlights();
        loadFlightsToFile();
        saveFlights();
    }

    private void generateFlights() {
        for(int i = 0; i <= 500; i++) {
            Flight flight = new Flight(i, generateRandomDate(), generateRandomTime(), generateRandomDestination(), generateRandomAvailableSeatsQuantity());
            generatedFlights.add(flight);
        }
    }

    private static void initializeDestinationsMap() {
        destinations.add("Warsaw");
        destinations.add("Bern");
        destinations.add("Prague");
        destinations.add("Barcelona");
        destinations.add("Vienna");
        destinations.add("Paris");
        destinations.add("Tokyo");
        destinations.add("New York City");
        destinations.add("London");
        destinations.add("Rome");
        destinations.add("Sydney");
        destinations.add("Istanbul");
        destinations.add("Rio de Janeiro");
        destinations.add("Dubai");
        destinations.add("Amsterdam");
        destinations.add("Bangkok");
        destinations.add("San Francisco");
        destinations.add("Buenos Aires");
        destinations.add("Washington");
        destinations.add("Madrid");
        destinations.add("Seoul");
    }

    @Override
    public void loadFlightsToFile() {
//        "База даних" програми має бути скопійована у текстовий файл
//        Завантажуємо рейси у файл один раз, а не при кожному запуску програми
        File file = new File(filePath);
        if (!file.exists()) {
            JsonWorker.loadDataToFile(generatedFlights, filePath);
        }
    }

    @Override
    public void saveFlights() {
//        "База даних" має зчитуватись додатком при запуску
        List<Flight> dataFromFile = JsonWorker.getDataFromFile(Flight.class, filePath);
        flightsDatabase.addAll(dataFromFile);
    }

    @Override
    public Flight getFlightById(int id) {
        Flight flightById = null;
//        В параметри буде приходити айді від користувача (від 0 і більше)
        for (Flight f : flightsDatabase) {
            if (f.getId() == id) {
                flightById = f;
            }
        }
        return flightById;
//        Optional<Flight> flight = generatedFlights.stream()
//                .filter(f -> f.getId() == id - 1)
//                .findFirst();
//        return flight.orElse(null);
    }

    @Override
    public List<Flight> getFlightByUserInfo(String destination, String date, int ticketsQuantity) {
        return flightsDatabase.stream()
                .filter(f -> f.getDestination().equals(destination) &&
                        f.getDate().equals(date) &&
                        f.getAvailableSeatsQuantity() >= ticketsQuantity)
                .collect(Collectors.toList());
    }
    private static String generateRandomDate() {
//        Генеруємо випадкову дату в діапазоні від "08.11.2023" до "18.11.2023"
        LocalDate startDate = LocalDate.of(2023, 11, 8); // Початкова дата
        LocalDate endDate = LocalDate.of(2023, 11, 18); // Кінцева дата

        long startEpochDay = startDate.toEpochDay() * 86_400_000;
        long endEpochDay = endDate.toEpochDay() * 86_400_000;
//        Генеруємо випадкове число epoch в діапазоні від startEpochDay (початкова дата) до endEpochDay (кінцева дата)
        long randomEpochDay = ThreadLocalRandom.current().nextLong(startEpochDay, endEpochDay);

//        Форматуємо випадкову дату в рядок за допомогою SimpleDateFormat
        return new SimpleDateFormat("dd.MM.yyyy").format(new Date(randomEpochDay));
    }
    private static String generateRandomTime() {
//        Генеруємо випадковий час рейсу
        Random random = new Random();
//        Generate random integers in range 0 to 1439
        int minutesAfterMidnight = random.nextInt(1440);
        LocalTime time = LocalTime.of(minutesAfterMidnight / 60, minutesAfterMidnight % 60);
        return time.toString();
    }
    private static String generateRandomDestination() {
//        Генеруємо випадкову точку прибуття
        Random random = new Random();
        int destinationIndex = random.nextInt(destinations.size());
//        Перетворення HashSet в ArrayList
        List<String> destinationsList = new ArrayList<>(destinations);
        return destinationsList.get(destinationIndex);
    }
    private int generateRandomAvailableSeatsQuantity() {
//        Генеруємо кількість вільних місць (від 0 до 188)
        Random random = new Random();
        int availableSeatsQuantity = random.nextInt(189);
        return availableSeatsQuantity;
    }

    public List<Flight> getFlightsDatabase() {
        return flightsDatabase;
    }
}
