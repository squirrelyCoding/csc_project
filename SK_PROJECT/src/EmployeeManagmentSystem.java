import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

public class EmployeeManagmentSystem {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Employee Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Employee List", new EmployeeListPanel());
            tabbedPane.addTab("Job History", new JobHistoryPanel());
            tabbedPane.addTab("Job Types", new JobTypePanel());
            tabbedPane.addTab("Employee Profile", new EmployeeProfilePanel());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}
