import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class JobHistory {
    String company;
    String position;
    String responsibilities;

    JobHistory(String company, String position, String responsibilities) {
        this.company = company;
        this.position = position;
        this.responsibilities = responsibilities;
    }

    @Override
    public String toString() {
        return company + " - " + position;
    }
}

public class JobHistoryPanel extends JPanel {
    private JTextField companyField, positionField;
    private JTextArea responsibilitiesArea;
    private JList<JobHistory> jobList;
    private DefaultListModel<JobHistory> listModel;
    private List<JobHistory> jobHistory;

    public JobHistoryPanel() {
        setLayout(new BorderLayout());
        jobHistory = new ArrayList<>();

        companyField = new JTextField(20);
        positionField = new JTextField(20);
        responsibilitiesArea = new JTextArea(5, 20);
        listModel = new DefaultListModel<>();
        jobList = new JList<>(listModel);

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Company:"));
        inputPanel.add(companyField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(new JScrollPane(responsibilitiesArea));

        JButton saveButton = new JButton("Save Job History");
        saveButton.addActionListener(e -> saveJobHistory());

        JButton editButton = new JButton("Edit Job History");
        editButton.addActionListener(e -> editJobHistory());

        JButton viewButton = new JButton("View Job History");
        viewButton.addActionListener(e -> viewJobHistory());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(editButton);
        buttonPanel.add(viewButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(jobList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveJobHistory() {
        JobHistory job = new JobHistory(companyField.getText(), positionField.getText(), responsibilitiesArea.getText());
        jobHistory.add(job);
        listModel.addElement(job);
        clearFields();
    }

    private void editJobHistory() {
        int selectedIndex = jobList.getSelectedIndex();
        if (selectedIndex != -1) {
            JobHistory job = jobHistory.get(selectedIndex);
            companyField.setText(job.company);
            positionField.setText(job.position);
            responsibilitiesArea.setText(job.responsibilities);
            jobHistory.remove(selectedIndex);
            listModel.remove(selectedIndex);
        }
    }

    private void viewJobHistory() {
        StringBuilder sb = new StringBuilder();
        for (JobHistory job : jobHistory) {
            sb.append(job.toString()).append("\n");
            sb.append("Responsibilities: ").append(job.responsibilities).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Job History", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        companyField.setText("");
        positionField.setText("");
        responsibilitiesArea.setText("");
    }
}
