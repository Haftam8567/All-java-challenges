public class Chapter1_Challenge_1_2 {

    public static void main(String[] args) {
        // Step 1: Initialize array of winning numbers
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};

        String highestAverageNumber = "";
        double highestAverage = 0.0;

        // Print table header
        System.out.printf("%-20s %-12s %-12s%n", "Ticket", "Digit Sum", "Digit Average");
        System.out.println("-----------------------------------------------");

        // Step 2: Analyze each number
        for (String ticket : winningNumbers) {
            // Remove dashes
            String digitsOnly = ticket.replace("-", "");

            // Convert to integer array
            int[] digits = new int[digitsOnly.length()];
            for (int i = 0; i < digitsOnly.length(); i++) {
                digits[i] = Character.getNumericValue(digitsOnly.charAt(i));
            }

            // Calculate sum
            int sum = 0;
            for (int digit : digits) {
                sum += digit;
            }

            // Calculate average
            double average = (double) sum / digits.length;

            // Print formatted result
            System.out.printf("%-20s %-12d %-12.2f%n", ticket, sum, average);

            // Update highest average
            if (average > highestAverage) {
                highestAverage = average;
                highestAverageNumber = ticket;
            }
        }

        // Step 3: Print winning number with highest average
        System.out.println("\nThe winning number with the highest average is: " 
                           + highestAverageNumber + " with an average of " + highestAverage);
    }
}
