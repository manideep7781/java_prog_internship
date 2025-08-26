import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.*;

public class NotepadApp {
    private JFrame frame;
    private JTextArea textArea;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NotepadApp().createAndShow());
    }

    private void createAndShow() {
        frame = new JFrame("Simple Notepad");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        textArea = new JTextArea();
        textArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(textArea);
        frame.add(scroll, BorderLayout.CENTER);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");
        JMenuItem exitItem = new JMenuItem("Exit");

        openItem.addActionListener(e -> openFile());
        saveItem.addActionListener(e -> saveFile());
        exitItem.addActionListener(e -> frame.dispose());

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showOpenDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                String content = Files.readString(file.toPath());
                textArea.setText(content);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Failed to open: " + ex.getMessage());
            }
        }
    }

    private void saveFile() {
        JFileChooser chooser = new JFileChooser();
        if (chooser.showSaveDialog(frame) == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            try {
                Files.writeString(file.toPath(), textArea.getText());
                JOptionPane.showMessageDialog(frame, "Saved successfully.");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(frame, "Failed to save: " + ex.getMessage());
            }
        }
    }
}
