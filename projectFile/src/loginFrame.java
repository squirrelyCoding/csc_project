import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class loginFrame extends JFrame{
    //private JButton managerButton, employeeButton;
    private JLabel userLabel, passwordLabel;
    private JTextField userInput, passwordInput;
    private JButton loginButton, signUpButton;

    loginFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(494, 600);
        this.getContentPane().setBackground(new Color(123, 164, 176));


        this.setTitle("Blue Rise Management");
        String imagePath = "C:/Users/User/Downloads/BlueRiseManagement.png"; // Absolute path to logo
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH); // Resize to 200x200
            icon = new ImageIcon(scaledImage);
            this.setIconImage(scaledImage);
        } else {
            System.err.println("Image not found at path: " + imagePath);
        }

        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(55, 40, 350, 300); // Set position and size (x, y, width, height)
        this.add(imageLabel);

        userLabel = new JLabel("Username: ");
        userLabel.setBounds(50, 320, 100, 30);

        userInput = new JTextField();
        userInput.setBounds(150, 320, 200, 30);

        passwordLabel = new JLabel("Password: ");
        passwordLabel.setBounds(50, 380, 100, 30);

        passwordInput = new JTextField();
        passwordInput.setBounds(150, 380, 200, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(120, 450, 100, 30);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(240, 450, 100, 30);

        this.add(userLabel);
        this.add(userInput);
        this.add(passwordLabel);
        this.add(passwordInput);
        this.add(loginButton);
        this.add(signUpButton);
        

        if (userInput.getText().equals("manager") && passwordInput.getText().equals("password")){
            loginButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "Login Successful!");
            
                    /*loginFrame frame = new loginFrame();
                    frame.setVisible(true);
                    dispose(); // Close the current frame */
                }
            });
            JOptionPane.showMessageDialog(null, "Login Successful!");
        }
        
        // //Creates manager button
        // managerButton = new JButton("Manager");

        //  // Set position and size (x, y, width, height)
        // managerButton.setBounds(150, 350, 200, 30);
        // managerButton.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         MyFrame frame = new MyFrame();
        //         frame.setVisible(true);
        //         dispose(); // Close the current frame
        //     }
        // });

        // this.add(managerButton);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
