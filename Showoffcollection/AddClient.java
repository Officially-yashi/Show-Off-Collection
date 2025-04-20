
package Showoffcollection;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class AddClient extends JFrame {
    private JTextField fnameField, lnameField, emailField, phoneField,idField,addressField;
    

    public AddClient() {
        setTitle("Add Client");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));
        

        add(createLabelWithMargin("Client Id:"));
        idField = new JTextField();
        add(idField);

        add(createLabelWithMargin("First Name:"));
        fnameField = new JTextField();
        add(fnameField);

        add(createLabelWithMargin("Last Name:"));
        lnameField = new JTextField();
        add(lnameField);

        add(createLabelWithMargin("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(createLabelWithMargin("Phone:"));
        phoneField = new JTextField();
        add(phoneField);

        add(createLabelWithMargin("Address:"));
        addressField = new JTextField();
        add(addressField);

        JButton submitButton = new JButton("Add Client");
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
        add(submitButton);
        add(cancelButton);
       
        submitButton.addActionListener(e -> {
            int id=Integer.parseInt(idField.getText());

            String firstname = fnameField.getText();
            String lastname = lnameField.getText();
            String email = emailField.getText();
            String phone = phoneField.getText();
            String address = addressField.getText();

            addClientToDatabase(id,firstname, lastname, email, phone, address);
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
    private void addClientToDatabase(int id,String firstname, String lastname, String email, String phone, String address) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/showoffcollection", "root", "Yooo");

            String query = "INSERT INTO clients (id, firstname, lastname, email, phone, address) VALUES (?,?, ?, ?, ?, ?)";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, firstname);
            pstmt.setString(3, lastname);
            pstmt.setString(4, email);
            pstmt.setString(5, phone);
            pstmt.setString(6, address);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Client added successfully!");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to add client.");
            }

            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AddClient::new);
    }
}

