import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Entry point for Repurposing Suggestion Management Software system
 */
public class Main {
    /**
     * Main method to start the app
     * @param args command line arguments (unused)
     */
    public static void main(String[] args) {
//        RepurposingSuggestionsManager manager = new RepurposingSuggestionsManager("RePurposingSuggestions.txt");
//        try {
//            manager.loadSuggestions();
//            displayMenu(manager);
//
//            // Implement your CLI interface or any GUI interface here
//        } catch (IOException e) {
//            System.err.println("Error loading suggestions: " + e.getMessage());
//        }
//    }
//
//    /**
//     * Displays the menu and handles user input
//     * @param manager the RepurposingSuggestionsManager instance
//     */
//
//    private static void displayMenu(RepurposingSuggestionsManager manager) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        while (true) {
//            System.out.println("========== Repurposing Suggestions ==========");
//            System.out.println("1. View all suggestions");
//            System.out.println("2. Search suggestions by title");
//            System.out.println("3. Search suggestions by primary material");
//            System.out.println("4. Exit");
//            System.out.print("Enter your choice: ");
//
//            try {
//                int choice = Integer.parseInt(reader.readLine());
//                switch (choice) {
//                    case 1:
//                        RepurposingSuggestionsManager.displayAllSuggestions(manager);
//                        break;
//                    case 2:
//                        RepurposingSuggestionsManager.searchByTitle(manager, reader);
//                        break;
//                    case 3:
//                        RepurposingSuggestionsManager.searchByMaterial(manager, reader);
//                        break;
//                    case 4:
//                        System.out.println("Exiting...");
//                        return;
//                    default:
//                        System.out.println("Invalid choice. Please enter a number between 1 and 4.");
//                }
//            } catch (NumberFormatException | IOException e) {
//                System.err.println("Invalid input. Please enter a valid number.");
//            }
//        }
        RepurposingSuggestionsManager database = new RepurposingSuggestionsManager("RePurposingSuggestions.txt");
        MainForm mainForm = new MainForm(database);
        mainForm.displayForm();
    }
}
