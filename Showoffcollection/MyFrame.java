
package Showoffcollection;

import java.awt.*;
import javax.swing.*;

public class MyFrame extends JFrame {
    public MyFrame() {

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY); //set full background

        JLabel label = new JLabel("Show Off Collection", SwingConstants.CENTER);
        
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBorder(BorderFactory.createEmptyBorder(50, 0, 10, 0));
        label.setForeground(Color.WHITE); // Label text color
        add(label, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 0, 0, 0);
        gbc.anchor = GridBagConstraints.CENTER;

        JRadioButton adminradio = new JRadioButton("Login as Admin");
        adminradio.setFont(new Font("Arial", Font.PLAIN, 16));
        adminradio.setFocusPainted(false);
        adminradio.setForeground(Color.WHITE);       // Text color
        adminradio.setBackground(Color.DARK_GRAY);   // Background color

        JRadioButton clientradio = new JRadioButton("Login as Client");
        clientradio.setFont(new Font("Arial", Font.PLAIN, 16));
        clientradio.setFocusPainted(false);
        clientradio.setForeground(Color.WHITE);
        clientradio.setBackground(Color.DARK_GRAY);

        // Optional: Set panel background to match
        centerPanel.setBackground(Color.DARK_GRAY);

        ButtonGroup group = new ButtonGroup();
        group.add(adminradio);
        group.add(clientradio);

        gbc.gridy = 0;
        centerPanel.add(adminradio, gbc);
        gbc.gridy = 1;
        centerPanel.add(clientradio, gbc);

        add(centerPanel, BorderLayout.CENTER);

        adminradio.addActionListener(e -> {
            new MyFrame2();
            dispose();
        });

        clientradio.addActionListener(e -> {
            new MyFrame3();
            dispose();
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame());
    }
}

