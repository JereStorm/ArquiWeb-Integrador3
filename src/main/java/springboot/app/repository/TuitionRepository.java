package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Tuition;

@Repository
public interface TuitionRepository extends JpaRepository<Tuition, Long> {


}
