package com.mycompany.qlthuvien;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginForm extends JFrame {
    private JTextField emailText;
    private JPasswordField passwordText;

    public LoginForm() {
        // Thiết lập tiêu đề và kích thước cho form login
        setTitle("Login Form");
        setSize(400, 240);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Hiển thị form ở giữa màn hình

        // Tạo panel và thêm các thành phần giao diện
        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        placeComponents(panel);
    }

    private void placeComponents(JPanel panel) {
        JLabel titlelLabel1 = new JLabel("HUFLIT - LIBRARY");
        titlelLabel1.setBounds(130, 10, 200, 30);
        panel.add(titlelLabel1);

        JLabel titlelLabel2 = new JLabel("ĐĂNG NHẬP");
        titlelLabel2.setBounds(150, 40, 200, 25);
        panel.add(titlelLabel2);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 70, 200, 25);
        panel.add(emailLabel);

        emailText = new JTextField(20);
        emailText.setBounds(100, 70, 165, 25);
        panel.add(emailText);

        // Tạo JLabel và JPasswordField cho Mật khẩu
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 100, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 100, 165, 25);
        panel.add(passwordText);

        // Tạo nút Login
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(130, 140, 80, 25);
        panel.add(loginButton);

        // Xử lý sự kiện khi nhấn nút Login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = emailText.getText();
                String password = new String(passwordText.getPassword());

                // Xử lý đăng nhập
                if (login(email, password)) {
                    JOptionPane.showMessageDialog(panel, "Login successful!");
                    // Điều hướng tới trang chủ
                    HomePage homePage = new HomePage();
                    homePage.setVisible(true);
                    dispose(); // Đóng form login
                } else {
                    JOptionPane.showMessageDialog(panel, "Invalid email or password.");
                }
            }
        });
    }

    public boolean login(String username, String password) {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String query = "SELECT COUNT(1) FROM TaiKhoan WHERE Email = ? AND MatKhau = ?";

        try {
            if (connection != null) {
                // Tạo PreparedStatement
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                // Thực thi truy vấn
                resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng các tài nguyên
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                dbConnection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // Hiển thị form login
        LoginForm loginForm = new LoginForm();
        loginForm.setVisible(true);
    }
}
