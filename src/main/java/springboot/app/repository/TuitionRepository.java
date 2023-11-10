package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import springboot.app.dtos.ReportDTO;
import springboot.app.model.Career;
import springboot.app.model.Student;
import springboot.app.model.Tuition;

import java.util.List;

@Repository("TuitionRepository")
public interface TuitionRepository extends JpaRepository<Tuition, Long> {

    boolean existsByStudentAndCareer(Student student, Career career);


    @Query("SELECT t.career FROM Tuition t GROUP BY t.career.idCareer ORDER BY count(t) DESC ")
    List<Career> getCareersWithStudentsInOrder();

    @Query("SELECT t.student FROM Tuition t WHERE t.career.name = :career AND t.student.city = :city")
    List<Student> findAllByCareerAndCity(String career, String city);

    @Query("SELECT NEW springboot.app.dtos.ReportDTO(t.career.name, COUNT(t.inscription), t.inscription) FROM Tuition t GROUP BY t.inscription, t.career.name ORDER BY t.career.name, t.inscription")
    List<ReportDTO> getCountInscriptionsByCareer();

    @Query("SELECT NEW springboot.app.dtos.ReportDTO(t.career.name, COUNT(t.graduation),  t.graduation) FROM Tuition t GROUP BY t.graduation, t.career.name ORDER BY t.career.name, t.inscription")
    List<ReportDTO> getCountGraduatesByCareer();
}