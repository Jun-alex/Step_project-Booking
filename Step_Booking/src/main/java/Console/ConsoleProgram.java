package Console;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ConsoleProgram {

    private FlightController flightController;
    private BookingController bookingController;

    public ConsoleProgram() {
        flightController = new FlightController();
        bookingController = new BookingController();
    }

    public static void main(String[] args) {
        ConsoleProgram consoleProgram = new ConsoleProgram();
        consoleProgram.start();
    }

    public void start() {
        boolean isRunning = true;
        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            try {
                System.out.println("Головне меню:");
                System.out.println("1. Онлайн-табло");
                System.out.println("2. Подивитися інформацію про рейс");
                System.out.println("3. Пошук та бронювання рейсу");
                System.out.println("4. Скасувати бронювання");
                System.out.println("5. Мої рейси");
                System.out.println("6. Вихід");
                System.out.println("Виберіть пункт меню: ");

                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        flightController.displayFlightsWithin24Hours();
                        break;
                    case 2:
                        System.out.println("Введіть айді рейсу: ");
                        int flightId;
                        try {
                            flightId = scanner.nextInt();
                            flightController.getFlightById(flightId);
                        } catch (InputMismatchException e) {
                            System.out.println("Помилка введення айді рейсу. Будь ласка, введіть число.");
                            scanner.next();
                        }
                        break;
                    case 3:
                        System.out.println("Місце призначення: ");
                        String destination = scanner.next();
                        System.out.println("Дата: ");
                        String date = scanner.next();
                        System.out.println("Кількість осіб: ");
                        int passengerCount;

                        try {
                            passengerCount = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Помилка введення кількості осіб. Будь ласка, введіть число.");
                            scanner.next();
                            continue;
                        }

                        List<Flight> foundFlights = flightController.
                                getFlightByUserInfo(destination, date, passengerCount);

                        if (foundFlights.isEmpty()) {
                            System.out.println("Рейси не знайдені.");
                        } else {
                            //рейсы с порядковым номерoм
                            for (int i = 0; i < foundFlights.size(); i++) {
                                System.out.println(i + 1 + ". " + foundFlights.get(i).toString());
                            }

                            System.out.println("Виберіть рейс за номером (або 0 для повернення до головного меню): ");
                            int selectedFlightNumber = scanner.nextInt();

                            if (selectedFlightNumber == 0) {
                                //вернутся в меню
                                break;
                            } else if (selectedFlightNumber > 0 && selectedFlightNumber <= foundFlights.size()) {
                                //данные для бронированич
                                System.out.println("Введіть ім'я пасажира: ");
                                String passengerName = scanner.next();
                                System.out.println("Введіть прізвище пасажира: ");
                                String passengerLastName = scanner.next();

                                //бронирование рейсв
                                boolean isBookingSuccessful = bookingController.bookFlight(
                                        foundFlights.get(selectedFlightNumber - 1),
                                        //passengerCount нужно использовать в bookFlight
                                        passengerName, passengerLastName, passengerCount);

                                if (isBookingSuccessful) {
                                    System.out.println("Бронювання успішно завершено.");
                                } else {
                                    System.out.println("Помилка бронювання рейса.");
                                }
                            } else {
                                System.out.println("Неправильний вибір рейсу.");
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Введіть айді бронювання: ");
                        int bookingId;

                        try {
                            bookingId = scanner.nextInt();
                        } catch (InputMismatchException e) {
                            System.out.println("Помилка введення айді бронювання. Будь ласка, введіть число.");
                            scanner.next();
                            continue;
                        }

                        bookingController.cancelBooking(bookingId);
                        break;
                    case 5:
                        System.out.println("Ім'я: ");
                        String firstName = scanner.next();
                        System.out.println("Прізвище: ");
                        String lastName = scanner.next();

                        if (firstName.isEmpty() || lastName.isEmpty()) {
                            System.out.println("Ім'я та прізвище пасажира повинні бути заповнені.");
                        } else {
                            bookingController.displayMyBookings(firstName, lastName);
                        }
                        break;
                    case 6:
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Невірний вибір. Будь ласка, виберіть інший пункт меню.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка вводу. Введені дані не відповідають очікуваному формату.");
                scanner.next();
            }
        }
        scanner.close();
    }
}
