import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;

public class Application {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        // stringEmployeeId(2);
        DAO.EmployeeDAO employeeDAO = new DAO.EmployeeDAOImpl();
        Employee employee1 = new Employee("Vadim", "Vadimov", "men", 35);
        employeeDAO.saveEmployee(employee1);

        List<Employee> list = employeeDAO.allEmployee();
        for (Employee employee : list) {
        System.out.println(employee);
        }
       Employee employee2 = new Employee("German", "Gromov", "men", 35);
        employeeDAO.updateEmployee(employee2);
        employeeDAO.deleteEmployee(employee1);
    }
    /*private static String stringEmployeeId(int id) {
        String sql = "SELECT employee.first_name, employee.last_name, employee.gender, city.city_name" +
                " FROM employee" +
                " INNER JOIN city" +
                " ON employee.city_id = city.city_id" +
                " WHERE id = " + id;


        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                String firtsName = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String gender = resultSet.getString(3);
                String cityName = resultSet.getString(4);
                System.out.printf("%s %s, %s, %s \n", firtsName, lastName, gender, cityName);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
*/
    /*static Connection getConnection() {
        String url = "jdbc:postgresql://localhost:5432/skypro2";
        String login = "postgres";
        String password = "1234";
        try {
            return DriverManager.getConnection(url, login, password);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }*/
    }