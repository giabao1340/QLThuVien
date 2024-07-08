/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.qlthuvien;

/**
 *
 * @author luong
 */
import java.io.StringReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private Connection connection;

    public BookDAO() {
        DatabaseConnection dbConnection = new DatabaseConnection();
        Connection connection = dbConnection.getConnection();
    }

    public void addBook(Book book) {
        String sql = "INSERT INTO Sach (TenSach, TenTacGia, NamNXB, TrangThai, NXB, Hinh, MoTaSach, GiaSach)\n" +
"VALUES  (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTensach());
            statement.setString(2, book.getTenTacGia());
            statement.setInt(3, book.getNamNXB());
            statement.setInt(4, book.getTrangThai());
            statement.setString(5, book.getNxb());
            statement.setString(6, book.getHinh());
            statement.setString(7, book.getMoTaSach());
            statement.setFloat(8, book.getGiaSach());

            

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM Sach";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Book book = new Book();
                book.setTensach(resultSet.getString("TenSach"));
                book.setTenTacGia(resultSet.getString("TenTacGia"));
                book.setNamNXB(resultSet.getInt("NamNXB"));
                book.setTrangThai(resultSet.getInt("TrangThai"));
                book.setNxb(resultSet.getString("NXB"));
                book.setHinh(resultSet.getString("Hinh"));
                book.setMoTaSach(resultSet.getString("MoTaSach"));
                book.setGiaSach(resultSet.getFloat("GiaSach"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public void updateBook(Book book) {
        String sql = "UPDATE Books SET Title = ?, Author = ?, ISBN = ?, PublishedYear = ? WHERE BookID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, book.getTensach());
            statement.setString(2, book.getTenTacGia());
            statement.setInt(3, book.getNamNXB());
            statement.setInt(4, book.getTrangThai());
            statement.setString(5, book.getNxb());
            statement.setString(6, book.getHinh());
            statement.setString(7, book.getMoTaSach());
            statement.setFloat(8, book.getGiaSach());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteBook(int bookID) {
        String sql = "DELETE FROM Books WHERE BookID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, bookID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        //    public Book(String tensach, String tenTacGia, int namNXB, int trangThai, String nxb, String hinh, String moTaSach, float giaSach) {

//        Book book = new Book("200 Bài Code Thiếu Nhi", "Toidicodedao", 2022, 0, "Coder", "a.png", "Description", 150000);
//        BookDAO bookDAO = new BookDAO();
//        bookDAO.addBook(book);
         
    }
    // Các phương thức khác nếu cần thiết
}
