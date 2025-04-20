
package Showoffcollection;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.sql.*;

public class AddDresses extends JFrame {
    private JTextField nameField, priceField;
    private JCheckBox availableCheckBox;

    public AddDresses() {
        setTitle("Add Dress");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(createLabelWithMargin("Dress Name:"));
        nameField = new JTextField();
        add(nameField);

        add(createLabelWithMargin("Price:"));
        priceField = new JTextField();
        add(priceField);

        add(createLabelWithMargin("Available:"));
        availableCheckBox = new JCheckBox("Yes", true);
        add(availableCheckBox);

        JButton submitButton = new JButton("Add Dress");
        submitButton.setForeground(Color.WHITE); // Button text color
        submitButton.setBackground(Color.DARK_GRAY); // Button background color
        submitButton.setFocusPainted(false);
        submitButton.setBorderPainted(false);
        submitButton.setOpaque(true);

        submitButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(Color.LIGHT_GRAY); // Change color on hover
                submitButton.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                submitButton.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                submitButton.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
        add(submitButton);

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
        add(cancelButton);

        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String priceText = priceField.getText();
            boolean available = availableCheckBox.isSelected();

            try {
                double price = Double.parseDouble(priceText);
                addDressToDatabase(name, price, available);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Please enter a valid price.");
            }
        });

        cancelButton.addActionListener(e -> dispose());

        setVisible(true);
    }
private JPanel createLabelWithMargin(String text) {
        JLabel label = new JLabel(text);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 10, 0, 0)); // top, left, bottom, right
        panel.add(label, BorderLayout.WEST);
        return panel;
    }
    private void addDressToDatabase(String name, double price, boolean available) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/showoffcollection", "root", "Yooo");

            String query = "INSERT INTO dresses (name, price, available) VALUES (?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setBoolean(3, available);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Dress added successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add dress.");
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddDresses::new);
    }
}

    

