import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WordCounterApp extends JFrame {
    private JTextArea textArea;
    private JLabel wordCountLabel;
    private JButton countButton;

    public WordCounterApp() {
        setTitle("Word Counter");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Creating components
        textArea = new JTextArea();
        wordCountLabel = new JLabel("Word Count: 0");
        countButton = new JButton("Count Words");

        // Set layout
        setLayout(new BorderLayout());

        // Adding components
        add(new JScrollPane(textArea), BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());
        bottomPanel.add(countButton);
        bottomPanel.add(wordCountLabel);
        
        add(bottomPanel, BorderLayout.SOUTH);

        // Adding button action
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText().trim();
                int wordCount = text.isEmpty() ? 0 : text.split("\\s+").length;
                wordCountLabel.setText("Word Count: " + wordCount);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WordCounterApp::new);
    }
}

