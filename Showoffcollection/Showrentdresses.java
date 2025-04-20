
package Showoffcollection;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class Showrentdresses extends JFrame {
    private JTextField clientIdField;
    private JTextArea resultArea;

    public Showrentdresses() {
        setTitle("View Rented Dresses");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        topPanel.add(new JLabel("Enter Client ID:"));
        clientIdField = new JTextField(10);
        topPanel.add(clientIdField);

        JButton viewButton = new JButton("View");
        viewButton.setForeground(Color.WHITE); // Button text color
        viewButton.setBackground(Color.DARK_GRAY); // Button background color
        viewButton.setFocusPainted(false);
        viewButton.setBorderPainted(false);
        viewButton.setOpaque(true);

        viewButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                viewButton.setBackground(Color.LIGHT_GRAY); // Change color on hover
                viewButton.setForeground(Color.BLACK); // Change text color on hover
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                viewButton.setBackground(Color.DARK_GRAY); // Revert color when not hovered
                viewButton.setForeground(Color.WHITE); // Revert text color when not hovered
            }
        });
        topPanel.add(viewButton);
        add(topPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        viewButton.addActionListener(e -> fetchRentedDresses());

        setVisible(true);
    }

    private void fetchRentedDresses() {
        String clientId = clientIdField.getText();
        if (clientId.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a Client ID.");
            return;
        }

        resultArea.setText(""); // Clear previous results

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/showoffcollection", "root", "Yooo");

            String sql = "SELECT d.name, d.price, d.available " +
                         "FROM rentdresses r " +
                         "JOIN dresses d ON r.dressid = d.id " +
                         "WHERE r.clientid = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(clientId));
            ResultSet rs = stmt.executeQuery();

            boolean found = false;
            while (rs.next()) {
                found = true;
                String name = rs.getString("name");
                double price = rs.getDouble("price");
                boolean available = rs.getBoolean("available");

                resultArea.append("Dress: " + name + "\nPrice: " + price + "\nAvailable: " + available + "\n\n");
            }

            if (!found) {
                resultArea.setText("No rented dresses found for client ID: " + clientId);
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Showrentdresses());
    }
}

