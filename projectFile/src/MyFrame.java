import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MyFrame extends JFrame implements ActionListener{

    JButton button;
    MyFrame() {
        button = new JButton();
        button.setBounds(100, 100, 300, 300);
        button.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setVisible(true);
        this.add(button);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button) {
            System.out.println("Button pressed");
        }
    }
}