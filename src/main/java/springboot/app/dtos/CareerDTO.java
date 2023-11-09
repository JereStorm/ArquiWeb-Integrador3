package springboot.app.dtos;

import java.io.Serializable;

public class CareerDTO implements Serializable {
    private Long idCareer;

    private String name;
    private int cantEnrolled;

    public CareerDTO(long idCareer, String name, int cantEnrolled) {
        this.idCareer = idCareer;
        this.name = name;
        this.cantEnrolled = cantEnrolled;
    }

    public CareerDTO() {

    }

    public CareerDTO(long idCareer, String name) {
        this.idCareer = idCareer;
        this.name = name;
    }

    public Long getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(Long idCareer) {
        this.idCareer = idCareer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCantEnrolled() {
        return cantEnrolled;
    }

    public void setCantEnrolled(int cantEnrolled) {
        this.cantEnrolled = cantEnrolled;
    }

    @Override
    public String toString() {
        return "CareerDTO{" +
                "idCareer=" + idCareer +
                ", name='" + name + '\'' +
                ", cantEnrolled=" + cantEnrolled +
                "} \n";
    }
}
