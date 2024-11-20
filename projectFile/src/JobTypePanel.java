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
import javax.swing.ListSelectionModel;

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
        softSkillsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        inputPanel.add(new JLabel("Job Title:"));
        inputPanel.add(jobTitleField);
        inputPanel.add(new JLabel("Soft Skill:"));
        inputPanel.add(softSkillField);

        JButton addButton = new JButton("Add Skill");
        addButton.setOpaque(true);
        addButton.setBorderPainted(false);
        addButton.addActionListener(e -> addSoftSkill());

        JButton deleteButton = new JButton("Delete Skill");
        deleteButton.setOpaque(true);
        deleteButton.setBorderPainted(false);
        deleteButton.addActionListener(e -> deleteSoftSkill());

        JButton saveButton = new JButton("Save Job Type");
        saveButton.setOpaque(true);
        saveButton.setBorderPainted(false);
        saveButton.addActionListener(e -> saveJobType());

        JButton viewButton = new JButton("View Job Type");
        viewButton.setOpaque(true);
        viewButton.setBorderPainted(false);
        viewButton.addActionListener(e -> viewJobType());
        
        JButton editButton = new JButton("Edit Skill");
        editButton.setOpaque(true);
        editButton.setBorderPainted(false);
        editButton.addActionListener(e -> editSoftSkill());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(editButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(viewButton);

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

    private void deleteSoftSkill() {
        int selectedIndex = softSkillsList.getSelectedIndex();
        if (selectedIndex != -1) {
            String skillToRemove = listModel.getElementAt(selectedIndex);
            listModel.remove(selectedIndex);
            softSkills.remove(skillToRemove);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a skill to delete.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void editSoftSkill() {
        int selectedIndex = softSkillsList.getSelectedIndex();
        if (selectedIndex != -1) {
            String currentSkill = listModel.getElementAt(selectedIndex);
            String newSkill = JOptionPane.showInputDialog(this, "Edit Soft Skill:", currentSkill);
            if (newSkill != null && !newSkill.trim().isEmpty()) {
                softSkills.remove(currentSkill);
                softSkills.add(newSkill.trim());
                listModel.setElementAt(newSkill.trim(), selectedIndex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a skill to edit.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void saveJobType() {
        // Logic to save job type with soft skills
        JOptionPane.showMessageDialog(this, "Job Type saved with " + softSkills.size() + " soft skills.");
    }

    private void viewJobType() {
        if (jobTitleField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a job title.", "No Job Title", JOptionPane.WARNING_MESSAGE);
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("Job Title: ").append(jobTitleField.getText()).append("\n\n");
        sb.append("Soft Skills:\n");
        
        if (softSkills.isEmpty()) {
            sb.append("No soft skills added.");
        } else {
            for (String skill : softSkills) {
                sb.append("- ").append(skill).append("\n");
            }
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Job Type Details", JOptionPane.INFORMATION_MESSAGE);
    }
}