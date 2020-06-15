import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

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
    Journal currentEntry;
    final static File dir = new File("JournalEntries");

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

        String[] list = initEntries();
        entryList = new JComboBox(list);
        entryList.addActionListener(new SelectEntryListener());
        gbc.ipady = 7;
        gbc.ipadx = 90;
        gbc.gridx = 3;
        gbc.gridy = 3;
        contentPane.add(entryList, gbc);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveListener());
        gbc.gridx = 0;
        gbc.gridy = 4;
        contentPane.add(saveButton, gbc);

        deleteButton = new JButton("Delete");
        deleteButton.addActionListener(new DeleteListener());
        gbc.gridx = 0;
        gbc.gridy = 5;
        contentPane.add(deleteButton, gbc);

        newButton = new JButton("New");
        newButton.addActionListener(new NewListener());
        gbc.gridx = 0;
        gbc.gridy = 6;
        contentPane.add(newButton, gbc);

        // Finalize frame
        frame.getContentPane().setPreferredSize(new Dimension(700, 620));
        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public static String[] initEntries() {

        File[] files = dir.listFiles();

        int count = 0;
        String[] entryNames = new String[50];

        for (File entry : files) {

            String fileName[] = entry.getName().split("\\.");

            entryNames[count] = fileName[0];

            count++;

        }

        return entryNames;

    }

    /**
     * Create and show the GUI.
     */
    private static void runGUI() {

        GUI journalGUI = new GUI();

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }

    class SaveListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            currentEntry.setName(entryName.getText().toString());
            currentEntry.setBody(entryBody.getText().toString());

        }

    }

    class DeleteListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            currentEntry.deleteEntry();

            String name = entryName.getText().toString();
            entryList.removeItem(makeObj(name));

        }

    }

    class NewListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            String name = entryName.getText().toString();

            currentEntry = new Journal(name);
            currentEntry.writeEntry(entryBody.getText().toString());

            entryList.addItem(makeObj(name));

        }

    }

    private Object makeObj(final String item) {
        return new Object() {
            public String toString() {
                return item;
            }
        };
    }

    class SelectEntryListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {

            currentEntry = new Journal(entryList.getSelectedItem().toString());

            entryName.setText(currentEntry.getName());

            String body = currentEntry.getBody();
            entryBody.setText(body);

        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
