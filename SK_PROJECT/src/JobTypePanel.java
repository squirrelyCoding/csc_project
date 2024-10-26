import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class JobTypePanel extends JPanel {
    private JTextField jobTitleField, softSkillField;
    private JList<String> softSkillsList;
    private DefaultListModel<String> listModel;
    private Set<String> softSkills;

    public JobTypePanel() {
        setLayout(new BorderLayout());
        softSkills = new HashSet<>();

        jobTitleField = new JTextField(20);
        softSkillField = new JTextField(20);
        listModel = new DefaultListModel<>();
        softSkillsList = new JList<>(listModel);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Job Title:"));
        inputPanel.add(jobTitleField);
        inputPanel.add(new JLabel("Soft Skill:"));
        inputPanel.add(softSkillField);

        JButton addButton = new JButton("Add Skill");
        addButton.addActionListener(e -> addSoftSkill());

        JButton saveButton = new JButton("Save Job Type");
        saveButton.addActionListener(e -> saveJobType());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(saveButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(softSkillsList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void addSoftSkill() {
        String skill = softSkillField.getText().trim();
        if (!skill.isEmpty() && softSkills.add(skill)) {
            listModel.addElement(skill);
            softSkillField.setText("");
        }
    }

    private void saveJobType() {
        // Logic to save job type with soft skills
        JOptionPane.showMessageDialog(this, "Job Type saved with " + softSkills.size() + " soft skills.");
    }
}