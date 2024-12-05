import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MyFrame extends JFrame implements ActionListener{ // Implements the method "MyFrame" so it can be used in main.
    private String Depth = "Home";
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12;
    private JTextArea infoDisplay;
    private JTextField enterField1, enterField2, enterField3, enterField4,enterField5, enterField6, enterField7, enterField8, enterField9, enterField10, enterField11, enterField12;
    private JTextField nameField, ageField, dateHiredField, demField, phoneField, emailField;
    private JComboBox<String> skillsBox;
    private JButton saveButton, viewButton, editButton, delButton, backButton, demButton, demSave, demEdit;
    private JScrollPane scroll;
    private newMember currentEmployee;

    MyFrame() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(494,800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.getContentPane().setBackground(new Color(123, 164, 176));

        // Create labels
        label1 = new JLabel("First Name:");
        label2 = new JLabel("Last Name:");
        label3 = new JLabel("Age:");
        label4 = new JLabel("Email:");
        label5 = new JLabel("Phone Number (###-###-####):");
        label6 = new JLabel("Hardskill 1:");
        label7 = new JLabel("Hardskill 2:");
        label8 = new JLabel("Hardskill 3:");
        label9 = new JLabel("Softskill 1:");
        label10 = new JLabel("Softskill 2:");
        label11 = new JLabel("Softskill 3:");
        label12 = new JLabel("Date Hired (mm/dd/yyyy):");

        // scrollPane
        infoDisplay = new JTextArea();
        scroll = new JScrollPane(infoDisplay);

        // Create textFields
        nameField = new JTextField(20);
        ageField = new JTextField(20);
        dateHiredField = new JTextField(20);
        demField = new JTextField(30);
        phoneField = new JTextField(20);
        emailField = new JTextField(20);
        enterField1 = new JTextField();
        enterField2 = new JTextField();
        enterField3 = new JTextField();
        enterField4 = new JTextField();
        enterField5 = new JTextField();
        enterField6 = new JTextField();
        enterField7 = new JTextField();
        enterField8 = new JTextField();
        enterField9 = new JTextField();
        enterField10 = new JTextField();
        enterField11 = new JTextField();
        enterField12 = new JTextField();

        // Create dropdown for skills
        String[] skillsOptions = {"Java", "Python", "C++", "JavaScript"};
        skillsBox = new JComboBox<>(skillsOptions);

        // Create buttons
        saveButton = new JButton("Save");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        delButton = new JButton("Delete");
        backButton = new JButton("Back");

        // Set bounds for components
        nameField.setBounds(150, 50, 200, 30);
        ageField.setBounds(150, 100, 50, 30); // Corrected bounds for ageField
        dateHiredField.setBounds(150, 150, 200, 30);
        skillsBox.setBounds(150, 200, 200, 30);
        demField.setBounds(150, 250, 200, 130);
        
        saveButton.setBounds(140, 400, 200, 30);
        editButton.setBounds(150, 350, 200, 30);
        viewButton.setBounds(140, 450, 200, 30);
        demButton.setBounds(150, 300, 200, 30);
        demSave.setBounds(150, 200, 200, 30);
        demEdit.setBounds(150, 200, 200, 30);

        infoDisplay.setEditable(false);

        // Add action listeners
        saveButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        delButton.addActionListener(this);
        backButton.addActionListener(this);

        // Add components to frame
        this.add(new JLabel("Name:")).setBounds(50, 50, 100, 30);
        this.add(nameField);
        this.add(new JLabel("Age:")).setBounds(50, 100, 100, 30); // Added label for ageField
        this.add(ageField); // Added ageField to the frame
        this.add(new JLabel("Date Hired:")).setBounds(50, 100, 100, 30);
        this.add(dateHiredField);
        this.add(new JLabel("Skills:")).setBounds(50, 150, 100, 30);
        this.add(skillsBox);
        this.add(demField);
        this.add(enterField1);
        this.add(enterField2);
        this.add(enterField3);
        this.add(enterField4);
        this.add(enterField5);
        this.add(enterField6);
        this.add(enterField7);
        this.add(enterField8);
        this.add(enterField9);
        this.add(enterField10);
        this.add(enterField11);
        this.add(enterField12);

        this.add(label1);
        this.add(label2);
        this.add(label3);
        this.add(label4);
        this.add(label5);
        this.add(label6);
        this.add(label7);
        this.add(label8);
        this.add(label9);
        this.add(label10);
        this.add(label11);
        this.add(label12);

        this.add(scroll);

        this.add(saveButton);
        this.add(viewButton);
        this.add(editButton);
        this.add(demButton);
        this.add(demSave);
        this.add(demEdit);
        this.add(delButton);
        this.add(backButton);

        // Setting the frame to visible while setting all non-startup variables to false
        this.setVisible(true);
            // labels
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            label12.setVisible(false);

            // scrollPane
            scroll.setVisible(false);

            // textFields
            enterField1.setVisible(false);
            enterField2.setVisible(false);
            enterField3.setVisible(false);
            enterField4.setVisible(false);
            enterField5.setVisible(false);
            enterField6.setVisible(false);
            enterField7.setVisible(false);
            enterField8.setVisible(false);
            enterField9.setVisible(false);
            enterField10.setVisible(false);
            enterField11.setVisible(false);
            enterField12.setVisible(false);

            // buttons
            editButton.setVisible(false);
            delButton.setVisible(false);
            backButton.setVisible(false);

            // temps
            // saveButton.setVisible(false);
            // viewButton.setVisible(false);
    }
    public String getDepth() {
        return Depth;
    }
    public void setDepth(String Depth) {
        this.Depth = Depth;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Layer = getDepth();
        String tempStr = "";
        // 1st Level layer
        if (e.getSource() == saveButton && Layer.equals("Home")) {
            setDepth("AddEmp");
        } else if (e.getSource() == saveButton && Layer.equals("AddEmp")) {
            try {
                
                tempStr = ("" + enterField1.getText() + " " + enterField2.getText()); 
                // Saves data to the Database
                App.saveInfo(tempStr, enterField3.getText(),
                enterField4.getText(), enterField5.getText(), enterField6.getText(),
                enterField7.getText(), enterField8.getText(), enterField9.getText(),
                enterField10.getText(), enterField11.getText(), enterField12.getText());
                JOptionPane.showMessageDialog(this, "Employee data has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);

                //clears the fields
                enterField1.setText("");
                enterField2.setText("");
                enterField3.setText("");
                enterField4.setText("");
                enterField5.setText("");
                enterField6.setText("");
                enterField7.setText("");
                enterField8.setText("");
                enterField9.setText("");
                enterField10.setText("");
                enterField11.setText("");
                enterField12.setText("");

                setDepth("Home");
            } catch (SQLException e1) {
                    e1.printStackTrace();
            }
        // } else if (e.getSource() == editButton) {
        //     editEmployee();
        // } else if (e.getSource() == demButton || e.getSource() == demSave || e.getSource() == demEdit) { //Demographics section

        //     saveButton.setVisible(false);
        //     editButton.setVisible(false);
        //     demButton.setVisible(false);
        //     nameField.setVisible(false);
        //     dateHiredField.setVisible(false);
        //     skillsField.setVisible(false);

        //     tempStr = demField.getText();
        //     if (e.getSource() == demButton && tempStr.equals("")) { //First Open
        //         JOptionPane.showMessageDialog(this, "Employee has no Demographic Data, please enter something to continue.", "ERROR", JOptionPane.INFORMATION_MESSAGE);
        //         demField.setVisible(true);
        //         demField.setEditable(true);
        //         demSave.setVisible(true);
        //     } else if (e.getSource() == demButton || e.getSource() == demSave) { //nth Open
        //         demField.setEditable(false);
        //         demSave.setVisible(false);
        //         demField.setVisible(true);
        //         demEdit.setVisible(true);
        //     } else if (e.getSource() == demEdit) { //Edit Demographics
        //         demEdit.setVisible(false);
        //         demField.setEditable(true);
        //         demSave.setVisible(true);
        //     }
        }

        // Back-end of Layer change
        Layer = getDepth();

        // 1st Level Layer
        if (Layer.equals("Home")) {
            // On-Screen(Bounds)
            saveButton.setBounds(140, 400, 200, 30);
            viewButton.setBounds(140, 450, 200, 30);
            // On-Screen(Visibility)
            saveButton.setVisible(true);
            viewButton.setVisible(true);

            // Off-Screen
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);
            label9.setVisible(false);
            label10.setVisible(false);
            label11.setVisible(false);
            label12.setVisible(false);
            scroll.setVisible(false);
            enterField1.setVisible(false);
            enterField2.setVisible(false);
            enterField3.setVisible(false);
            enterField4.setVisible(false);
            enterField5.setVisible(false);
            enterField6.setVisible(false);
            enterField7.setVisible(false);
            enterField8.setVisible(false);
            enterField9.setVisible(false);
            enterField10.setVisible(false);
            enterField11.setVisible(false);
            enterField12.setVisible(false);
            editButton.setVisible(false);
            delButton.setVisible(false);
            backButton.setVisible(false);
        
        // 2nd level Layers
        } else if (Layer.equals("AddEmp")) {
            // On-Screen(Bounds)
            label1.setBounds(30, 20, 100, 30);
            label2.setBounds(30, 50, 100, 30);
            label3.setBounds(30, 80, 100, 30);
            label4.setBounds(30, 110, 100, 30);
            label5.setBounds(30, 140, 200, 30);
            label6.setBounds(30, 170, 100, 30);
            label7.setBounds(30, 200, 100, 30);
            label8.setBounds(30, 230, 100, 30);
            label9.setBounds(30, 260, 100, 30);
            label10.setBounds(30, 290, 100, 30);
            label11.setBounds(30, 320, 100, 30);
            label12.setBounds(30, 350, 200, 30);
            enterField1.setBounds(225, 24, 200, 25);
            enterField2.setBounds(225, 54, 200, 25);
            enterField3.setBounds(225, 84, 200, 25);
            enterField4.setBounds(225, 114, 200, 25);
            enterField5.setBounds(225, 144, 200, 25);
            enterField6.setBounds(225, 174, 200, 25);
            enterField7.setBounds(225, 204, 200, 25);
            enterField8.setBounds(225, 234, 200, 25);
            enterField9.setBounds(225, 264, 200, 25);
            enterField10.setBounds(225, 294, 200, 25);
            enterField11.setBounds(225, 324, 200, 25);
            enterField12.setBounds(225, 354, 200, 25);
            saveButton.setBounds(100, 400, 280, 30);
            backButton.setBounds(100, 450, 280, 30);

            // On-Screen(Visiblity)
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            label9.setVisible(true);
            label10.setVisible(true);
            label11.setVisible(true);
            label12.setVisible(true);
            enterField1.setVisible(true);
            enterField2.setVisible(true);
            enterField3.setVisible(true);
            enterField4.setVisible(true);
            enterField5.setVisible(true);
            enterField6.setVisible(true);
            enterField7.setVisible(true);
            enterField8.setVisible(true);
            enterField9.setVisible(true);
            enterField10.setVisible(true);
            enterField11.setVisible(true);
            enterField12.setVisible(true);
            backButton.setVisible(true);

            // Off-Screen
            viewButton.setVisible(false);
        } else if (Layer.equals("ViewEmp")) {
            // On-Screen(Bounds)
            scroll.setBounds(20, 20, 440, 600);
            editButton.setBounds(100, 630, 280, 30);
            delButton.setBounds(100, 670, 280, 30);
            backButton.setBounds(100, 710, 280, 30);
            // On-Screen(Visibility)
            scroll.setVisible(true);
            editButton.setVisible(true);
            delButton.setVisible(true);
            backButton.setVisible(true);

            // Off-Screen
            saveButton.setVisible(false);
            viewButton.setVisible(false);
        }
    }

    private void editEmployee() {
        // Placeholder for edit functionality
        JOptionPane.showMessageDialog(this, "Edit functionality not implemented yet.", "Edit Employee", JOptionPane.INFORMATION_MESSAGE);
    }

}