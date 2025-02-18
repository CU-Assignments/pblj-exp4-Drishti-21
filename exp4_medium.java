import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

class Card {
    String symbol;
    String value;

    public Card(String symbol, String value) {
        this.symbol = symbol;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Symbol: " + symbol + ", Value: " + value;
    }
}

public class Main {
    private static Collection<Card> cards = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Card");
            System.out.println("2. Remove Card");
            System.out.println("3. Search Cards by Symbol");
            System.out.println("4. Display All Cards");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCard();
                    break;
                case 2:
                    removeCard();
                    break;
                case 3:
                    searchCardsBySymbol();
                    break;
                case 4:
                    displayAllCards();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addCard() {
        System.out.print("Enter Symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter Value: ");
        String value = scanner.nextLine();
        cards.add(new Card(symbol, value));
        System.out.println("Card added successfully!");
    }

    private static void removeCard() {
        System.out.print("Enter Symbol of Card to Remove: ");
        String symbol = scanner.nextLine();
        cards.removeIf(card -> card.symbol.equalsIgnoreCase(symbol));
        System.out.println("Card removed successfully!");
    }

    private static void searchCardsBySymbol() {
        System.out.print("Enter Symbol to Search: ");
        String symbol = scanner.nextLine();
        boolean found = false;
        for (Card card : cards) {
            if (card.symbol.equalsIgnoreCase(symbol)) {
                System.out.println(card);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No cards found with the given symbol.");
        }
    }

    private static void displayAllCards() {
        if (cards.isEmpty()) {
            System.out.println("No cards to display.");
        } else {
            for (Card card : cards) {
                System.out.println(card);
            }
        }
    }
}
