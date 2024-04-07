import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm {
    private RepurposingSuggestionsManager database;
    private JTextArea displayArea;
    private int currentIndex = 0;

    public MainForm(RepurposingSuggestionsManager database) {
        this.database = database;
    }

    public void displayForm() {
        JFrame frame = new JFrame("Repurposing Suggestions");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JButton firstButton = new JButton("First");
        JButton prevButton = new JButton("Previous");
        JButton nextButton = new JButton("Next");
        JButton lastButton = new JButton("Last");
        JTextField searchField = new JTextField(20);
        JButton searchButton = new JButton("Search");

        JPanel navigationPanel = new JPanel();
        navigationPanel.add(firstButton);
        navigationPanel.add(prevButton);
        navigationPanel.add(nextButton);
        navigationPanel.add(lastButton);
        navigationPanel.add(searchField);
        navigationPanel.add(searchButton);

        displayArea = new JTextArea(20, 50);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        mainPanel.add(navigationPanel, BorderLayout.NORTH);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);

        // Event listeners
        firstButton.addActionListener(e -> displayRecord(0));
        prevButton.addActionListener(e -> displayRecord(currentIndex - 1));
        nextButton.addActionListener(e -> displayRecord(currentIndex + 1));
        lastButton.addActionListener(e -> displayRecord(database.getNumberOfRecords() - 1));
        searchButton.addActionListener(e -> {
            String searchString = searchField.getText();
            displayFilteredRecords(searchString);
        });

        // Initial display
        displayRecord(0);
    }

    private void displayRecord(int index) {
        if (index >= 0 && index < database.getNumberOfRecords()) {
            currentIndex = index;
            RepurposingSuggestion suggestion = database.getRecord(index);
            displayArea.setText(suggestion.toString());
        }
    }

    private void displayFilteredRecords(String searchString) {
        StringBuilder filteredRecords = new StringBuilder();
        for (RepurposingSuggestion suggestion : database.filterRecords(searchString)) {
            filteredRecords.append(suggestion.toString()).append("\n");
        }
        displayArea.setText(filteredRecords.toString());
    }
}
