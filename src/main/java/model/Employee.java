package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;
@Data
@NoArgsConstructor
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
    /*@Column(name = "city_id")
    private int cityId;*/

    public Employee(String firstName, String lastName, String gender, int age/*, int cityId*/ ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
       // this.cityId = cityId;
    }

    public Employee(int id, String firstName, String lastName, String gender, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    public Employee(int id) {
        this.id = id;
    }
}

