package springboot.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


}
