// RepurposingSuggestionsManager.java
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Manage repurposing suggestions including storage, retrieval, and searching
 */
public class RepurposingSuggestionsManager {
    private static List<RepurposingSuggestion> suggestions;
    private File dataFile;

    /**
     * Constructs a RepurposingSuggestionsManager with the specified filename
     * @param filename the name of the file to load suggestions from
     */
    public RepurposingSuggestionsManager(String filename) {
        suggestions = new ArrayList<>();
        dataFile = new File(filename);
    }

    // Load suggestions from file

    /**
     *
     */
    public void loadSuggestions() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(dataFile));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println("Line read from file: " + line); // Debugging statement
            String[] parts = line.split(";");
            System.out.println("Number of parts: " + parts.length); // Debugging statement
            RepurposingSuggestion suggestion = new RepurposingSuggestion(parts[0], parts[1], parts[2], parts[3]);
            suggestions.add(suggestion);
        }
        reader.close();
    }

    /**
     * Other methods for adding, removing, searching suggestions
     * Save suggestions to file
     * @throws IOException
     */
    public void saveSuggestions() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFile));
        for (RepurposingSuggestion suggestion : suggestions) {
            writer.write(suggestion.getTitle() + ";" + suggestion.getImageLocation() + ";" +
                    suggestion.getWebLink() + ";" + suggestion.getPrimaryMaterials() + ";" +
                    suggestion.getConstructionHints() + "\n");
        }
        writer.close();
    }


    /**
     * Add a new suggestion to manager
     * @param suggestion the suggestion to add
     */
    public void addSuggestion(RepurposingSuggestion suggestion) {

        suggestions.add(suggestion);
        suggestions.sort(Comparator.comparing(RepurposingSuggestion::getTitle)); // sort suggestions by idea title
    }

    /**
     *
     * @return the number of recorded suggestions
     */
    public int getNumberOfRecords() {
        return suggestions.size();
    }


    /**
     * Searches for a suggestion by idea title using binary search
     * @param title the title of the suggestion to search for
     * @return the suggestion with the specified title, or null if not found
     */
    public RepurposingSuggestion searchByTitleBinary(String title){
        int index = binarySearchByTitle(title);
        return index != -1 ? suggestions.get(index) : null;
    }

    private int binarySearchByTitle(String title) {
        int low = 0;
        int high = suggestions.size() - 1;

        while (low <= high) {
            int mid = low + (high - low)/2;
            RepurposingSuggestion midSuggestion = suggestions.get(mid);
            int cmp = midSuggestion.getTitle().compareTo(title);

            if(cmp == 0){
                return mid;
            } else if (cmp < 0) {
                low = mid + 1; // search
            } else {
                high = mid -1;
            }
        }
        return -1;
    }

    // Remove a suggestion
    public boolean removeSuggestion(RepurposingSuggestion suggestion) {
        return suggestions.remove(suggestion);
    }

    // Search for suggestions by title
    public static List<RepurposingSuggestion> searchByTitle(String title) {
        List<RepurposingSuggestion> results = new ArrayList<>();
        for (RepurposingSuggestion suggestion : suggestions) {
            if (suggestion.getTitle().equalsIgnoreCase(title)) {
                results.add(suggestion);
            }
        }
        return results;
    }

    /**
     * Search for suggestions by primary material
     * @param material
     * @return
     */
    public List<RepurposingSuggestion> searchByPrimaryMaterial(String material) {
        List<RepurposingSuggestion> results = new ArrayList<>();
        for (RepurposingSuggestion suggestion : suggestions) {
            if (suggestion.getPrimaryMaterials().toLowerCase().contains(material.toLowerCase())) {
                results.add(suggestion);
            }
        }
        return results;
    }

    public List<RepurposingSuggestion> getAllSuggestions() {
        return Collections.unmodifiableList(suggestions);
    }
    static void displayAllSuggestions(RepurposingSuggestionsManager manager) {
        List<RepurposingSuggestion> suggestions = manager.getAllSuggestions();
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found.");
        } else {
            System.out.println("All Suggestions:");
            for (RepurposingSuggestion suggestion : suggestions) {
                System.out.println(suggestion);
            }
        }
    }

    static void searchByTitle(RepurposingSuggestionsManager manager, BufferedReader reader) throws IOException {
        System.out.print("Enter the title to search: ");
        String title = reader.readLine();
        List<RepurposingSuggestion> suggestions = searchByTitle(title);
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found with the title '" + title + "'.");
        } else {
            System.out.println("Suggestions with the title '" + title + "':");
            for (RepurposingSuggestion suggestion : suggestions) {
                System.out.println(suggestion);
            }
        }
    }

    static void searchByMaterial(RepurposingSuggestionsManager manager, BufferedReader reader) throws IOException {
        System.out.print("Enter the primary material to search: ");
        String material = reader.readLine();
        List<RepurposingSuggestion> suggestions = manager.searchByPrimaryMaterial(material);
        if (suggestions.isEmpty()) {
            System.out.println("No suggestions found with the primary material '" + material + "'.");
        } else {
            System.out.println("Suggestions with the primary material '" + material + "':");
            for (RepurposingSuggestion suggestion : suggestions) {
                System.out.println(suggestion);
            }
        }
    }

    public RepurposingSuggestion getRecord(int index) {
        if (index >= 0 && index < suggestions.size()) {
            return suggestions.get(index);
        }
        return null; // or throw an exception if desired
    }

    public List<RepurposingSuggestion> filterRecords(String searchString) {
        List<RepurposingSuggestion> filteredList = new ArrayList<>();
        for (RepurposingSuggestion suggestion : suggestions) {
            if (suggestion.getTitle().toLowerCase().contains(searchString.toLowerCase())) {
                filteredList.add(suggestion);
            }
        }
        return filteredList;
    }


}
