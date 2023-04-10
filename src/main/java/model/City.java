package model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "City")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private Integer cityId;

    @Column (name = "city_name")
    private String nameCity;

    @OneToMany(fetch =  FetchType.EAGER, mappedBy = "city")
    private List<Employee>employeeList;

    public City(String nameCity) {
        this.nameCity = nameCity;
    }

    public City(int cityId, String nameCity) {
        this.cityId = cityId;
        this.nameCity = nameCity;
    }

    public City() {
    }

    @Override
    public String toString() {
        return "City{" +
                "cityId=" + cityId +
                ", nameCity='" + nameCity ;
    }
}
