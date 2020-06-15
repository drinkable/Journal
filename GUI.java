import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener {
    JFrame frame;
    JPanel contentPane;
    GridBagConstraints gbc;
    JLabel entryNameLabel, entryDateLabel, entryDate, banner;
    JTextField entryName;
    JTextArea entryBody;
    JComboBox entryList;
    JButton saveButton, deleteButton, newButton;
    JScrollPane scroll;

    public GUI() {

        // Set up frame
        frame = new JFrame("JOURNAL APPLICATION");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set up panel
        contentPane = new JPanel();
        contentPane.setLayout(new GridBagLayout());
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contentPane.setBackground(new ColorUIResource(253, 215, 228));

        gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;

        banner = new JLabel(new ImageIcon("banner.png"));
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(banner, gbc);

        entryNameLabel = new JLabel("Name:");
        gbc.weightx = 2;
        gbc.gridx = 0;
        gbc.gridy = 1;
        contentPane.add(entryNameLabel, gbc);

        entryDateLabel = new JLabel("Date:");
        gbc.gridx = 1;
        gbc.gridy = 1;
        contentPane.add(entryDateLabel, gbc);

        entryName = new JTextField("Name");
        gbc.gridx = 0;
        gbc.gridy = 2;
        contentPane.add(entryName, gbc);

        entryDate = new JLabel("Date");
        gbc.gridx = 1;
        gbc.gridy = 2;
        contentPane.add(entryDate, gbc);

        entryBody = new JTextArea("Entry journal entry here.");

        scroll = new JScrollPane(entryBody, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        gbc.ipady = 400;
        gbc.ipadx = 340;
        gbc.gridwidth = 4;
        gbc.gridx = 0;
        gbc.gridy = 3;
        contentPane.add(scroll, gbc);

        entryList = new JComboBox();
        gbc.ipady = 7;
        gbc.ipadx = 90;
        gbc.gridx = 3;
        gbc.gridy = 3;
        contentPane.add(entryList, gbc);

        saveButton = new JButton("Save");
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPane.add(saveButton, gbc);

        deleteButton = new JButton("Delete");
        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPane.add(deleteButton, gbc);

        newButton = new JButton("New");
        gbc.gridx = 0;
        gbc.gridy = 6;
        contentPane.add(newButton, gbc);

        // Finalize frame
        frame.getContentPane().setPreferredSize(new Dimension(700, 600));
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
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
