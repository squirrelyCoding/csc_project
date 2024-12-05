import java.awt.*;
import javax.swing.*;

public class TitleFrame extends JFrame {

    TitleFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null); // Use null layout for absolute positioning
        this.setSize(500, 600);
        this.getContentPane().setBackground(new Color(123, 164, 176)); //sets background color to the light blue

        // Set the title and icon
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

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new TitleFrame();
    }
}
