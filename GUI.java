import javax.swing.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    JFrame frame;
    JPanel contentPane;

    public GUI() {

        // Set up frame
        frame = new JFrame("JOURNAL APPLICATION");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up panel
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        // Finalize frame
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setVisible(true);
    
    }

    public void actionPerformed(ActionEvent event) {

    }

    /**
     * Create and show the GUI.
     */
    private static void runGUI() {

        JFrame.setDefaultLookAndFeelDecorated(true);

        GUI journalGUI = new GUI();

    }

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }

}
