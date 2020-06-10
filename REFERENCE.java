/*
 * LatinPlantNames.java from Chapter 10
 * Displays the latin name for a selected plant.
 * Lawrenceville Press
 * June 10, 2011
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class REFERENCE implements ActionListener {
	JFrame frame;
	JPanel contentPane;
	JComboBox plantNames;
	JLabel plantListPrompt, latinName;

    public REFERENCE(){
        /* Create and set up the frame */
        frame = new JFrame("LatinPlantNames");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Create a content pane with a BoxLayout and empty borders */
        contentPane = new JPanel();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		/* Create a combo box and a descriptive label */
	    plantListPrompt = new JLabel("Select a plant name: ");
	    plantListPrompt.setAlignmentX(JLabel.LEFT_ALIGNMENT);
	    contentPane.add(plantListPrompt);

	    String[] names = {"basil", "lavender", "parsley", "peppermint", "saffron", "sage"};
	    plantNames = new JComboBox(names);
	    plantNames.setAlignmentX(JComboBox.LEFT_ALIGNMENT);
	    plantNames.setSelectedIndex(0);
	    plantNames.addActionListener(this);
	    contentPane.add(plantNames);

		/* Create and add a label that will display the Latin names */
	    latinName = new JLabel("Ocimum");
	    latinName.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
	    contentPane.add(latinName);

		/* Add content pane to frame */
        frame.setContentPane(contentPane);

        /* Size and then display the frame. */
        frame.pack();
        frame.setVisible(true);
    }


	/**
	 * Handle a selection from the combo box
	 * pre: none
	 * post: The Latin name for the selected plant has been displayed.
	 */
    public void actionPerformed(ActionEvent event) {
		JComboBox comboBox = (JComboBox)event.getSource();
		String plantName = (String)comboBox.getSelectedItem();

		if (plantName == "basil") {
			latinName.setText("Ocimum");
		} else if (plantName == "lavender") {
			latinName.setText("Lavandula spica");
		} else if (plantName == "parsley") {
			latinName.setText("Apium");
		} else if (plantName == "perppermint") {
			latinName.setText("Mentha piperita");
		} else if (plantName == "saffron") {
			latinName.setText("Crocus");
		} else if (plantName == "sage") {
			latinName.setText("Salvia");
		}
    }


    /**
     * Create and show the GUI.
     */
    private static void runGUI() {
        JFrame.setDefaultLookAndFeelDecorated(true);

        REFERENCE spices = new REFERENCE();
    }


    public static void main(String[] args) {
        /* Methods that create and show a GUI should be
           run from an event-dispatching thread */
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                runGUI();
            }
        });
    }
}
