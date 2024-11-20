import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
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
    List<String> hardSkills;
    List<String> softSkills;
    List<String> talentSkills;
    List<String> giftSkills;
    String startDate;
    String endDate;

    JobHistory(String company, String position, String responsibilities, 
               List<String> hardSkills, List<String> softSkills, 
               List<String> talentSkills, List<String> giftSkills, 
               String startDate, String endDate) {
        this.company = company;
        this.position = position;
        this.responsibilities = responsibilities;
        this.hardSkills = hardSkills;
        this.softSkills = softSkills;
        this.talentSkills = talentSkills;
        this.giftSkills = giftSkills;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return company + " - " + position;
    }
}

public class JobHistoryPanel extends JPanel {
    private JTextField companyField, positionField, startDateField, endDateField;
    private JTextArea responsibilitiesArea, hardSkillsArea, softSkillsArea, talentSkillsArea, giftSkillsArea;
    private JList<JobHistory> jobList;
    private DefaultListModel<JobHistory> listModel;
    private List<JobHistory> jobHistory;

    public JobHistoryPanel() {
        setLayout(new BorderLayout());
        jobHistory = new ArrayList<>();

        companyField = new JTextField(20);
        positionField = new JTextField(20);
        startDateField = new JTextField(10);
        endDateField = new JTextField(10);
        responsibilitiesArea = new JTextArea(5, 20);
        hardSkillsArea = new JTextArea(3, 20);
        softSkillsArea = new JTextArea(3, 20);
        talentSkillsArea = new JTextArea(3, 20);
        giftSkillsArea = new JTextArea(3, 20);
        listModel = new DefaultListModel<>();
        jobList = new JList<>(listModel);

        JPanel inputPanel = new JPanel(new GridLayout(0, 2, 5, 5));
        inputPanel.add(new JLabel("Company:"));
        inputPanel.add(companyField);
        inputPanel.add(new JLabel("Position:"));
        inputPanel.add(positionField);
        inputPanel.add(new JLabel("Start Date (YYYY-MM-DD):"));
        inputPanel.add(startDateField);
        inputPanel.add(new JLabel("End Date (YYYY-MM-DD):"));
        inputPanel.add(endDateField);
        inputPanel.add(new JLabel("Responsibilities:"));
        inputPanel.add(new JScrollPane(responsibilitiesArea));
        inputPanel.add(new JLabel("Hard Skills:"));
        inputPanel.add(new JScrollPane(hardSkillsArea));
        inputPanel.add(new JLabel("Soft Skills:"));
        inputPanel.add(new JScrollPane(softSkillsArea));
        inputPanel.add(new JLabel("Talent Skills:"));
        inputPanel.add(new JScrollPane(talentSkillsArea));
        inputPanel.add(new JLabel("Gift Skills:"));
        inputPanel.add(new JScrollPane(giftSkillsArea));

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

        add(new JScrollPane(inputPanel), BorderLayout.NORTH);
        add(new JScrollPane(jobList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void saveJobHistory() {
        if (validateInputs()) {
            JobHistory job = new JobHistory(
                companyField.getText(),
                positionField.getText(),
                responsibilitiesArea.getText(),
                Arrays.asList(hardSkillsArea.getText().split("\n")),
                Arrays.asList(softSkillsArea.getText().split("\n")),
                Arrays.asList(talentSkillsArea.getText().split("\n")),
                Arrays.asList(giftSkillsArea.getText().split("\n")),
                startDateField.getText(),
                endDateField.getText()
            );
            jobHistory.add(job);
            listModel.addElement(job);
            clearFields();
        }
    }

    private boolean validateInputs() {
        if (companyField.getText().trim().isEmpty() ||
            positionField.getText().trim().isEmpty() ||
            responsibilitiesArea.getText().trim().isEmpty() ||
            !isValidDate(startDateField.getText()) ||
            !isValidDate(endDateField.getText())) {
            JOptionPane.showMessageDialog(this, "Please fill all required fields with valid data", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isValidDate(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(dateStr);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private void editJobHistory() {
        int selectedIndex = jobList.getSelectedIndex();
        if (selectedIndex != -1) {
            JobHistory job = jobHistory.get(selectedIndex);
            companyField.setText(job.company);
            positionField.setText(job.position);
            responsibilitiesArea.setText(job.responsibilities);
            hardSkillsArea.setText(String.join("\n", job.hardSkills));
            softSkillsArea.setText(String.join("\n", job.softSkills));
            talentSkillsArea.setText(String.join("\n", job.talentSkills));
            giftSkillsArea.setText(String.join("\n", job.giftSkills));
            startDateField.setText(job.startDate);
            endDateField.setText(job.endDate);
            jobHistory.remove(selectedIndex);
            listModel.remove(selectedIndex);
        }
    }

    private void viewJobHistory() {
        StringBuilder sb = new StringBuilder();
        for (JobHistory job : jobHistory) {
            sb.append(job.toString()).append("\n");
            sb.append("Start Date: ").append(job.startDate).append("\n");
            sb.append("End Date: ").append(job.endDate).append("\n");
            sb.append("Responsibilities: ").append(job.responsibilities).append("\n");
            sb.append("Hard Skills: ").append(String.join(", ", job.hardSkills)).append("\n");
            sb.append("Soft Skills: ").append(String.join(", ", job.softSkills)).append("\n");
            sb.append("Talent Skills: ").append(String.join(", ", job.talentSkills)).append("\n");
            sb.append("Gift Skills: ").append(String.join(", ", job.giftSkills)).append("\n\n");
        }
        JOptionPane.showMessageDialog(this, sb.toString(), "Job History", JOptionPane.INFORMATION_MESSAGE);
    }

    private void clearFields() {
        companyField.setText("");
        positionField.setText("");
        responsibilitiesArea.setText("");
        hardSkillsArea.setText("");
        softSkillsArea.setText("");
        talentSkillsArea.setText("");
        giftSkillsArea.setText("");
        startDateField.setText("");
        endDateField.setText("");
    }
}