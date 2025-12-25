import java.sql.*;

public class DatabaseManager {
    private static final String URL = "jdbc:postgresql://localhost:5432/java-connection";
    private static final String USER = "kariem";
    private static final String PASSWORD = "123456";

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void insert(String name, String email) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.executeUpdate();
            System.out.println("Inserted: " + name);
        } catch (SQLException e) {
            System.err.println("Insert error: " + e.getMessage());
        }
    }

    public static void retrieve() {
        String sql = "SELECT * FROM users";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {
            System.out.println("\n--- Users Table ---");
            while (rs.next()) {
                System.out.printf("ID: %d | Name: %s | Email: %s%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"));
            }
        } catch (SQLException e) {
            System.err.println("Retrieve error: " + e.getMessage());
        }
    }


    public static void update(int id, String name, String email) {
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setInt(3, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Updated " + rowsAffected + " row(s)");
        } catch (SQLException e) {
            System.err.println("Update error: " + e.getMessage());
        }
    }


    public static void delete(int id) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            System.out.println("Deleted " + rowsAffected + " row(s)");
        } catch (SQLException e) {
            System.err.println("Delete error: " + e.getMessage());
        }
    }


    private static void createTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (" +
                "id SERIAL PRIMARY KEY, " +
                "name VARCHAR(100), " +
                "email VARCHAR(100))";
        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'users' is ready");
        } catch (SQLException e) {
            System.err.println("Create table error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Last project inshallah ===\n");

        createTable();

        System.out.println("\n1. Inserting data...");
        insert("Ahmed Ali", "ahmed@k.com");
        insert("Sara Mohamed", "sara@k.com");
        insert("Kariem Abd-Elmoniem", "kariem@k.com");

        System.out.println("\nRetrieving all data");
        retrieve();

        System.out.println("\nUpdating data");
        update(1, "Ahmed Ali Updated", "ahmed.updated@k.com");

        System.out.println("\n4. Retrieving after update...");
        retrieve();

        System.out.println("\n5. Deleting data...");
        delete(11);

        System.out.println("\n6. Final state after delete...");
        retrieve();

        System.out.println("\n=== Demo Complete ===");

    }
}
