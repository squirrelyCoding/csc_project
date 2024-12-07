import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MyFrame extends JFrame implements ActionListener{ // Implements the method "MyFrame" so it can be used in main.

    private String Depth = "EmpOptions";
    private String PermLVL = "Employee";
    private JLabel label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11, label12, label13;
    private JTextArea infoDisplay;
    private JTextField enterField1, enterField2, enterField3, enterField4, enterField5, enterField6;
    private JComboBox<String> hardBox1, hardBox2, hardBox3, softBox1, softBox2, softBox3, permBox;
    private JButton saveButton, viewButton, editButton, delButton, backButton, myInfoButton, searchButton, saveEmpButton, viewEmpButton;
    private JScrollPane scroll;
    private newMember currentEmployee;

    MyFrame() {
        String Access = "";
        try {
        Access = App.getPerms(1);
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
        setPerm(Access);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(494,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        this.getContentPane().setBackground(new Color(123, 164, 176));

        // Create labels
        label1 = new JLabel("First Name:");
        label2 = new JLabel("Last Name:");
        label3 = new JLabel("Age:");
        label4 = new JLabel("Email:");
        label5 = new JLabel("Phone Number (###-###-####):");
        label6 = new JLabel("Date Hired (mm/dd/yyyy):");
        label7 = new JLabel("Hardskill 1 (Required):");
        label8 = new JLabel("Hardskill 2:");
        label9 = new JLabel("Hardskill 3:");
        label10 = new JLabel("Softskill 1:");
        label11 = new JLabel("Softskill 2:");
        label12 = new JLabel("Softskill 3:");
        label13 = new JLabel("Permission Level:");

        // Create scrollPane
        infoDisplay = new JTextArea();
        scroll = new JScrollPane(infoDisplay);

        // Create textFields
        enterField1 = new JTextField();
        enterField2 = new JTextField();
        enterField3 = new JTextField();
        enterField4 = new JTextField();
        enterField5 = new JTextField();
        enterField6 = new JTextField();

        // Create dropdown for skills
        String[] hardSkillOptions = {"--", "Java", "Python", "C++", "JavaScript"};
        String[] softSkillOptions = {"--", "Leadership", "Integrity", "Creative", "Patience"};
        String[] permBoxOptions = {"Employee", "Moderator", "Admin", "HR"};
        hardBox1 = new JComboBox<>(hardSkillOptions);
        hardBox2 = new JComboBox<>(hardSkillOptions);
        hardBox3 = new JComboBox<>(hardSkillOptions);
        softBox1 = new JComboBox<>(softSkillOptions);
        softBox2 = new JComboBox<>(softSkillOptions);
        softBox3 = new JComboBox<>(softSkillOptions);
        permBox = new JComboBox<>(permBoxOptions);

        // Create buttons
        saveButton = new JButton("Save");
        viewButton = new JButton("View");
        editButton = new JButton("Edit");
        delButton = new JButton("Delete");
        backButton = new JButton("Back");
        myInfoButton = new JButton("View My Info");
        searchButton = new JButton("Search");
        saveEmpButton = new JButton("Add An Employee");
        viewEmpButton = new JButton("View Employees");

        // Set bounds for components
        myInfoButton.setBounds(140, 400, 200, 30);
        if (Access.equals("Moderator") || Access.equals("Admin") || Access.equals("HR") || Access.equals("Dev/Owner")) {
            viewEmpButton.setBounds(140, 450, 200, 30);
        }
        if (Access.equals("Admin") || Access.equals("HR") || Access.equals("Dev/Owner")) {
            saveEmpButton.setBounds(140, 500, 200, 30);
        }

        infoDisplay.setEditable(false);

        // Add action listeners
        saveButton.addActionListener(this);
        viewButton.addActionListener(this);
        editButton.addActionListener(this);
        delButton.addActionListener(this);
        backButton.addActionListener(this);
        myInfoButton.addActionListener(this);
        searchButton.addActionListener(this);
        saveEmpButton.addActionListener(this);
        viewEmpButton.addActionListener(this);

        // Add components to frame
        this.add(enterField1);
        this.add(enterField2);
        this.add(enterField3);
        this.add(enterField4);
        this.add(enterField5);
        this.add(enterField6);

        this.add(hardBox1);
        this.add(hardBox2);
        this.add(hardBox3);
        this.add(softBox1);
        this.add(softBox2);
        this.add(softBox3);
        this.add(permBox);

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
        this.add(label13);

        this.add(scroll);

        this.add(saveButton);
        this.add(viewButton);
        this.add(editButton);
        this.add(delButton);
        this.add(backButton);
        this.add(myInfoButton);
        this.add(myInfoButton);
        this.add(searchButton);
        this.add(saveEmpButton);
        this.add(viewEmpButton);

        // Setting the frame and startup components to "visible"
        this.setVisible(true);

            // temps
            // saveButton.setVisible(false);
            // viewButton.setVisible(false);

    }
    // Getters
    public String getDepth() {
        return Depth;
    }
    public String getPerm() {
        return PermLVL;
    }
    // Setters
    public void setDepth(String Depth) {
        this.Depth = Depth;
    }
    public void setPerm(String PermLVL) {
        this.PermLVL = PermLVL;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        String Layer = getDepth();
        String Access = getPerm();
        String tempStr = "";
        String ErrorMSG = "";
        if (e.getSource() == saveEmpButton && Layer.equals("EmpOptions")) { // 1st layer
            setDepth("AddEmp");
        } else if (e.getSource() == viewEmpButton && Layer.equals("EmpOptions")) {
            setDepth("ViewEmp");
            try {
                infoDisplay.setText(App.getInfo("Full"));
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            } else if (e.getSource() == saveButton && Layer.equals("AddEmp")) { // 2nd layer
                //Verification Process
                if ((enterField1.getText().equals("") || enterField2.getText().equals("") || enterField3.getText().equals("")
                || enterField4.getText().equals("") || enterField5.getText().equals("") || enterField6.getText().equals("")
                || hardBox1.getSelectedItem().equals("--"))) {
                    ErrorMSG = "Data entry missing somewhere!";
                } else {
                    if (!(ver.Verify(enterField1.getText(), "Name"))) {
                        ErrorMSG = ErrorMSG + "| First Name is not Valid |\n";
                    }
                    if (!(ver.Verify(enterField2.getText(), "Name"))) {
                        ErrorMSG = ErrorMSG + "| Last Name is not Valid |\n";
                    }
                    if (!(ver.Verify(enterField3.getText(), "Age"))) {
                        ErrorMSG = ErrorMSG + "| Age is not Valid |\n";
                    }
                    if (!(ver.Verify(enterField4.getText(), "Email"))) {
                        ErrorMSG = ErrorMSG + "| Email is not Valid |\n";
                    }
                    if (!(ver.Verify(enterField5.getText(), "Number"))) {
                        ErrorMSG = ErrorMSG + "| Phone Number is not Valid |\n";
                    }
                    if (!(ver.Verify(enterField6.getText(), "Date"))) {
                        ErrorMSG = ErrorMSG + "| Date hired is not Valid |\n";
                    }
                    // Saving Data
                    if (ErrorMSG.equals("")) {
                        try {
                            tempStr = ("" + enterField1.getText() + " " + enterField2.getText()); 
                            // Saves data to the Database
                            if (App.empCount()) {
                                App.saveInfo(tempStr, enterField3.getText(), enterField4.getText(), enterField5.getText(), enterField6.getText(),
                                hardBox1.getSelectedItem().toString(), hardBox2.getSelectedItem().toString(), hardBox3.getSelectedItem().toString(),
                                softBox1.getSelectedItem().toString(), softBox2.getSelectedItem().toString(), softBox3.getSelectedItem().toString(), permBox.getSelectedItem().toString());
                                JOptionPane.showMessageDialog(this, "Employee data has been saved!", "Confirmation", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(this, "Uh-oh! There's no room to add an employee", "Database Full", JOptionPane.INFORMATION_MESSAGE);
                            }
                            //clears the fields
                            enterField1.setText("");
                            enterField2.setText("");
                            enterField3.setText("");
                            enterField4.setText("");
                            enterField5.setText("");
                            enterField6.setText("");
                            hardBox1.setSelectedItem("--");
                            hardBox2.setSelectedItem("--");
                            hardBox3.setSelectedItem("--");
                            softBox1.setSelectedItem("--");
                            softBox2.setSelectedItem("--");
                            softBox3.setSelectedItem("--");

                            setDepth("EmpOptions");
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                if (!(ErrorMSG.equals(""))) {
                    JOptionPane.showMessageDialog(this, ErrorMSG, "ERROR", JOptionPane.INFORMATION_MESSAGE);
                }
            } else if (e.getSource() == backButton && Layer.equals("AddEmp")) {
                setDepth("EmpOptions");
            } else if (e.getSource() == editButton && Layer.equals("ViewEmp")) {
            } else if (e.getSource() == delButton && Layer.equals("ViewEmp")) {
            } else if (e.getSource() == backButton && Layer.equals("ViewEmp")) {
            setDepth("EmpOptions");
        }

        // Back-end of Layer change
        Layer = getDepth();
        Access = getPerm();

        if (Layer.equals("EmpOptions")) { // 1st layer
            // On-Screen(Bounds)
            myInfoButton.setBounds(140, 400, 200, 30);
            if (Access.equals("Moderator") || Access.equals("Admin") || Access.equals("HR") || Access.equals("Dev/Owner")) {
                viewEmpButton.setBounds(140, 450, 200, 30);
            }
            if (Access.equals("Admin") || Access.equals("HR") || Access.equals("Dev/Owner")) {
                saveEmpButton.setBounds(140, 500, 200, 30);
            }
            // On-Screen(Visibility)
            saveEmpButton.setVisible(true);
            viewEmpButton.setVisible(true);
            myInfoButton.setVisible(true);

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
            label13.setVisible(false);
            scroll.setVisible(false);
            enterField1.setVisible(false);
            enterField2.setVisible(false);
            enterField3.setVisible(false);
            enterField4.setVisible(false);
            enterField5.setVisible(false);
            enterField6.setVisible(false);
            hardBox1.setVisible(false);
            hardBox2.setVisible(false);
            hardBox3.setVisible(false);
            softBox1.setVisible(false);
            softBox2.setVisible(false);
            softBox3.setVisible(false);
            permBox.setVisible(false);
            saveButton.setVisible(false);
            viewButton.setVisible(false);
            editButton.setVisible(false);
            searchButton.setVisible(false);
            backButton.setVisible(false);
        
        // 2nd level Layers
            
            } else if (Layer.equals("ViewEmp")) { // 2nd layer
                // On-Screen(Bounds)
                scroll.setBounds(20, 20, 440, 400);
                searchButton.setBounds(100, 430, 280, 30);
                if (Access.equals("HR") || Access.equals("Dev/Owner")) {
                    editButton.setBounds(100, 470, 280, 30);
                    backButton.setBounds(100, 510, 280, 30);
                } else {
                    backButton.setBounds(100, 470, 280, 30);
                }
                // On-Screen(Visibility)
                scroll.setVisible(true);
                searchButton.setVisible(true);
                if (Access.equals("HR") || Access.equals("Dev/Owner")) {
                    editButton.setVisible(true);
                }
                backButton.setVisible(true);

                // Off-Screen
                saveEmpButton.setVisible(false);
                viewEmpButton.setVisible(false);
                myInfoButton.setVisible(false);
            } else if (Layer.equals("AddEmp")) {
                // On-Screen(Bounds)
                label1.setBounds(30, 20, 100, 30);
                label2.setBounds(30, 50, 100, 30);
                label3.setBounds(30, 80, 100, 30);
                label4.setBounds(30, 110, 100, 30);
                label5.setBounds(30, 140, 200, 30);
                label6.setBounds(30, 170, 200, 30);
                label7.setBounds(30, 200, 200, 30);
                label8.setBounds(30, 230, 100, 30);
                label9.setBounds(30, 260, 100, 30);
                label10.setBounds(30, 290, 100, 30);
                label11.setBounds(30, 320, 100, 30);
                label12.setBounds(30, 350, 100, 30);
                label13.setBounds(30, 380, 200, 30);
                enterField1.setBounds(225, 24, 200, 25);
                enterField2.setBounds(225, 54, 200, 25);
                enterField3.setBounds(225, 84, 200, 25);
                enterField4.setBounds(225, 114, 200, 25);
                enterField5.setBounds(225, 144, 200, 25);
                enterField6.setBounds(225, 174, 200, 25);
                hardBox1.setBounds(225, 204, 200, 25);
                hardBox2.setBounds(225, 234, 200, 25);
                hardBox3.setBounds(225, 264, 200, 25);
                softBox1.setBounds(225, 294, 200, 25);
                softBox2.setBounds(225, 324, 200, 25);
                softBox3.setBounds(225, 354, 200, 25);
                permBox.setBounds(225, 384, 200, 25);
                saveButton.setBounds(100, 450, 280, 30);
                backButton.setBounds(100, 500, 280, 30);

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
                hardBox1.setVisible(true);
                hardBox2.setVisible(true);
                hardBox3.setVisible(true);
                softBox1.setVisible(true);
                softBox2.setVisible(true);
                softBox3.setVisible(true);
                permBox.setVisible(true);
                saveButton.setVisible(true);
                backButton.setVisible(true);

                // Off-Screen
                saveEmpButton.setVisible(false);
                viewEmpButton.setVisible(false);
                myInfoButton.setVisible(false);
        }
    }
}