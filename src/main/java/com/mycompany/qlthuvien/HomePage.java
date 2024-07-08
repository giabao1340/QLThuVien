package com.mycompany.qlthuvien;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import javax.swing.*;

public class HomePage extends JFrame {
    public HomePage() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("My Application");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // Tạo một bảng điều khiển sidebar
            JPanel sidebar = new JPanel();
            sidebar.setLayout(new BorderLayout()); // Chuyển sang BorderLayout để sắp xếp logo và các nút hợp lý
            sidebar.setPreferredSize(new Dimension(150, frame.getHeight()));

            // Thêm logo ở đầu thanh sidebar
            File logoFile = new File("D:\\Netbean Java Project\\QLThuVien\\src\\main\\java\\images\\logo.png");
            if (logoFile.exists()) {
                ImageIcon logoIcon = new ImageIcon(logoFile.getAbsolutePath());
                // Resize the image to fit the sidebar width
                Image logoImage = logoIcon.getImage();
                Image resizedLogoImage = logoImage.getScaledInstance(150, -1, Image.SCALE_SMOOTH); // Width is 150, height is auto
                logoIcon = new ImageIcon(resizedLogoImage);
                JLabel logoLabel = new JLabel(logoIcon);
                sidebar.add(logoLabel, BorderLayout.NORTH);
            } else {
                System.err.println("Logo file not found: " + logoFile.getAbsolutePath());
            }

            // Tạo một panel để chứa các nút
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(4, 1)); // 4 nút trong bố cục dọc

            // Tạo các nút cho thanh sidebar
            String[] buttonLabels = {"Thể loại", "Quản lý thành viên", "Quản lý sách", "Quản lý Mượn trả"};
            for (String label : buttonLabels) {
                JButton button = new JButton(label);
                button.setFocusPainted(false); // Loại bỏ viền khi được chọn
                button.setContentAreaFilled(false); // Loại bỏ vùng nội dung tô màu
                button.setOpaque(true); // Cho phép màu nền hiển thị
                button.setBackground(Color.LIGHT_GRAY); // Màu nền mặc định

                // Thêm hiệu ứng hover
                button.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button.setBackground(Color.GRAY);
                    }

                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setBackground(Color.LIGHT_GRAY);
                    }
                });

                buttonPanel.add(button);
            }

            // Thêm panel chứa các nút vào sidebar
            sidebar.add(buttonPanel, BorderLayout.CENTER);

            // Tạo một bảng điều khiển nội dung chính
            JPanel mainContent = new JPanel();
            mainContent.setLayout(new GridBagLayout()); // Sử dụng GridBagLayout để tùy chỉnh vị trí
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10); // Khoảng cách giữa các thành phần
            gbc.fill = GridBagConstraints.HORIZONTAL; // Các nút sẽ mở rộng theo chiều ngang

            // Thêm một JLabel text ở trên 3 nút
            JLabel textLabel = new JLabel("Chọn chức năng", SwingConstants.CENTER);
            textLabel.setFont(new Font("Arial", Font.BOLD, 24));
            textLabel.setPreferredSize(new Dimension(600, 50)); // Đặt kích thước cho JLabel
            textLabel.setOpaque(true);
            textLabel.setBackground(Color.decode("#F0F0F0")); // Màu nền của JLabel

            // Thay đổi GridBagConstraints để đặt textLabel ở vị trí tùy chỉnh
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 3; // Chiếm toàn bộ chiều ngang
            mainContent.add(textLabel, gbc);

            // Tạo các nút ở giữa
            JButton button1 = createMainButton("Sách");
            JButton button2 = createMainButton("Thành viên");
            JButton button3 = createMainButton("Mượn trả");
            button1.setBackground(Color.decode("#FFB01C")); // Màu nền mặc định
            button2.setBackground(Color.decode("#3E9705")); // Màu nền mặc định
            button3.setBackground(Color.decode("#A46FBB")); // Màu nền mặc định

            // Thay đổi màu nền khi nút được nhấn
            button1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button1.setBackground(Color.decode("#FF9604")); // Màu nền khi nhấn
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button1.setBackground(Color.decode("#FFB01C")); // Màu nền mặc định
                }
            });
            button2.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button2.setBackground(Color.decode("#377D00")); // Màu nền khi nhấn
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button2.setBackground(Color.decode("#3E9705")); // Màu nền mặc định
                }
            });
            button3.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    button3.setBackground(Color.decode("#8B51AD")); // Màu nền khi nhấn
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    button3.setBackground(Color.decode("#A46FBB")); // Màu nền mặc định
                }
            });

            // Thay đổi GridBagConstraints để căn giữa các nút và chỉnh sửa kích thước
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            mainContent.add(button1, gbc);
            gbc.gridx++;
            mainContent.add(button2, gbc);
            gbc.gridx++;
            mainContent.add(button3, gbc);

            // Thay đổi BorderLayout để căn chỉnh textLabel và buttonsPanel
            mainContent.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); // Thêm padding cho mainContent

            // Tạo một panel để chứa mainContent với vị trí tùy chỉnh
            JPanel container = new JPanel();
            container.setLayout(new BorderLayout());
            container.add(mainContent, BorderLayout.NORTH);

            // Thay đổi BorderLayout để thêm container và sidebar vào frame
            frame.setLayout(new BorderLayout());
            frame.add(sidebar, BorderLayout.WEST);
            frame.add(container, BorderLayout.CENTER);

            // Lấy kích thước màn hình
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            Dimension screenSize = toolkit.getScreenSize();

            // Thiết lập kích thước của frame
            frame.setSize(screenSize.width, screenSize.height - 100);

            // Đặt frame vào giữa màn hình
            frame.setLocationRelativeTo(null);

            // Hiển thị frame
            frame.setVisible(true);
        });
    }

    private JButton createMainButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(200, 200));
        button.setFocusPainted(false);
        button.setContentAreaFilled(false);
        button.setOpaque(true);
        button.setBackground(Color.LIGHT_GRAY);

        // Thêm hiệu ứng hover
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(Color.BLUE);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(Color.LIGHT_GRAY);
            }
        });

        return button;
    }

    public static void main(String[] args) {
        // Tạo và hiển thị trang chủ
        HomePage homePage = new HomePage();
        homePage.setVisible(true);
    }
}
