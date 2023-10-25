package springboot.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.app.model.Career;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long> {

    //A implentar

}
