package springboot.app.dtos;

import jdk.jfr.Name;
import lombok.Getter;
import lombok.Setter;
import springboot.app.model.Tuition;

import java.io.Serializable;
import java.util.List;


@Getter
@Setter

public class StudentDTO implements Serializable {



    private String name;

    private String city;

    private Long DNI;

    private List<String> careers;

    private String lastName;

    private int age;

    private String genre;


    public StudentDTO() {
    }


    public StudentDTO(String name, String city, Long DNI, List<String> careers, int age, String lastName, String genre) {
        this.name = name;
        this.city = city;
        this.DNI = DNI;
        this.careers = careers;
        this.age = age;
        this.lastName = lastName;
        this.genre = genre;
    }

    public StudentDTO(String name, String city, Long DNI, int age, String lastName, String genre) {
        this.name = name;
        this.city = city;
        this.DNI = DNI;
        this.age = age;
        this.lastName = lastName;
        this.genre = genre;
    }

    public StudentDTO(String name, String city, Long DNI, List<String> careers) {
        this.name = name;
        this.city = city;
        this.DNI = DNI;
        this.careers = careers;
    }





    public List<String> getCareers() {
        return careers;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", DNI=" + DNI +
                ", careers='" + careers + '\'' +
                "} \n";
    }
}
