package springboot.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Career implements Serializable {

    @Id
    @Column(name = "id_career")
    private Long idCareer;

    @Column(name = "name_career")
    private String name;

    @Column
    private int duration;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "career")
    private List<Tuition> tuitions;

    public Career() {
    }

    public Career(long idCareer, String name, int duration) {
        this.idCareer = idCareer;
        this.name = name;
        this.duration = duration;
        this.tuitions = new ArrayList<>();
    }

    public void addTuitions(Tuition tuition) {
        this.tuitions.add(tuition);
    }

    @Override
    public String toString() {
        return "Career{" +
                "idCareer=" + idCareer +
                ", name='" + name + '\'' +
                ", duration=" + duration +
                ",tuitions=" + tuitions +
                '}' + "\n";
    }
}
