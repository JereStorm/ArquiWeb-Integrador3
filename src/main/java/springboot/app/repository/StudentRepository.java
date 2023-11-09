package springboot.app.repository;



import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Student;

import java.util.List;
import java.util.Optional;

@Repository("StudentRepository")
public interface StudentRepository extends JpaRepository<Student, Long> {


    boolean existsByDNI(Long dni);

    Optional<Student> findByDNI(Long dni);

    List<Student> findAllByOrderByName();





    /*public default List<Student> findAllByOrder() {
        return findAll(sortByIdAsc());
    }

    private Sort sortByIdAsc() {
        return new Sort(Sort.Direction.ASC, "id");
    }*/
}
