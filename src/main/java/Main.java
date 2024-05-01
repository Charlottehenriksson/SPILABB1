import Interface.CurrencyConverter;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);

        List<CurrencyConverter> converters = new ArrayList<>();
        loader.forEach(converters::add);

        while (true) {
            System.out.println("Choose a currency converter (Type 'exit' to quit):");
            for (int i = 0; i < converters.size(); i++) {
                System.out.println((i + 1) + ". " + converters.get(i).getClass().getSimpleName());
            }

            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Exiting the program.");
                break;
            }

            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please try again.");
                continue;
            }

            if (choice < 1 || choice > converters.size()) {
                System.out.println("Invalid choice. Please try again.");
                continue;
            }

            CurrencyConverter converter = converters.get(choice - 1);

            System.out.print("Enter amount and currencies (e.g., 200 EURO SEK): ");
            if (!scanner.hasNextDouble()) {
                System.out.println("Expected a number, but received: " + scanner.nextLine());
                continue;
            }
            double amount = scanner.nextDouble();
            String from = scanner.next().toUpperCase();
            String to = scanner.next().toUpperCase();
            scanner.nextLine();

            try {
                double convertedAmount = converter.convert(amount, from, to);
                System.out.printf("Converted amount: %.2f %s\n", convertedAmount, to);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid conversion: " + e.getMessage());
            }
        }
    }
}