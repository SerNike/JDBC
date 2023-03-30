package DAO;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee saveEmployee(Employee employee);
    Employee employeeFromId(int id);
    List<Employee> allEmployee();
    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

}
