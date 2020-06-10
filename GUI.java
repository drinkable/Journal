import javax.swing.*;

public class GUI {
    private JTextField textField1;
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private JPanel panel;
}
