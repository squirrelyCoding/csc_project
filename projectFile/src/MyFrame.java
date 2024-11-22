import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener{ // Implements the method "MyFrame" so it can be used in main.

    private JTextField nameField, dateHiredField, skillsField, demField;
    private JButton saveButton, editButton, demButton, demSave, demEdit;
    private newMember currentEmployee;

    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,600);

        this.getContentPane().setBackground(new Color(200, 111, 247));

        // Create textFields
        nameField = new JTextField(20);
        dateHiredField = new JTextField(20);
        skillsField = new JTextField(20);
        demField = new JTextField(30);

        // Create buttons
        saveButton = new JButton("Save Employee");
        editButton = new JButton("Edit Employee");
        demButton = new JButton("Demographics");
        demSave = new JButton("Save Demographics");
        demEdit = new JButton("Edit Demographics");

        // Set bounds for components
        nameField.setBounds(150, 50, 200, 30);
        dateHiredField.setBounds(150, 100, 200, 30);
        skillsField.setBounds(150, 150, 200, 30);
        demField.setBounds (150, 50, 200, 130);
        
        saveButton.setBounds(150, 200, 200, 30);
        editButton.setBounds(150, 250, 200, 30);
        demButton.setBounds(150, 300, 200, 30);
        demSave.setBounds(150, 200, 200, 30);
        demEdit.setBounds(150, 200, 200, 30);

        // Add action listeners
        saveButton.addActionListener(this);
        editButton.addActionListener(this);
        demButton.addActionListener(this);
        demSave.addActionListener(this);
        demEdit.addActionListener(this);
        demField.setEditable(false);

        // Add components to frame
        this.add(new JLabel("Name:")).setBounds(50, 50, 100, 30);
        this.add(nameField);
        this.add(new JLabel("Date Hired:")).setBounds(50, 100, 100, 30);
        this.add(dateHiredField);
        this.add(new JLabel("Skills:")).setBounds(50, 150, 100, 30);
        this.add(skillsField);
        this.add(saveButton);
        this.add(editButton);
        this.add(demField);
        this.add(demButton);
        this.add(demSave);
        this.add(demEdit);

        this.setVisible(true);
        demField.setVisible(false);
        demSave.setVisible(false);
        demEdit.setVisible(false);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        
        if (e.getSource() == saveButton) {
            saveEmployee();
        } else if (e.getSource() == editButton) {
            editEmployee();
        } else if (e.getSource() == demButton || e.getSource() == demSave || e.getSource() == demEdit) {

            saveButton.setVisible(false);
            editButton.setVisible(false);
            demButton.setVisible(false);
            nameField.setVisible(false);
            dateHiredField.setVisible(false);
            skillsField.setVisible(false);

            if (e.getSource() == demButton && demField.equals("")) {
                JOptionPane.showMessageDialog(this, "Employee has no Demographic Data, please enter something to continue.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
                demField.setVisible(true);
                demField.setEditable(true);
                demSave.setVisible(true);
            } else if (e.getSource() == demButton || e.getSource() == demSave) {
                demField.setEditable(false);
                demSave.setVisible(false);
                demField.setVisible(true);
                demEdit.setVisible(true);
            } else if (e.getSource() == demEdit) {
                demEdit.setVisible(false);
                demField.setEditable(true);
                demSave.setVisible(true);
            }
        }
    }

        private void saveEmployee() {
        /* String name = nameField.getText();
        String dateHired = dateHiredField.getText();
        String skills = skillsField.getText(); */

        //placeholder until we get a database set up for saved data
         JOptionPane.showMessageDialog(this, "Employee data has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

         //clears the fields
        nameField.setText("");
        dateHiredField.setText("");
        skillsField.setText("");
    }

    private void editEmployee() {
        // Placeholder for edit functionality
        JOptionPane.showMessageDialog(this, "Edit functionality not implemented yet.", "Edit Employee", JOptionPane.INFORMATION_MESSAGE);
    }

}