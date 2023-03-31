package DAO;

import model.Employee;

import java.util.List;

public interface EmployeeDAO {

    Employee saveEmployee(Employee employee);
    Employee employeeFromId(int id);
    List<Employee> allEmployee();
    void updateEmployee(int id, Employee employee);

    void deleteEmployee(Employee employee);

}
