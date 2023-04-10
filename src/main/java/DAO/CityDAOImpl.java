package DAO;

import model.City;
import model.Employee;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static DAO.HibernateSessionFactoryUtil.getSessionFactory;

public class CityDAOImpl implements CityDAO{


    @Override
    public City saveCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();) {
            Transaction transaction = session.beginTransaction();
            session.save(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City cityFromId(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()){
            return session.get(City.class, id);
        }
    }

    @Override
    public List<City> allCity() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()) {
            return session.createQuery("FROM City c LEFT JOIN FETCH c.employeeList", City.class).list();
        }
    }

    @Override
    public City updateCity(City city) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory()
                .openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(city);
            transaction.commit();
        }
        return city;
    }

    @Override
    public City deleteCity(City city) {
        try (Session session = getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(city);
            transaction.commit();
        }
        return city;
    }
@Override
    public List employeesByCity(int id) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            City city = session.get(City.class, id);
            Hibernate.initialize(city.getEmployeeList());
            return city.getEmployeeList();
        }
    }

}
