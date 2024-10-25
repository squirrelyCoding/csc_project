import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JobHistoryPanel extends JPanel {
    private JTextField companyField, positionField;
    private JTextArea responsibilitiesArea;
    private JButton saveButton, editButton;
    private JList<String> jobHistoryList;
    private DefaultListModel<String> listModel;

    public JobHistoryPanel() {
        setLayout(new BorderLayout());

        // Create input fields
        companyField = new JTextField(20);
        positionField = new JTextField(20);
        responsibilitiesArea = new JTextArea(5, 20);

        // Create buttons
        saveButton = new JButton("Save Job History");
        editButton = new JButton("Edit Job History");

        // Create job history list
        listModel = new DefaultListModel<>();
        jobHistoryList = new JList<>(listModel);

        // Layout
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Company:"));
        inputPanel.add(companyField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(new JScrollPane(responsibilitiesArea));

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(editButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(jobHistoryList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        saveButton.addActionListener(e -> saveJobHistory());
        editButton.addActionListener(e -> editJobHistory());
    }

    private void saveJobHistory() {
        // Error checking for required fields
        if (companyField.getText().isEmpty() || positionField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Company and Position are required fields.");
            return;
        }

        String jobEntry = companyField.getText() + " - " + positionField.getText();
        listModel.addElement(jobEntry);

        // Clear fields after saving
        companyField.setText("");
        positionField.setText("");
        responsibilitiesArea.setText("");
    }

    private void editJobHistory() {
        int selectedIndex = jobHistoryList.getSelectedIndex();
        if (selectedIndex != -1) {
            String selectedJob = listModel.getElementAt(selectedIndex);
            String[] parts = selectedJob.split(" - ");
            companyField.setText(parts[0]);
            positionField.setText(parts[1]);
            // You would need to store and retrieve responsibilities separately
        }
    }
}