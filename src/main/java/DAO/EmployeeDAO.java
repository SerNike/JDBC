package DAO;

import model.City;
import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee saveEmployee(Employee employee);
    Employee employeeFromId(int id);
    List<Employee> allEmployee();
    Employee updateEmployee( Employee employee);

    Employee deleteEmployee( Employee employee);

    List<Employee> employeesInCities(Integer cityId);

}
