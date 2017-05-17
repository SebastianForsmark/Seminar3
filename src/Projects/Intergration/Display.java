package Projects.Intergration;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Controls the queue number display outside the garage. Created as a singleton
 */
class Display {
    private static final Display DISPLAY = new Display();
    private int queueNumber = -1;
    private JLabel queueNumberLabel = new JLabel("", SwingConstants.CENTER);

    /**
     * Connects to the queue number display and displays the number <code>zero</code>.
     */
    private Display() {
        nextNumber();
        contactDisplay();
    }

    static Display getDisplay() {
        return DISPLAY;
    }

    /**
     * Increments the displayed number.
     */
    final void nextNumber() {
        queueNumberLabel.setText(Integer.toString(++queueNumber));
    }

    /**
     * Initiates the <code>Display</code> and graphical interface of it.
     */
    private void contactDisplay() {
        String HEADER = "Now Serving: ";
        JFrame frame = new JFrame(HEADER);
        Font labelFont = new Font(Font.SERIF, Font.BOLD, 30);
        queueNumberLabel.setFont(labelFont);
        frame.getContentPane().setBackground(Color.BLACK);
        queueNumberLabel.setForeground(Color.WHITE);
        frame.getContentPane().add(queueNumberLabel);
        frame.setBounds(600, 0, 200, 80);
        frame.setVisible(true);
    }

    void resetDisplay() {
        queueNumber = 0;
    }

    /**
     * Gets the <code>queueNumber</code>
     *
     * @return Current <code>queueNumber</code>
     */
    int getQueueNumber() {
        return queueNumber;
    }
}