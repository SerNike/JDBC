import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.Employee;

import java.sql.*;
import java.util.List;

/** выскакивает такая ошибка не могу понять в чем дело
 * мар. 30, 2023 11:29:18 PM org.hibernate.Version logVersion
 * INFO: HHH000412: Hibernate ORM core version 5.6.14.Final
 * мар. 30, 2023 11:29:20 PM org.hibernate.annotations.common.reflection.java.JavaReflectionManager <clinit>
 * INFO: HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
 * мар. 30, 2023 11:29:20 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl configure
 * WARN: HHH10001002: Using Hibernate built-in connection pool (not for production use!)
 * мар. 30, 2023 11:29:20 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
 * INFO: HHH10001005: using driver [org.postgresql.Driver] at URL [jdbc:postgresql://localhost:5432/skypro2]
 * мар. 30, 2023 11:29:20 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
 * INFO: HHH10001001: Connection properties: {password=****, user=postgres}
 * мар. 30, 2023 11:29:20 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl buildCreator
 * INFO: HHH10001003: Autocommit mode: false
 * мар. 30, 2023 11:29:20 PM org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionProviderImpl$PooledConnections <init>
 * INFO: HHH000115: Hibernate connection pool size: 20 (min=1)
 * мар. 30, 2023 11:29:21 PM org.hibernate.dialect.Dialect <init>
 * INFO: HHH000400: Using dialect: org.hibernate.dialect.PostgreSQLDialect
 * мар. 30, 2023 11:29:24 PM org.hibernate.resource.transaction.backend.jdbc.internal.DdlTransactionIsolatorNonJtaImpl getIsolatedConnection
 * INFO: HHH10001501: Connection obtained from JdbcConnectionAccess [org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess@6e6d4780] for (non-JTA) DDL execution was not in auto-commit mode; the Connection 'local transaction' will be committed and the Connection will be set into auto-commit mode.
 * мар. 30, 2023 11:29:24 PM org.hibernate.engine.transaction.jta.platform.internal.JtaPlatformInitiator initiateService
 * INFO: HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
 * Hibernate:
 *     insert
 *     into
 *         Employee
 *         (age, first_name, gender, last_name)
 *     values
 *         (?, ?, ?, ?)
 */

public class Application {
    public static void main(String[] args) {
        // stringEmployeeId(2);
        DAO.EmployeeDAO employeeDAO = new DAO.EmployeeDAOImpl();
        Employee employee1 = new Employee("Vadim", "Sokolov", "men", 35);
        employeeDAO.saveEmployee(employee1);

        //List<Employee> list = employeeDAO.allEmployee();
        //for (Employee employee : list) {
        //    System.out.println(employee);
        //}
       //Employee employee2 = new Employee("German", "Gromov", "men", 35, 2);
       // employeeDAO.updateEmployee(employee2);
       // employeeDAO.deleteEmployee(employee2);
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