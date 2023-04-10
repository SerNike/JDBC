package DAO;

import model.City;
import model.Employee;

import java.util.List;

public interface CityDAO {

    City saveCity(City city);
    City cityFromId(int id);
    List<City> allCity();
    City updateCity( City city);

    City deleteCity( City city);

    List employeesByCity(int id);
}
