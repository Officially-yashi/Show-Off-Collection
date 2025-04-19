
package Showoffcollection;
import java.awt.*;
import javax.swing.*;

public class MyFrame2 extends JFrame {
    public MyFrame2() {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY); // Set full frame background

        JLabel label = new JLabel("Admin Panel", SwingConstants.CENTER);
        label.setForeground(Color.WHITE); // Label text color
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(label, BorderLayout.NORTH);
       

        JPanel buttonPanel = new JPanel(new GridBagLayout());
              // Set background color for the panel

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between buttons

        JButton button1 = new JButton("Add workers");
        button1.setForeground(Color.WHITE); // Button text color
        button1.setBackground(Color.DARK_GRAY); // Button background color
        button1.setFocusPainted(false);
        button1.setBorderPainted(false);
        button1.setOpaque(true);

        button1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button1.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button1.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button1.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button1.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
        
        JButton button2 = new JButton("Add Dresses");
        button2.setForeground(Color.WHITE); // Button text color
        button2.setBackground(Color.DARK_GRAY); // Button background color
        button2.setFocusPainted(false);
        button2.setBorderPainted(false);
        button2.setOpaque(true);

        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button2.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button2.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button2.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button2.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });

        JButton button3 = new JButton("Add Clients");
        button3.setForeground(Color.WHITE); // Button text color
        button3.setBackground(Color.DARK_GRAY); // Button background color
        button3.setFocusPainted(false);
        button3.setBorderPainted(false);
        button3.setOpaque(true);

        button3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button3.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button3.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button3.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button3.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });

        JButton button4 = new JButton("Show Clients");
        button4.setForeground(Color.WHITE); // Button text color
        button4.setBackground(Color.DARK_GRAY); // Button background color
        button4.setFocusPainted(false);
        button4.setBorderPainted(false);
        button4.setOpaque(true);

        button4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button4.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button4.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button4.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button4.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
        JButton button5 = new JButton("View Dresses");
        button5.setForeground(Color.WHITE); // Button text color
        button5.setBackground(Color.DARK_GRAY); // Button background color
        button5.setFocusPainted(false);
        button5.setBorderPainted(false);
        button5.setOpaque(true);

        button5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button5.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button5.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button5.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button5.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });

        JButton button6 = new JButton("Show Workers");
        button6.setForeground(Color.WHITE); // Button text color
        button6.setBackground(Color.DARK_GRAY); // Button background color
        button6.setFocusPainted(false);
        button6.setBorderPainted(false);
        button6.setOpaque(true);
        button6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button6.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button6.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button6.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button6.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });

        

        JButton button7 = new JButton("Delete Workers");
        button7.setForeground(Color.WHITE);
        button7.setBackground(Color.DARK_GRAY);
        button7.setFocusPainted(false);
        button7.setBorderPainted(false);
        button7.setOpaque(true);

        button7.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseEntered(java.awt.event.MouseEvent evt) {
        button7.setBackground(Color.LIGHT_GRAY);
        button7.setForeground(Color.BLACK);
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        button7.setBackground(Color.DARK_GRAY);
        button7.setForeground(Color.WHITE);
    }
});
JButton button8 = new JButton("Delete Dresses");
button8.setForeground(Color.WHITE); // Button text color
button8.setBackground(Color.DARK_GRAY); // Button background color
button8.setFocusPainted(false);
button8.setBorderPainted(false);
button8.setOpaque(true);
button8.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        button8.setBackground(Color.LIGHT_GRAY); // Change color on hover
        button8.setForeground(Color.BLACK); // Change text color on hover
    }
    public void mouseExited(java.awt.event.MouseEvent evt) {
        button8.setBackground(Color.DARK_GRAY); // Revert color when not hovered
        button8.setForeground(Color.WHITE); // Revert text color when not hovered
    }
});
        JButton button9 = new JButton("Close");
        button9.setForeground(Color.WHITE); // Button text color
        button9.setBackground(Color.DARK_GRAY); // Button background color
        button9.setFocusPainted(false);
        button9.setBorderPainted(false);
        button9.setOpaque(true);

        button9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button9.setBackground(Color.LIGHT_GRAY); // Change color on hover
                button9.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                button9.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                button9.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
      
        //row1
        gbc.gridx=0;
        gbc.gridy=0;
        buttonPanel.add(button1,gbc);

        gbc.gridx=1;
        buttonPanel.add(button2,gbc);

        //row2
        gbc.gridx=0;
        gbc.gridy=1;
        buttonPanel.add(button3, gbc);

        gbc.gridx = 1;
        buttonPanel.add(button4, gbc);

        //row3
              gbc.gridx=0;
              gbc.gridy=2;
              buttonPanel.add(button5,gbc);

              gbc.gridx=1;
              buttonPanel.add(button6,gbc);

              //row4

              gbc.gridx=0;
              gbc.gridy=3;
             
                buttonPanel.add(button7,gbc);
              
             
             gbc.gridx = 1;
             gbc.gridy = 3; // Corrected row position
             buttonPanel.add(button8, gbc);
            
            
             //row5
                gbc.gridx=0;
                gbc.gridy=4;
                gbc.gridwidth = 2; // Span both columns
                gbc.anchor = GridBagConstraints.CENTER; // Center the button
                buttonPanel.add(button9, gbc);
                add(buttonPanel, BorderLayout.CENTER);
        // Add ActionListener to the button
        button1.addActionListener(e -> {
            new AddAdmin();
        });

        button2.addActionListener(e -> {
            new AddDresses();
        });

        button3.addActionListener(e -> {
            new AddClient();
        });

        button4.addActionListener(e -> {
            new ShowClients();
        });
       
        button5.addActionListener(e -> {
            new ShowDresses();
        });

        button6.addActionListener(e -> {
            new ShowAdmin();
        });
        button7.addActionListener(e -> {
            new DeleteWorkers();
        });
        button8.addActionListener(e -> {
            new DeleteDresses();
        });
        button9.addActionListener(e -> {
            dispose();
        });
    
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame2());
    }
}

