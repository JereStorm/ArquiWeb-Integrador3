package springboot.app.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

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

    public Student() {

    }

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

    public Long getDNI() {
        return DNI;
    }

    public void setDNI(Long DNI) {
        this.DNI = DNI;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getUniNumber() {
        return uniNumber;
    }

    public void setUniNumber(int uniNumber) {
        this.uniNumber = uniNumber;
    }

    public List<Tuition> getCareers() {
        return careers;
    }

    public void setCareers(List<Tuition> careers) {
        this.careers = careers;
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
