import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Chapter1_Challenge_1_4 {

    public static void main(String[] args) {
        BufferedReader reader = null;

        try {
            File configFile = new File("config.txt");
            reader = new BufferedReader(new FileReader(configFile));

            // Read first line: config version
            String line1 = reader.readLine();
            int configVersion = Integer.parseInt(line1);

            // Check version
            if (configVersion < 2) {
                throw new Exception("Config version too old!");
            }

            // Read second line: file path
            String filePath = reader.readLine();
            File pathFile = new File(filePath);
            if (!pathFile.exists()) {
                throw new IOException("File at path '" + filePath + "' does not exist!");
            }

            // If everything is fine
            System.out.println("Config read successfully!");
            System.out.println("Version: " + configVersion);
            System.out.println("File path: " + filePath);

        } catch (FileNotFoundException e) {
            System.out.println("Error: Configuration file 'config.txt' not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Config version is not a valid number.");
        } catch (Exception e) { // Custom exception for version check
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
            // Close reader safely
            try {
                if (reader != null) reader.close();
            } catch (IOException e) {
                System.out.println("Error closing reader: " + e.getMessage());
            }
        }
    }
}
