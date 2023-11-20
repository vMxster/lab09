package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private final static int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();
    private final static int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();
    private final static int PROPORTION = 5;

    private final JFrame frame;

    public SimpleGUI() {
        this.frame = new JFrame();
        this.frame.setTitle("My first Java graphical interface");
        JPanel panel = new JPanel(new BorderLayout());
        JButton saveButton = new JButton("SAVE");
        JTextArea textArea = new JTextArea();
        panel.add(saveButton, BorderLayout.SOUTH);
        panel.add(textArea, BorderLayout.CENTER);
        this.frame.setContentPane(panel);
    }

    public void display() {
        frame.setSize(SCREEN_WIDTH / PROPORTION, SCREEN_HEIGHT / PROPORTION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SimpleGUI gui = new SimpleGUI();
        gui.display();
    }

}
