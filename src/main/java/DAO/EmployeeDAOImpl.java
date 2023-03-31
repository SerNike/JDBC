package DAO;
import model.Employee;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

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
        public Employee employeeFromId(int id){
        return getSessionFactory().openSession().get(Employee.class, id);
            }

        @Override
        public List<Employee> allEmployee () {
            List users = getSessionFactory().openSession()
                    .createQuery("From Employee", Employee.class).list();
            return users;
    }

        @Override
        public Employee updateEmployee ( Employee employee){
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                    .openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(employee);
                transaction.commit();


            }
            return employee;
        }

        @Override
        public Employee deleteEmployee (Employee employee){
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
            }
            return employee;
        }
    }
