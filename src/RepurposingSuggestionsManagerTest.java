// RepurposingSuggestionsManagerTest.java
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
public class RepurposingSuggestionsManagerTest {

    @Test
    public void testAddSuggestion() {
        RepurposingSuggestionsManager manager = new RepurposingSuggestionsManager("RePurposingSuggestions.txt");
        RepurposingSuggestion suggestion = new RepurposingSuggestion("Test Suggestion", "apple.jpg", "www.apple.com", "material");
        manager.addSuggestion(suggestion);

        assertTrue(RepurposingSuggestionsManager.searchByTitle("Test Suggestion").contains(suggestion));
    }

    @Test
    public void testRemoveSuggestion() {
        RepurposingSuggestionsManager manager = new RepurposingSuggestionsManager("RePurposingSuggestions.txt");
        RepurposingSuggestion suggestion = new RepurposingSuggestion("Test Suggestion", "orange.jpg", "www.orange.com", "material");
        manager.addSuggestion(suggestion);
        assertTrue(manager.removeSuggestion(suggestion));
        assertFalse(RepurposingSuggestionsManager.searchByTitle("Test Suggestion").contains(suggestion));
        System.out.println("Suggestions removed");

    }

    @Test
    public void testSearchByTitle() {
        RepurposingSuggestionsManager manager = new RepurposingSuggestionsManager("RePurposingSuggestions.txt");
        RepurposingSuggestion suggestion = new RepurposingSuggestion("Test Suggestion", "image.jpg", "www.example.com", "material");
        manager.addSuggestion(suggestion);
        System.out.println("New suggestion added.");


        assertEquals(1, RepurposingSuggestionsManager.searchByTitle("Test Suggestion").size());
    }

//        public static void main(String[] args) throws IOException {
//            // Creating a manager and loading suggestions from file
//            RepurposingSuggestionsManager manager = new RepurposingSuggestionsManager("RePurposingSuggestions.txt");
//            try {
//                manager.loadSuggestions();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            // Test adding a new record
//            RepurposingSuggestion newSuggestion = new RepurposingSuggestion("New Idea", "new.jpg", "http://google.com", "plastic");
//            manager.addSuggestion(newSuggestion);
//            System.out.println("New suggestion added.");
//
//            // Test editing an existing record
//            RepurposingSuggestion existingSuggestion = manager.searchByTitleBinary("Existing Idea");
//            if (existingSuggestion != null) {
//                existingSuggestion.setWebLink("http://google.com");
//                manager.saveSuggestions(); // Save changes to file
//                System.out.println("Existing suggestion edited and saved.");
//            } else {
//                System.out.println("Existing suggestion not found.");
//            }
//
//            // Test viewing existing records
//            System.out.println("All suggestions:");
//            for (RepurposingSuggestion suggestion : manager.getAllSuggestions()) {
//                System.out.println(suggestion);
//            }
//        }
    }




