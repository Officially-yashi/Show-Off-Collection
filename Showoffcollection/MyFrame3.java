
package Showoffcollection;
import java.awt.*;
import javax.swing.*;

public class MyFrame3 extends JFrame {
    public MyFrame3() {
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.DARK_GRAY); // Set full frame background

        JLabel label = new JLabel("Client Panel", SwingConstants.CENTER);
        label.setForeground(Color.WHITE); // Label text color
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        add(label, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
            

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Spacing between buttons

        JButton button1 = new JButton("View Dresses");
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

        JButton button2 = new JButton("Rent Dresses");
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

        JButton button3 = new JButton("Return Dresses");
        button3.setForeground(Color.WHITE); 
        button3.setBackground(Color.DARK_GRAY); 
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

        JButton button4 = new JButton("Show myrent dresses");
        button4.setForeground(Color.WHITE); 
        button4.setBackground(Color.DARK_GRAY); 
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
      
        JButton button5= new JButton("Close");
        button5.setForeground(Color.WHITE); 
        button5.setBackground(Color.DARK_GRAY); 
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
              gbc.gridy=3;
              gbc.gridwidth = 2;
              gbc.anchor = GridBagConstraints.CENTER;
             buttonPanel.add(button5, gbc);
             add(buttonPanel, BorderLayout.CENTER);
        
        // Add ActionListener to the button
        button1.addActionListener(e -> {
            new ShowDresses();
        });

        button2.addActionListener(e -> {
            new RentDresses();
        });

        button3.addActionListener(e -> {
            new Returndresses();
        });

        button4.addActionListener(e -> {
            new Showrentdresses();
        });
       
        button5.addActionListener(e -> {
             dispose();
        });

        

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyFrame2());
    }
}

