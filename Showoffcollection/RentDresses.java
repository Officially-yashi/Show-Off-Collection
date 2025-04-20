
package Showoffcollection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;

public class RentDresses extends JFrame {
    private JTextField clientIdField, dressIdField;

    public RentDresses() {
        setTitle("Rent a Dress");
        setSize(300, 180);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(createLabelWithMargin("Client ID:"));
        clientIdField = new JTextField();
        add(clientIdField);

        add(createLabelWithMargin("Dress ID:"));
        dressIdField = new JTextField();
        add(dressIdField);

        JButton rentButton = new JButton("Rent");
        rentButton.setForeground(Color.WHITE); // Button text color
        rentButton.setBackground(Color.DARK_GRAY); // Button background color
        rentButton.setFocusPainted(false);
        rentButton.setBorderPainted(false);
        rentButton.setOpaque(true);

        rentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                rentButton.setBackground(Color.LIGHT_GRAY); // Change color on hover
                rentButton.setForeground(Color.BLACK); // Change text color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                rentButton.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                rentButton.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
        JButton cancelButton = new JButton("Cancel");
        cancelButton.setForeground(Color.WHITE); // Button text color
        cancelButton.setBackground(Color.DARK_GRAY); // Button background color
        cancelButton.setFocusPainted(false);
        cancelButton.setBorderPainted(false);
        cancelButton.setOpaque(true);

        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelButton.setBackground(Color.LIGHT_GRAY); // Change color on hover
                cancelButton.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelButton.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                cancelButton.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
        add(rentButton);
        add(cancelButton);

        rentButton.addActionListener(e -> rentDress());
        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void rentDress() {
        String clientId = clientIdField.getText();
        String dressId = dressIdField.getText();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/showoffcollection", "root", "Yooo");

            String sql = "INSERT INTO rentdresses (clientid, dressid) VALUES (?, ?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(clientId));
            stmt.setInt(2, Integer.parseInt(dressId));

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Dress rented successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to rent dress.");
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }
 private JPanel createLabelWithMargin(String text) {
        JLabel label = new JLabel(text);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 10, 0, 0)); // top, left, bottom, right
        panel.add(label, BorderLayout.WEST);
        return panel;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RentDresses());
    }
}

