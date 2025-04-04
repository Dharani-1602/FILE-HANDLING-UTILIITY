import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class FileHandlingUtility {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("File Handling Utility");
        System.out.println("1. Create and Write to a File");
        System.out.println("2. Read from a File");
        System.out.println("3. Modify a File");
        System.out.println("4. Exit");
        
        while (true) {
            System.out.print("Enter your choice (1-4): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    createAndWriteToFile(scanner);
                    break;
                case 2:
                    readFromFile(scanner);
                    break;
                case 3:
                    modifyFile(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please choose between 1-4.");
            }
        }
    }
    public static void createAndWriteToFile(Scanner scanner) {
        System.out.print("Enter the filename to create and write to: ");
        String filename = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            System.out.println("Enter text to write to the file (Type 'exit' to stop): ");
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Text has been written to the file: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
    public static void readFromFile(Scanner scanner) {
        System.out.print("Enter the filename to read from: ");
        String filename = scanner.nextLine();
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("Contents of the file " + filename + ":");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
    public static void modifyFile(Scanner scanner) {
        System.out.print("Enter the filename to modify: ");
        String filename = scanner.nextLine();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.println("Enter text to append to the file (Type 'exit' to stop): ");
            String line;
            while (true) {
                line = scanner.nextLine();
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Text has been appended to the file: " + filename);
        } catch (IOException e) {
            System.out.println("An error occurred while modifying the file: " + e.getMessage());
        }
    }
}
