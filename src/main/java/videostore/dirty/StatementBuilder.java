package videostore.dirty;

import java.util.List;
import java.util.stream.Collectors;

public class StatementBuilder {

    public String buildStatement(String customerName, List<Rental> rentals) {
        return formatHeader(customerName) + formatBody(rentals) + formatFooter(rentals);
    }

    private String formatFooter(List<Rental> rentals) {
        return "Amount owed is " + computeTotalPrice(rentals) + "\n" +
                "You earned " + computeTotalRentalsPoints(rentals) + " frequent renter points";
    }

    private String formatBody(List<Rental> rentals) {
        return rentals.stream().map(this::formatRentalStatement).collect(Collectors.joining());
    }

    private double computeTotalPrice(List<Rental> rentals) {
        return rentals.stream().mapToDouble(Rental::computePrice).sum();
    }

    private int computeTotalRentalsPoints(List<Rental> rentals) {
        return rentals.stream().mapToInt(Rental::computeBonusRenterPoints).sum();
    }

    private String formatRentalStatement(Rental rental) {
        return "\t" + rental.getMovie().getTitle() + "\t"
                + rental.computePrice() + "\n";
    }

    private String formatHeader(String customerName) {
        return "Rental Record for " + customerName + "\n";
    }
}
