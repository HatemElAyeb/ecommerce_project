public class PaymentProcessor {
    // Simulate a credit card payment
    public boolean processCreditCardPayment(String cardNumber, double amount) {
        // Basic validation (in a real-world scenario, use a payment gateway)
        if (isValidCreditCardNumber(cardNumber)) {
            System.out.println("Processing credit card payment...");
            System.out.println("Amount: $" + amount);
            // Perform payment processing logic here
            return true; // Simulating a successful payment
        } else {
            System.out.println("Invalid credit card number. Payment failed.");
            return false;
        }
    }

    // Simulate a PayPal payment
    public boolean processPayPalPayment(String email, double amount) {
        // Basic validation (in a real-world scenario, use PayPal API)
        if (isValidEmail(email)) {
            System.out.println("Processing PayPal payment...");
            System.out.println("Amount: $" + amount);
            // Perform PayPal payment processing logic here
            return true; // Simulating a successful payment
        } else {
            System.out.println("Invalid PayPal email. Payment failed.");
            return false;
        }
    }

    // Basic credit card number validation (for simulation purposes)
    private boolean isValidCreditCardNumber(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 16 && cardNumber.matches("\\d+");
    }

    // Basic email validation (for simulation purposes)
    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }
}
