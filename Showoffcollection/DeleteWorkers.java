package Showoffcollection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DeleteWorkers extends JFrame {
    private JTextField firstnamefield, lastnamefield, emailfield;
    private JPasswordField passwordfield;

    public DeleteWorkers() {
        setTitle("Delete Workers");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        add(createLabelWithMargin("First Name:"));
        firstnamefield = new JTextField();
        add(firstnamefield);

        add(createLabelWithMargin("Last Name:"));
        lastnamefield = new JTextField();
        add(lastnamefield);

        add(createLabelWithMargin("Email:"));
        emailfield = new JTextField();
        add(emailfield);

        add(createLabelWithMargin("Password:"));
        passwordfield = new JPasswordField();
        add(passwordfield);

        // Create Delete Button
        JButton deleteButton = new JButton("Delete Worker");
        deleteButton.setPreferredSize(new Dimension(150, 40)); // Set width & height

        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBackground(Color.DARK_GRAY);
        deleteButton.setFocusPainted(false);
        deleteButton.setBorderPainted(false);
        deleteButton.setOpaque(true);

        // Hover effect
        deleteButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deleteButton.setBackground(Color.LIGHT_GRAY);
                deleteButton.setForeground(Color.BLACK);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                deleteButton.setBackground(Color.DARK_GRAY);
                deleteButton.setForeground(Color.WHITE);
            }
        });

        // Add button and empty label for spacing
        add(new JLabel()); // spacer
        add(deleteButton);

        // Button logic
        deleteButton.addActionListener((ActionEvent e) -> {
            String firstname = firstnamefield.getText();
            String lastname = lastnamefield.getText();
            String email = emailfield.getText();
            String pass = new String(passwordfield.getPassword());

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || pass.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                deleteWorkerFromDatabase(firstname, lastname, email, pass);
            }
        });

        setVisible(true);
    }

    // Renamed to avoid confusion with constructor
    private void deleteWorkerFromDatabase(String firstname, String lastname, String email, String password) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/showoffcollection", "root", "Yooo");

            String query = "DELETE FROM users where firstname = ? AND lastname = ? AND email = ? AND password = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, firstname);
            pstmt.setString(2, lastname);
            pstmt.setString(3, email);
            pstmt.setString(4, password);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Worker deleted successfully!");
                dispose(); // close the window
            } else {
                JOptionPane.showMessageDialog(this, "Worker not found or deletion failed.");
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
        SwingUtilities.invokeLater(DeleteWorkers::new);
    }
}
