
package Showoffcollection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;

public class Returndresses extends JFrame {
    private JTextField dressIdField;

    public Returndresses() {
        setTitle("Return Dress");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 2, 10, 10));

        add(createLabelWithMargin("Dress ID:"));
        dressIdField = new JTextField();
        add(dressIdField);

        JButton returnButton = new JButton("Return Dress");
        returnButton.setForeground(Color.WHITE); // Button text color
        returnButton.setBackground(Color.DARK_GRAY); // Button background color
        returnButton.setFocusPainted(false);
        returnButton.setBorderPainted(false);
        returnButton.setOpaque(true);

        returnButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                returnButton.setBackground(Color.LIGHT_GRAY); // Change color on hover
                returnButton.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                returnButton.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                returnButton.setForeground(Color.WHITE); // Revert text color when not hovered
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
        add(returnButton);
        add(cancelButton);

        returnButton.addActionListener(e -> {
            String dressIdText = dressIdField.getText().trim();
            if (!dressIdText.isEmpty()) {
                returnDressToDatabase(Integer.parseInt(dressIdText));
            } else {
                JOptionPane.showMessageDialog(this, "Please enter a dress ID.");
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void returnDressToDatabase(int dressId) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/showoffcollection", "root", "Yashi@6420");

            
            String selectQuery = "SELECT dressid FROM rentdresses WHERE dressid = ? ";
            PreparedStatement selectStmt = con.prepareStatement(selectQuery);
            selectStmt.setInt(1, dressId);
            ResultSet rs = selectStmt.executeQuery();

            if (rs.next()) {
              
                String deleteRental = "delete from rentdresses where dressid=?";
                PreparedStatement deleteStmt = con.prepareStatement(deleteRental);
                deleteStmt.setInt(1, dressId);
                deleteStmt.executeUpdate();

              
                String updateDress = "UPDATE dresses SET available = true WHERE id = ?";
                PreparedStatement updateDressStmt = con.prepareStatement(updateDress);
                updateDressStmt.setInt(1, dressId);
                updateDressStmt.executeUpdate();

                JOptionPane.showMessageDialog(this, "Dress returned successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Rental not found or already returned.");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }
     private JPanel createLabelWithMargin(String text) {
        JLabel label = new JLabel(text);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 10, 0, 0)); // top, left, bottom, right
        panel.add(label, BorderLayout.WEST);
        return panel;
    }
}


