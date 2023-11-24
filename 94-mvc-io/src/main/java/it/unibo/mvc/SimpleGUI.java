package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private final static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    private final static int HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
    private final static int START_PROPORTION = 5;
    private final static int MINIMUM_PROPORTION = 8;

    private final JFrame frame;
    private final Controller controller;

    public SimpleGUI() {
        this.frame = new JFrame();
        this.controller = new SimpleController();
        final JPanel mainPanel = new JPanel();
        final JPanel southPanel = new JPanel();
        final JTextField textField = new JTextField();
        final JTextArea textArea = new JTextArea();
        final JButton printButton = new JButton("Print");
        final JButton historyButton = new JButton("Show History");
        mainPanel.setLayout(new BorderLayout());
        southPanel.setLayout(new FlowLayout());
        mainPanel.add(textField, BorderLayout.NORTH);
        mainPanel.add(textArea, BorderLayout.CENTER);
        mainPanel.add(southPanel, BorderLayout.SOUTH);
        southPanel.add(printButton);
        southPanel.add(historyButton);
        textArea.setEditable(false);
        printButton.addActionListener( e -> {
            controller.setNextStringToPrint(textField.getText());
            controller.printString();
        });
        historyButton.addActionListener( e -> textArea.setText(controller.getHistoryStringPrinted().toString()));
        this.frame.setContentPane(mainPanel);
    }

    public void display() {
        this.frame.setSize(WIDTH / START_PROPORTION, HEIGHT / START_PROPORTION);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setMinimumSize(new Dimension(WIDTH / MINIMUM_PROPORTION, HEIGHT / MINIMUM_PROPORTION));
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        SimpleGUI gui = new SimpleGUI();
        gui.display();
    }
}
