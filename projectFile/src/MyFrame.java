import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{ // Implements the method "MyFrame" so it can be used in main.

    // JButton TestButton;          //*****This globaly identifies "TestButton" as a JButton so that the public method "actionPerformed" can annalyze when the button is pressed
    // JTextField TestText;         //*****This globaly identified "TestText" as a JTextField so that the public method "actionPerformed" can annalyze the contents of the TextBox
    MyFrame() {
        // TestButton = new JButton("Display Text");            //*****Declares the new JButton labeled "TestButton" (The button will also display text that says "Display Text")
        // TestText = new JTextField("Display Text");           //*****Declares the new JTextField labeled "TestText" (The textbox will also display text that says "Display Text")

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        // Sets the JFrame so that the window will, by default, close when the x is clicked in the top right corner
        this.setLayout(null);           // Set's the layout of the JFrame as "null" (or none) since I'm not sure which layout we want to use yet (We can discuss this at one of our meetings on an upcoming Thursday)
        this.setSize(500,600);      // Set's the JFrame's default size. This is very changable, but I thought this is a moderate size for a small app that's easy to use.

        // TestButton.setBounds(50, 375, 400, 50);          //*****Set's the dimensions of the button. It's displayed at 50 x, and 375 y (50 to the right, and 375 down) and it's size is 400x50 (400 wide, 50 height)
        // TestButton.addActionListener(this);          //*****Add's a function to the button that allows for the method "actionPerformed" to react accourdingly to when the button is pressed.
        // this.add(TestButton);            //*****Add's "TestButton" to the UI.

        // TestText.setBounds(150,200,200,100);         //*****Set's the dimensions of the textbox. 
        // TestText.setEditable(true);          //*****Allows for the user to edit the text in "TestText" until it's set to false.
        // this.add(TestText);          //*****Add's "TestText" to the UI.

        this.setVisible(true); // Set's the JFrame and all variables listed above as Visible upon startup.
    }
    @Override
    public void actionPerformed(ActionEvent e){
        // if(e.getSource()==TestButton) {          //*****Scans for when "TestButton" is pressed.
        //     TestButton.setVisible(false);            //*****Makes "TestButton" invisible and un-pressable.
        //     System.out.println(TestText.getText());          //*****Print's whatever is written in "TestText" to the terminal.
        //     TestText.setEditable(false);         //*****Disallows users from editing the text within "TestText" until it's set to true again (Which can't happen in this example).
        // }
    }
}