import java.util.Scanner;

public class SecretAgentDecryption {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- Step 1: Input ---
        System.out.print("Enter the secret number: ");
        int number = input.nextInt();

        // --- Step 2: Find the number of digits ---
        int numDigits = (int) Math.log10(number) + 1;

        // --- Step 3: Extract key digits ---
        int firstDigit = (int) (number / Math.pow(10, numDigits - 1));  // first
        int lastDigit = number % 10;                                    // last
        int secondDigit = (int) (number / Math.pow(10, numDigits - 2)) % 10; // second
        int secondLastDigit = (number / 10) % 10;                       // second-last

        // --- Step 4: Perform operations ---
        int product = firstDigit * lastDigit;
        int sum = secondDigit + secondLastDigit;

        // --- Step 5: Combine results ---
        String decryptedCode = "" + product + sum;

        // --- Step 6: Output ---
        System.out.println("\nThe decrypted code is: " + decryptedCode);

        input.close();
    }
}
