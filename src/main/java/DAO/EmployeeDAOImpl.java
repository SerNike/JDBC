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
            // Создаем транзакцию и начинаем ее
            Transaction transaction = session.beginTransaction();
            // вызываем на объекте сессии метод save
            // данный метод внутри себя содержит необходимый запрос к базе
            // для создания новой строки
            session.save(employee);
            // Выполняем коммит, то есть сохраняем изменения,
            // которые совершили в рамках транзакции
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
            List<Employee> users = (List<Employee>) getSessionFactory().openSession().createQuery("From Employee").list();
            return users;
    }

        @Override
        public void updateEmployee (int id, Employee employee){
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.update(employee);
                transaction.commit();
            }
        }

        @Override
        public void deleteEmployee (Employee employee){
            try (Session session = getSessionFactory().openSession()) {
                Transaction transaction = session.beginTransaction();
                session.delete(employee);
                transaction.commit();
            }
        }
    }
