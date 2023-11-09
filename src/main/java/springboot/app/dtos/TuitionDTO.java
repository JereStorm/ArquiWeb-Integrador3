package springboot.app.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TuitionDTO {

    private Long DNI,id_career,id;
    private int inscription;
    private String name, lastName, careerName;


    public TuitionDTO() {
    }

    public TuitionDTO(Long DNI, Long id_career) {
        this.DNI = DNI;
        this.id_career = id_career;
    }

    @Override
    public String toString() {
        return "TuitionDTO{" +
                " DNI=" + DNI +
                ", id_career=" + id_career +
                ", id=" + id +
                ", inscription=" + inscription +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", careerName='" + careerName + '\'' +
                '}' + "\n";  // Agregado un salto de línea aquí
    }
}
