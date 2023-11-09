package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Career;

import java.util.Optional;

@Repository("CareerRepository")
public interface CareerRepository extends JpaRepository<Career, Long> {
    boolean existsByName(String c);

    Optional<Career> findByName(String name);

    //A implentar

}
