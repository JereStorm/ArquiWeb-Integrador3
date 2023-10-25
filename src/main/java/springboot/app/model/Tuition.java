package springboot.app.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class Tuition {

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
    private int graduate;

    public Tuition(Career career, Student student, int antiquity, int inscription, int graduate) {
        this.career = career;
        this.student = student;
        this.antiquity = antiquity;
        this.inscription = inscription;
        this.graduate = graduate;
    }

    public Tuition() {

    }

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
                    "\n" + '}' + "\n";
        }
        return "Tuition{" + "\n" +
                " id=" + id + "\n" +
                " antiquity=" + antiquity +
                " inscription=" + inscription +
                " graduate=" + graduate +
                "\n" + '}' + "\n";
    }

    public Long getId() {
        return id;
    }

    public Career getCareer() {
        return career;
    }

    public Student getStudent() {
        return student;
    }

    public int getAntiquity() {
        return antiquity;
    }

    public int getInscription() {
        return inscription;
    }

    public int getGraduate() {
        return graduate;
    }
}
