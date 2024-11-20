import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

class Employee {
    String name;
    int id;

    Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return name + " (ID: " + id + ")";
    }
}

public class EmployeeListPanel extends JPanel {
    private List<Employee> employees;
    private DefaultListModel<Employee> listModel;
    private JList<Employee> employeeList;
    private JTextField searchField;
    private JButton sortButton;
    private JButton clearButton;

    public EmployeeListPanel() {
        setLayout(new BorderLayout());
        employees = new ArrayList<>();
        // Add some sample employees
        employees.add(new Employee("Sravani", 1));
        employees.add(new Employee("Aspen", 2));
        employees.add(new Employee("Tristan", 3));
        employees.add(new Employee("Jackson", 4));

        listModel = new DefaultListModel<>();
        for (Employee emp : employees) {
            listModel.addElement(emp);
        }
        employeeList = new JList<>(listModel);

        searchField = new JTextField(20);
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            public void changedUpdate(javax.swing.event.DocumentEvent e) { search(); }
            public void removeUpdate(javax.swing.event.DocumentEvent e) { search(); }
            public void insertUpdate(javax.swing.event.DocumentEvent e) { search(); }
        });

        sortButton = new JButton("Sort Alphabetically");
        sortButton.addActionListener(e -> sortEmployees());

        clearButton = new JButton("Clear Search");
        clearButton.addActionListener(e -> clearSearch());

        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Search:"));
        topPanel.add(searchField);
        topPanel.add(clearButton);
        topPanel.add(sortButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(employeeList), BorderLayout.CENTER);
    }

    private void search() {
        String term = searchField.getText().toLowerCase();
        listModel.clear();
        for (Employee emp : employees) {
            if (emp.name.toLowerCase().contains(term) || String.valueOf(emp.id).contains(term)) {
                listModel.addElement(emp);
            }
        }
    }

    private void sortEmployees() {
        employees.sort(Comparator.comparing(e -> e.name));
        updateListModel();
    }

    private void clearSearch() {
        searchField.setText("");
        updateListModel();
    }

    private void updateListModel() {
        listModel.clear();
        for (Employee emp : employees) {
            listModel.addElement(emp);
        }
    }
}