import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmployeeProfilePanel extends JPanel {
    private JTextArea profileArea;
    private JButton editButton;
    private JComboBox<String> employeeSelector;
    private Map<String, Employee> employees;

    public EmployeeProfilePanel() {
        setLayout(new BorderLayout());

        profileArea = new JTextArea(10, 30);
        profileArea.setEditable(false);
        editButton = new JButton("Edit Profile");

        // Initialize employee data
        employees = new HashMap<>();
        employees.put("Sravani", new Employee("Sravani", 1, "sravani@example.com", "Software Developer"));
        employees.put("Aspen", new Employee("Aspen", 2, "aspen@example.com", "Project Manager"));
        employees.put("Tristan", new Employee("Tristan", 3, "tristan@example.com", "UI/UX Designer"));
        employees.put("Jackson", new Employee("Jackson", 4, "jackson@example.com", "Data Analyst"));

        // Create employee selector
        employeeSelector = new JComboBox<>(employees.keySet().toArray(new String[0]));
        employeeSelector.addActionListener(e -> updateProfileDisplay());

        JPanel topPanel = new JPanel();
        topPanel.add(employeeSelector);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(profileArea), BorderLayout.CENTER);
        add(editButton, BorderLayout.SOUTH);

        editButton.addActionListener(e -> editProfile());

        // Display initial profile
        updateProfileDisplay();
    }

    private void updateProfileDisplay() {
        String selectedName = (String) employeeSelector.getSelectedItem();
        Employee selectedEmployee = employees.get(selectedName);
        if (selectedEmployee != null) {
            updateProfile(selectedEmployee);
        }
    }

    private void updateProfile(Employee employee) {
        profileArea.setText("Name: " + employee.name + "\n" +
                            "ID: " + employee.id + "\n" +
                            "Email: " + employee.email + "\n" +
                            "Position: " + employee.position);
    }

    private void editProfile() {
        // Logic to edit profile
        JOptionPane.showMessageDialog(this, "Edit profile functionality to be implemented");
    }

    // Inner class to represent an Employee
    private static class Employee {
        String name;
        int id;
        String email;
        String position;

        Employee(String name, int id, String email, String position) {
            this.name = name;
            this.id = id;
            this.email = email;
            this.position = position;
        }
    }
}