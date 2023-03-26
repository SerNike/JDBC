import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) {

        try (Connection connection = getConnection();
        )
        {

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/skypro2";
        String login = "postgres";
        String password = "";
        try {
            return DriverManager.getConnection(url, login, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
