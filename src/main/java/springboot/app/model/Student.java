package springboot.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Student implements Serializable {

    @Id
    private Long DNI;
    @Column
    private String name;
    @Column
    private String lastName;
    @Column
    private String genre;
    @Column
    private String city;
    @Column
    private int age;
    @Column
    private int uniNumber;

    @OneToMany
    private List<Tuition> careers;

    public Student() { }

    public Student(Long DNI, String name, String lastName, String genre, String city, int age, int uniNumber) {
        this.DNI = DNI;
        this.name = name;
        this.lastName = lastName;
        this.genre = genre;
        this.city = city;
        this.age = age;
        this.uniNumber = uniNumber;
        this.careers = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Student{" +
                "DNI=" + DNI +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", city='" + city + '\'' +
                ", age=" + age +
                ", uniNumber=" + uniNumber +
                '}' + "\n";
    }
}
