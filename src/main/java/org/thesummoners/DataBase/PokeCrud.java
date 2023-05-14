package org.thesummoners.DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PokeCrud {
    private final Connection conn;

    public PokeCrud(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public void create(String name, int level) throws SQLException {
        String sql = "INSERT INTO my_table (name, age) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, level);
        stmt.executeUpdate();
    }

    public void read(int id) throws SQLException {
        String sql = "SELECT * FROM my_table WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.println("Name: " + rs.getString("name"));
            System.out.println("Level: " + rs.getInt("level"));
        }
    }

    public void update(int id, String name, int level) throws SQLException {
        String sql = "UPDATE my_table SET name = ?, age = ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setInt(2, level);
        stmt.setInt(3, id);
        stmt.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM my_table WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public void close() throws SQLException {
        conn.close();
    }
}
