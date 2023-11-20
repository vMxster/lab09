package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final static Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private final static int SCREEN_WIDTH = (int) SCREEN_SIZE.getWidth();
    private final static int SCREEN_HEIGHT = (int) SCREEN_SIZE.getHeight();
    private final static int PROPORTION = 5;

    private final JFrame frame;
    private final Controller controller;

    public SimpleGUIWithFileChooser() {
        this.controller = new Controller();
        this.frame = new JFrame();
        frame.setTitle("My second Java graphical interface");
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new LineBorder(Color.BLACK));
        JPanel panelNorth = new JPanel(new BorderLayout());
        panelNorth.setBorder(new LineBorder(Color.BLACK));
        JButton saveButton = new JButton("SAVE");
        saveButton.setBorder(new LineBorder(Color.BLACK));
        JButton browseButton = new JButton("Browse...");
        browseButton.setBorder(new LineBorder(Color.BLACK));
        JTextArea textArea = new JTextArea();
        JTextField textField = new JTextField(controller.getFilePath());
        textField.setEditable(false);
        panel.add(saveButton, BorderLayout.SOUTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(panelNorth, BorderLayout.NORTH);
        panelNorth.add(textField, BorderLayout.CENTER);
        panelNorth.add(browseButton, BorderLayout.EAST);
        frame.setContentPane(panel);
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showSaveDialog(browseButton);
                if (result==JFileChooser.APPROVE_OPTION) {
                    controller.setFile(fileChooser.getSelectedFile());
                    textField.setText(controller.getFilePath());
                } else if (result==JFileChooser.CANCEL_OPTION) {
                    
                } else {
                    JOptionPane.showMessageDialog(frame, "An error has occurred!", "ERROR!", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void display() {
        frame.setSize(SCREEN_WIDTH / PROPORTION, SCREEN_HEIGHT / PROPORTION);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleGUIWithFileChooser gui = new SimpleGUIWithFileChooser();
        gui.display();
    }
}
