import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EmployeeProfilePanel extends JPanel {
    private JTextArea profileArea;
    private JButton editButton, viewButton, saveButton;
    private JTextField nameField, idField, emailField, positionField;

    public EmployeeProfilePanel() {
        setLayout(new BorderLayout());

        profileArea = new JTextArea(10, 30);
        profileArea.setEditable(false);
        editButton = new JButton("Edit Profile");
        viewButton = new JButton("View Profile");
        saveButton = new JButton("Save Profile");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(editButton);
        buttonPanel.add(viewButton);
        buttonPanel.add(saveButton);

        add(new JScrollPane(profileArea), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        editButton.addActionListener(e -> editProfile());
        viewButton.addActionListener(e -> viewProfile());
        saveButton.addActionListener(e -> saveProfile());

        // Sample profile data
        updateProfile("Sravani", "1", "Sravz@example.com", "Software Developer");
    }

    private void updateProfile(String name, String id, String email, String position) {
        profileArea.setText("Name: " + name + "\n" +
                            "ID: " + id + "\n" +
                            "Email: " + email + "\n" +
                            "Position: " + position);
    }

    private void editProfile() {
        JPanel panel = new JPanel(new GridLayout(0, 2));
        nameField = new JTextField(10);
        idField = new JTextField(10);
        emailField = new JTextField(10);
        positionField = new JTextField(10);

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Position:"));
        panel.add(positionField);

        int result = JOptionPane.showConfirmDialog(null, panel, 
                 "Edit Profile", JOptionPane.OK_CANCEL_OPTION);
        
        if (result == JOptionPane.OK_OPTION) {
            updateProfile(nameField.getText(), idField.getText(),
                          emailField.getText(), positionField.getText());
            JOptionPane.showMessageDialog(this, "Profile updated successfully!");
        }
    }

    private void viewProfile() {
        // Display current profile information in a dialog
        JOptionPane.showMessageDialog(this, profileArea.getText(), 
                                      "Current Profile", JOptionPane.INFORMATION_MESSAGE);
    }

    private void saveProfile() {
        String profileData = profileArea.getText();
        
        // Save profile data to a file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("employee_profile.txt"))) {
            writer.write(profileData);
            JOptionPane.showMessageDialog(this, "Profile saved successfully!");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving profile: " + e.getMessage(),
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}