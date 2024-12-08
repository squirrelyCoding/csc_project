import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleFrame extends JFrame {

    TitleFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Use null layout for absolute positioning
        this.setSize(494, 600);
        this.getContentPane().setBackground(new Color(123, 164, 176)); //sets background color to the light blue

        // Set the title and managemnet logo
        this.setTitle("Employee Management System");
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

        // Add a label to display the image
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(55, 40, 350, 300); // Set position and size (x, y, width, height)
        this.add(imageLabel);

        JButton navigateButton = new JButton("Let's Get Started");
        navigateButton.setBounds(150, 350, 200, 30); // Set position and size (x, y, width, height)
        navigateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyFrame frame = new MyFrame();
                frame.setVisible(true);
                dispose(); // Close the current frame
            }
        });

        // Add the button to the frame
        this.add(navigateButton);

        this.setLocationRelativeTo(null); // Center the frame on the screen

        this.setVisible(true);
    }
}
