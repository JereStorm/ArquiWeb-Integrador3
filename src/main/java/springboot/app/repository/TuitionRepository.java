package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Career;
import springboot.app.model.Student;
import springboot.app.model.Tuition;

@Repository("TuitionRepository")
public interface TuitionRepository extends JpaRepository<Tuition, Long> {

    boolean existsByStudentAndCareer(Student student, Career career);

}
