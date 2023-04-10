import DAO.CityDAO;
import DAO.CityDAOImpl;
import DAO.EmployeeDAO;
import DAO.EmployeeDAOImpl;
import model.City;
import model.Employee;

import java.sql.*;
import java.util.List;
import java.util.logging.Level;

public class Application {
    public static void main(String[] args) {
        java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.OFF);
        // stringEmployeeId(2);
        DAO.EmployeeDAO employeeDAO = new DAO.EmployeeDAOImpl();
        DAO.CityDAO cityDAO = new CityDAOImpl();

// все методы, которые есть в City отрабатывают также как и в Employee
// только если метода allEmployee выводит как сотрудников так и город, то метод allCity
// выводит только города

//
//
    City city1 = new City("Saratov");
        List<City> listCity = cityDAO.allCity();
        for (City city : listCity) {
            System.out.println(city);
        }
        System.out.println("-------------------");

        List<Employee> list = employeeDAO.allEmployee();
        for (Employee employee : list) {
            System.out.println(employee);
        }

        System.out.println(cityDAO.employeesByCity(5));
        System.out.println("----------");
        // пытался чтобы метод принимал id города он выдал ошибки писал по разному метод постоянные ошибки
        System.out.println(employeeDAO.employeesInCities(city1));

         /*Employee employee1 = new Employee("Slava", "Fomin", "men",
                 21, cityDAO.cityFromId(5));
        employeeDAO.saveEmployee(employee1);*/
        /*System.out.println(employeeDAO.employeeFromId(7));
        employeeDAO.updateEmployee(
                new Employee(87, "Maxim", "Shumilov", "men", 18 ));
        employeeDAO.deleteEmployee(new Employee(82));*/
        /*List<Employee> list = employeeDAO.allEmployee();
        for (Employee employee : list) {
            System.out.println(employee);
        }*/
    }
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
