import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class DNASequenceAnalyzer extends JFrame {

    private DNASequence dnaSequence;
    private final JTextArea outputArea;

    public DNASequenceAnalyzer() {
        setTitle("DNA Sequence Analyzer");
        setSize(700, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton loadButton = new JButton("Load DNA File");
        JButton sequenceButton = new JButton("Sequence");
        JButton reverseButton = new JButton("Reverse");
        JButton complementButton = new JButton("Complement");
        JButton reverseComplementButton = new JButton("Reverse Complement");
        JButton gcButton = new JButton("GC Content");
        JButton rnaButton = new JButton("RNA");

        buttonPanel.add(loadButton);
        buttonPanel.add(sequenceButton);
        buttonPanel.add(reverseButton);
        buttonPanel.add(complementButton);
        buttonPanel.add(reverseComplementButton);
        buttonPanel.add(gcButton);
        buttonPanel.add(rnaButton);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        add(buttonPanel, BorderLayout.NORTH);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        loadButton.addActionListener(e -> loadSequence());

        sequenceButton.addActionListener(e -> {
            if (sequenceLoaded()) {
                displayResult("Sequence", dnaSequence.getSequence());
            }
        });

        reverseButton.addActionListener(e -> {
            if (sequenceLoaded()) {
                displayResult("Reverse", dnaSequence.getReverse());
            }
        });

        complementButton.addActionListener(e -> {
            if (sequenceLoaded()) {
                displayResult("Complement", dnaSequence.getComplement());
            }
        });

        reverseComplementButton.addActionListener(e -> {
            if (sequenceLoaded()) {
                displayResult(
                        "Reverse Complement",
                        dnaSequence.getReverseComplement()
                );
            }
        });

        gcButton.addActionListener(e -> {
            if (sequenceLoaded()) {
                displayResult(
                        "GC Content",
                        String.format("%.2f%%", dnaSequence.getGCContent())
                );
            }
        });

        rnaButton.addActionListener(e -> {
            if (sequenceLoaded()) {
                displayResult("RNA Sequence", dnaSequence.getRNASequence());
            }
        });
    }

    private void loadSequence() {
        JFileChooser fileChooser = new JFileChooser();

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            try {
                String sequence = Files.readString(file.toPath())
                        .replaceAll("\\s+", "")
                        .toUpperCase();

                dnaSequence = new DNASequence(file.getName(), sequence);

                displayResult(
                        "Loaded " + dnaSequence.getName(),
                        dnaSequence.getSequence()
                );

            } catch (IOException exception) {
                JOptionPane.showMessageDialog(
                        this,
                        "Unable to read the selected file.",
                        "File Error",
                        JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    private boolean sequenceLoaded() {
        if (dnaSequence == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Load a DNA sequence file first.",
                    "No Sequence Loaded",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        return true;
    }

    private void displayResult(String title, String result) {
        outputArea.setText(title + "\n\n" + result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DNASequenceAnalyzer analyzer = new DNASequenceAnalyzer();
            analyzer.setVisible(true);
        });
    }
}
