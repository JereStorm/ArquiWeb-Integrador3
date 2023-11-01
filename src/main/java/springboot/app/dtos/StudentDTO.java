package springboot.app.dtos;

import jdk.jfr.Name;
import springboot.app.model.Tuition;

import java.io.Serializable;
import java.util.List;

public class StudentDTO implements Serializable {

    private String name;

    private String city;

    private Long DNI;

    private List<String> careers;

    public StudentDTO(String name, String city, Long DNI, List<String> careers) {
        this.name = name;
        this.city = city;
        this.DNI = DNI;
        this.careers = careers;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public Long getDNI() {
        return DNI;
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
