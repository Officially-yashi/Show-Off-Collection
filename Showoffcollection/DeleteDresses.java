package Showoffcollection;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.border.EmptyBorder;

public class DeleteDresses extends JFrame {
    private JTextField dressField;
    private JTextField priceField;

    public DeleteDresses() {
        setTitle("Delete Dress");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(createLabelWithMargin("Dress Name:"));
        dressField = new JTextField();
        add(dressField);

        add(createLabelWithMargin("Price:"));
        priceField = new JTextField();
        add(priceField);

        JButton deleteButton = new JButton("Delete Dress");
        deleteButton.setForeground(Color.WHITE); // Button text color
        deleteButton.setBackground(Color.DARK_GRAY); // Button background color
        deleteButton.setFocusPainted(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setOpaque(true);

        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton.setBackground(Color.LIGHT_GRAY); // Change color on hover
                deleteButton.setForeground(Color.BLACK); // Change text color on hover
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                deleteButton.setForeground(Color.WHITE); // Revert text color when not hovered
            }
           
        });
      

        setVisible(true);
       
        deleteButton.addActionListener((ActionEvent e) -> {
            String dressName = dressField.getText();
            if (dressName.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a dress name.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/showoffcollection", "root", "Yooo")) {
                String sql = "DELETE FROM dresses WHERE name = ? AND price = ?";
                try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                    pstmt.setString(1, dressName);
                    pstmt.setString(2, priceField.getText());
                    int rowsAffected = pstmt.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(this, "Dress deleted successfully.");
                    } else {
                        JOptionPane.showMessageDialog(this, "Dress not found.");
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error deleting dress: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        add(deleteButton);
      
    }
    private JPanel createLabelWithMargin(String text) {
        JLabel label = new JLabel(text);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(0, 10, 0, 0)); // top, left, bottom, right
        panel.add(label, BorderLayout.WEST);
        return panel;
    }
}

