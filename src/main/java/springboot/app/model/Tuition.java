package springboot.app.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

@Getter
@Setter
@Entity
public class Tuition implements Serializable {

    @Id
    @Column(name = "id_tuition")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "fk_id_career")
    private Career career;

    @ManyToOne
    @JoinColumn(name = "fk_DNI")
    private Student student;

    @Column
    private int antiquity;
    @Column
    private int inscription;
    @Column
    private boolean graduate;
    @Column
    private int graduation;

    public Tuition(Career career, Student student, int antiquity, int inscription, boolean graduate, int graduation) {
        this.career = career;
        this.student = student;
        this.antiquity = antiquity;
        this.inscription = inscription;
        this.graduation = graduation;
        this.graduate = graduate;
    }

    public Tuition() { }

    @Override
    public String toString() {

        if (student != null && career != null) {
            return "Tuition{" + "\n" +
                    " id=" + id + "\n" +
                    " career=" + career.getName() +
                    " student=" + student.getName() +
                    " antiquity=" + antiquity +
                    " inscription=" + inscription +
                    " graduate=" + graduate +
                    " graduation=" + graduation +
                    "\n" + '}' + "\n";
        }
        return "Tuition{" + "\n" +
                " id=" + id + "\n" +
                " antiquity=" + antiquity +
                " inscription=" + inscription +
                " graduation=" + graduation +
                " graduate=" + graduate +
                "\n" + '}' + "\n";
    }
}
