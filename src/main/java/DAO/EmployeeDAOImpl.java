package DAO;
import model.City;
import model.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.Callable;

import static DAO.HibernateSessionFactoryUtil.getSessionFactory;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public Employee saveEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(employee);
            transaction.commit();
        }
        return employee;
    }

    @Override
    public Employee employeeFromId(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()) {
            return session.get(Employee.class, id);
        }
    }

    @Override
    public List<Employee> allEmployee() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()) {
            return session.createQuery("FROM Employee c LEFT JOIN FETCH c.city", Employee.class).list();
        }
    }


    @Override
    public Employee updateEmployee(Employee employee) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(employee);
            transaction.commit();
        }
        return employee;
    }

    @Override
    public Employee deleteEmployee(Employee employee) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(employee);
            transaction.commit();
        }
        return employee;
    }
    @Override
    public List<Employee> employeesInCities(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Query<Employee> query = session.createQuery("FROM Employee s JOIN FETCH s.city c WHERE c.nameCity = :city", Employee.class);
            query.setParameter("city", city.getNameCity());
            return query.list();
        }
    }
}
