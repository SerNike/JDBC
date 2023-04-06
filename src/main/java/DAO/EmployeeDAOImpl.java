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
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()){
            return session.get(Employee.class, id);
        }
    }

        @Override
        public List<Employee> allEmployee () {
            try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                    .openSession()) {
                return session.createQuery("SELECT * FROM employee s LEFT JOIN FETCH s.city", Employee.class).list();
            }
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
