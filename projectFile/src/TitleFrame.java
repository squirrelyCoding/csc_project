import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TitleFrame extends JFrame {

    TitleFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Use null layout for absolute positioning
        this.setLayout(null);
        this.setSize(494, 600);
        this.getContentPane().setBackground(new Color(123, 164, 176)); //sets background color to the light blue

        // Set the title and managemnet logo
        this.setTitle("Blue Rise Management");
        String imagePath = "C:/Users/User/Downloads/BlueRiseManagement.png"; // Absolute path to logo
        ImageIcon icon = new ImageIcon(imagePath);
        if (icon.getImageLoadStatus() == MediaTracker.COMPLETE) {
            Image image = icon.getImage();
            // Resize to 200x200
            Image scaledImage = image.getScaledInstance(350, 300, Image.SCALE_SMOOTH); 
            icon = new ImageIcon(scaledImage);
            this.setIconImage(scaledImage);
        } else {
            System.err.println("Image not found at path: " + imagePath);
        }

        // Adds a label to display the image
        JLabel imageLabel = new JLabel(icon);
        imageLabel.setBounds(55, 40, 350, 300); // Set position and size (x, y, width, height)
        this.add(imageLabel);

        JButton navigateButton = new JButton("Let's Get Started");
        // Set position and size (x, y, width, height)
        navigateButton.setBounds(150, 350, 200, 30);
        navigateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loginFrame frame = new loginFrame();
                frame.setVisible(true);
                dispose(); // Close the current frame
            }
        });

        // Add the button to the frame
        this.add(navigateButton);
        // Center the frame on the screen
        this.setLocationRelativeTo(null); 
        this.setVisible(true);
    }
}
