package Showoffcollection;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.border.EmptyBorder;
public class AddAdmin extends JFrame {
private JTextField fnamefield,lnamefield,emailfield,phonefield;
private  JPasswordField passwordfield;

public AddAdmin()
{
    setTitle("Add Admin");
    setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 2, 10, 10));

        add(createLabelWithMargin("FirstName:"));
        fnamefield=new JTextField();
        add(fnamefield);

        add(createLabelWithMargin("LastName:"));
        lnamefield = new JTextField();
        add(lnamefield);

        add(createLabelWithMargin("Email:"));
        emailfield = new JTextField();
        add(emailfield);

        add(createLabelWithMargin("Phone no:"));
        phonefield = new JTextField();
        add(phonefield);

        add(createLabelWithMargin("Password:"));
        passwordfield = new JPasswordField();
        add(passwordfield);

       
    

        JButton submitButton = new JButton("Add Admin");
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
            String firstname = fnamefield.getText().trim();
            String lastname = lnamefield.getText().trim();
            String email = emailfield.getText().trim();
            String phone = phonefield.getText().trim();
            String password = new String(passwordfield.getPassword()).trim();

            if (firstname.isEmpty() || lastname.isEmpty() || email.isEmpty() || phone.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all fields.");
                return;
            }


            addAdminToDatabase(firstname, lastname, email, phone, password);
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
public void addAdminToDatabase(String firstname,String lastname,String email,String phone,String passsword)
{
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/showoffcollection","root","Yashi@6420");

        String query="Insert into users(firstname,lastname,email,phone,password,accType) values(?,?,?,?,?,?)";
        PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1,firstname);
        pstmt.setString(2,lastname);
        pstmt.setString(3,email);
        pstmt.setString(4,phone);
        pstmt.setString(5,passsword);
        pstmt.setInt(6, 0);

        int result = pstmt.executeUpdate();
        if (result > 0) {
            JOptionPane.showMessageDialog(this, "Admin added successfully!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Failed to add admin.");
        }

        con.close();
    }
    catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
    }
}
}
