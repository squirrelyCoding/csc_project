import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmployeeProfilePanel extends JPanel {
    private JTextArea profileArea;
    private JButton editButton;

    public EmployeeProfilePanel() {
        setLayout(new BorderLayout());

        profileArea = new JTextArea(10, 30);
        profileArea.setEditable(false);
        editButton = new JButton("Edit Profile");

        add(new JScrollPane(profileArea), BorderLayout.CENTER);
        add(editButton, BorderLayout.SOUTH);

        editButton.addActionListener(e -> editProfile());

        // Sample profile data
        updateProfile("Sravani", 1, "Sravz@example.com", "Software Developer");
    }

    private void updateProfile(String name, int id, String email, String position) {
        profileArea.setText("Name: " + name + "\n" +
                            "ID: " + id + "\n" +
                            "Email: " + email + "\n" +
                            "Position: " + position);
    }

    private void editProfile() {
        // Logic to edit profile
        JOptionPane.showMessageDialog(this, "Edit profile functionality to be implemented");
    }
}